package com.github.abigailfails.hangman;

import java.util.Scanner;

public class Hangman {
    //TODO use filestream for storing words and/or find console clearing system
    
    /**
     * Returns version of the word without the non-guessed characters.
     * If hasGuess is false, pass guess as null.
     */
    private static String updateWord(String fullWord, String inProgressWord, boolean hasGuess, String guess) {
        String output = "";
        boolean shouldPrintSpace = false;
        for(int i=0; i<fullWord.length(); i++) {    
            if(inProgressWord.charAt(i) != ('_')) {
                output += inProgressWord.charAt(i);
            }
            else if(hasGuess) { //TODO I don't like this, rewrite
                if(fullWord.charAt(i) == guess.charAt(0)) {
                    output += guess;
                }
                else shouldPrintSpace = true;
            }
            else shouldPrintSpace = true;   
            if(shouldPrintSpace) {
                output += "_";
            }
            //output += " ";
        }
        return output;
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String actualWord; 
        String guessInProgress = "";
        String guess;
        int guessesLeft = 5;
        
        System.out.println("Please enter a word to be guessed.");
        System.out.print("Word: ");
        actualWord = input.nextLine();
        for(int i=0; i<actualWord.length(); i++) {
            guessInProgress += "_";
        }
        guessInProgress = updateWord(actualWord, guessInProgress, false, null);
        for(int i=0; i<100; i++) System.out.println("\n");
        while(guessesLeft>0){
            System.out.println("You have "+guessesLeft+" guesses left.");
            System.out.println(guessInProgress);
            System.out.print("Guess: ");
            guess = input.nextLine();
            guessInProgress = updateWord(actualWord, guessInProgress, true, guess);
            if(!actualWord.contains(guess.toCharArray()))
        }
    } 
    
}
