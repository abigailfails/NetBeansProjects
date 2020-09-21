package com.github.abigailfails.numberguessinggame;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random;

public class NumberGuessingGame {

    private static int inputNumber(Scanner inputSource){
        int inputtedNumber = 0;
        boolean needsRepeat;
        try {
            inputtedNumber = inputSource.nextInt();
            needsRepeat = (inputtedNumber<1 || inputtedNumber>10);
        }
        catch(InputMismatchException e){
            needsRepeat = true;
        }
        if(needsRepeat){
            System.out.println("Please enter a whole number from 1 to 10.");
            System.out.print("Number: ");
            inputSource.nextLine();
            inputtedNumber = inputNumber(inputSource);
        }
        return inputtedNumber;
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int inputtedNumber;
        int generatedNumber;
        boolean guessedCorrectly = false;
        boolean shouldContinue = true;
        while(shouldContinue) {
            generatedNumber = new Random().nextInt(9) + 1;
            System.out.println("I've chosen a number from 1 to 10. Can you guess what it is?");
            for(int i=5; i>0; i--) {
                System.out.println("You have "+i+" guesses left.");
                System.out.print("Number: ");
                inputtedNumber = inputNumber(console);
                guessedCorrectly = (inputtedNumber == generatedNumber);
                if(guessedCorrectly){
                    System.out.println("Well done, you guessed correctly! :D");
                    break;
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
        System.out.println("Thank you for using Times Table Generator!");
    }

}
