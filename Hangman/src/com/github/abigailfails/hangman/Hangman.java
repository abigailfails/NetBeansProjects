package com.github.abigailfails.hangman;

import java.util.Scanner;

public class Hangman {
    //TODO use filestream for storing words and/or find console clearing system
    
    /**
     * Returns version of the word without the non-guessed characters.
     */
    private static String updateWord(String fullWord, String inProgressWord, String guess) {
        String output = "";
        boolean shouldPrintUnderscore = false;
        for(int i=0; i<fullWord.length(); i++) {    
            if(inProgressWord.charAt(i) == ('_')) {
                if(guess != null) { //TODO REWRITE THIS LOGIC, also need to fix what happens when space in string
                    if(fullWord.charAt(i) == guess.charAt(0)) {
                        output += guess;
                    }
                    else shouldPrintUnderscore = true;
                }
                output += inProgressWord.charAt(i);
            }

            else shouldPrintUnderscore = true;   
            if(shouldPrintUnderscore) {
                output += "_";
            }
            //output += " "; TODO this doesn't work
        }
        return output;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String actualWord; 
        String guessInProgress = "";
        String guess;
        String guessedLetters = "";
        int guessesLeft = 5;
        
        System.out.println("Please enter a word to be guessed.");
        System.out.print("Word: ");
        actualWord = input.nextLine();
        for(int i=0; i<actualWord.length(); i++) {
            guessInProgress += "_";
        }
        guessInProgress = updateWord(actualWord, guessInProgress, null);
        for(int i=0; i<100; i++) System.out.println("\n");
        while(guessesLeft>0){
            System.out.println("Please enter a single letter that you think is in the word.");
            System.out.println("You have "+guessesLeft+" wrong guesses left.");
            if(!guessedLetters.isEmpty()) System.out.println("So far you've guessed '"+guessedLetters+"'");
            System.out.println(guessInProgress);
            System.out.print("Guess: ");
            guess = input.nextLine();
            System.out.println();
            guessInProgress = updateWord(actualWord, guessInProgress, guess);
            if(actualWord.equals(guessInProgress)){
                System.out.println("Well done, you've worked out that the word was " +actualWord+"!");
                break;
            }
            if(guessedLetters.contains(guess)&&!guessedLetters.isEmpty()) {
                System.out.println("You've already guessed that??!!!?!?!\n");
                guessesLeft--;
            }
            else if(!actualWord.contains(guess)) {
                System.out.println("That's not right!\n");
                guessesLeft--;
            }
            guessedLetters += guessedLetters.isEmpty() ? guess : "," + guess;
        }
        if(guessesLeft==0){
            System.out.println("Oh no, you didn't guess the word. It was "+actualWord+".");
        }
    } 
    
}