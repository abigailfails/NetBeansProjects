package com.github.abigailfails.numberguessinggame;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random;

public class NumberGuessingGame {

    /**
     * Use for validating generic integers.
     **/
    private static int inputNumber(Scanner inputSource) {
        int inputtedNumber = 0;
        boolean needsRepeat = false;
        try {
            inputtedNumber = inputSource.nextInt();
        }
        catch(InputMismatchException e){
            needsRepeat = true;
        }
        if(needsRepeat){
            System.out.println("Please enter a whole number.");
            System.out.print("Number: ");
            inputSource.nextLine();
            inputtedNumber = inputNumber(inputSource);
        }
        return inputtedNumber;
    }
    
    /**
     * Use for validating guesses.
     **/
    private static int inputGuess(Scanner inputSource, int upperBound) {
        int inputtedNumber = 0;
        boolean needsRepeat = false;
        try {
            inputtedNumber = inputSource.nextInt();
            needsRepeat = (inputtedNumber<1 || inputtedNumber>upperBound);
        }
        catch(InputMismatchException e){
            needsRepeat = true;
        }
        if(needsRepeat){
            System.out.println("Please enter a whole number from 1 to "+upperBound+".");
            System.out.print("Number: ");
            inputSource.nextLine();
            inputtedNumber = inputGuess(inputSource, upperBound);
        }
        return inputtedNumber;
    }
    
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int upperBound;
        int maxGuesses;
        int inputtedNumber;
        int generatedNumber;
        boolean guessedCorrectly = false;
        boolean shouldContinue = true;
        while(shouldContinue) {
            System.out.println("Please enter the upper bound for the number I'll choose.");
            System.out.print("Number: ");
            upperBound = inputNumber(console);
            System.out.println("Please enter the maximum number of guesses you get.");
            System.out.print("Number: ");
            maxGuesses = inputNumber(console);
            generatedNumber = new Random().nextInt(upperBound-1) + 1;
            System.out.println("I've chosen a number from 1 to "+upperBound+". Can you guess what it is?");
            for(int i=maxGuesses; i>0; i--) {
                System.out.println("You have "+i+" guesses left.");
                System.out.print("Number: ");
                inputtedNumber = inputGuess(console, upperBound);
                guessedCorrectly = (inputtedNumber == generatedNumber);
                if(guessedCorrectly){
                    System.out.println("Well done, you guessed correctly! :D");
                    break;
                }
                else{
                    System.out.print(inputtedNumber<generatedNumber ? "You guessed too low. " : "You guessed too high. ");
                }
            }
            if(!guessedCorrectly) {
                System.out.println("You couldn't guess my number. :( It was "+generatedNumber+"!");
            }
            System.out.println("Do you want to guess another number? (Y/N)");
            console.nextLine();
            String inputtedString = console.next();
            shouldContinue = (inputtedString.toUpperCase()).equals("Y");
        }
        System.out.println("Thank you for using Number Guessing Software!");
    }

}
