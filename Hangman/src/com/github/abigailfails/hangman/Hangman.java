package com.github.abigailfails.hangman;

import java.util.Scanner;

public class Hangman {

    /**
     * Inputs a word, an 'in-progress' version of that word where some of the characters are underscores,
     * and a 'guess' character,
     * Returns the in-progress word, but if the full word contains the guess, underscores at that position in the
     * in progress word are replaced with that character.
     */
    private static String updateWord(String fullWord, String inProgressWord, String guess) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < fullWord.length(); i++) {
            boolean shouldPrintUnderscore = false;
            if (inProgressWord.charAt(i) == ('_')) {
                if (guess != null) {
                    if (fullWord.charAt(i) == guess.charAt(0)) {
                        output.append(guess);
                    } else shouldPrintUnderscore = true;
                } else shouldPrintUnderscore = true;
                if (shouldPrintUnderscore) {
                    output.append("_");
                }
            } else {
                output.append(inProgressWord.charAt(i));
            }
        }
        return output.toString();
    }

    /**
     * Returns a string with spaces after each character.
     * */
    public static String addSpaces(String input) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            output.append(input.charAt(i)).append(" ");
        }
        return output.toString();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String actualWord;
        String guessInProgress = "";
        String guessedLetters = "";
        String guess;
        int guessesLeft = 5;

        System.out.println("Please enter a word to be guessed.");
        System.out.print("Word: ");
        actualWord = input.nextLine().toLowerCase();
        for (int i = 0; i < actualWord.length(); i++) { //sets up the word with underscores instead of letters
            guessInProgress += (actualWord.charAt(i) == ' ') ? " " : "_";
        }
        guessInProgress = updateWord(actualWord, guessInProgress, null);
        for (int i = 0; i < 100; i++) System.out.println("\n");
        System.out.println("Please enter a single letter that you think is in the word.");
        while (guessesLeft > 0) {
            System.out.print("You have " + guessesLeft + " wrong guesses left. ");
            if (!guessedLetters.isEmpty()) System.out.println("So far you've guessed '" + guessedLetters + "'");
            System.out.println(addSpaces(guessInProgress));
            System.out.print("Guess: ");
            guess = input.nextLine().toLowerCase();
            System.out.println();
            if(guess.length()>1) {
                guess = guess.substring(0,1);
                System.out.print("You typed more than one character, so only '"+guess+"' was counted. ");
            }
            guessInProgress = updateWord(actualWord, guessInProgress, guess);
            if (actualWord.equals(guessInProgress)) {
                System.out.println("Well done, you've worked out that the word was " + actualWord + "!");
                break;
            }
            if (guessedLetters.contains(guess) && !guessedLetters.isEmpty()) {
                System.out.print("You've already guessed that??!!!?!?!\n");
                guessesLeft--;
            } else if (!actualWord.contains(guess)) {
                System.out.print("That's not right!\n");
                guessesLeft--;
            } else {
                System.out.print("You guessed correctly!\n");
            }
            guessedLetters += guessedLetters.isEmpty() ? guess : "," + guess;
        }
        if (guessesLeft == 0) {
            System.out.println("Oh no, you didn't guess the word. It was " + actualWord + ".");
        }
    }
}