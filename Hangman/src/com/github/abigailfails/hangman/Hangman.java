package com.github.abigailfails.hangman;

import java.util.ArrayList;
import java.util.Scanner;

public class Hangman {
    //TODO use filestream for storing words and/or find console clearing system
    
    /**
     * Returns version of the word without the non-guessed characters
     */
    private static String updateWord(String fullWord, String guessedWord, Character guess) {
        String output = "";
        for(int i=0; i<fullWord.length(); i++) {
            if(fullWord.charAt(i) == guess) {
                output += guess;
            }
            else{
                output += "_";
            }
            output += " ";
        }
        return output;
    }
    //TODO redo this implementation it's a rabbit hole
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String actualWord; 
        String guessInProgress = "";
        ArrayList<Character> guessedChars = new ArrayList<>();
        int guessesLeft = 5;
        
        System.out.println("Please enter a word to be guessed.");
        System.out.print("Word: ");
        actualWord = input.nextLine();
        guessInProgress = updateWord(actualWord, guessInProgress, null);
        for(int i=0; i<100; i++) System.out.println("\n");
        while(guessesLeft>0){
            System.out.println("You have "+guessesLeft+" guesses left.");
            System.out.println(guessInProgress);
        }
    } 
    
}
