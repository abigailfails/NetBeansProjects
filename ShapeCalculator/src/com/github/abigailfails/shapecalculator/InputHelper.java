package com.github.abigailfails.shapecalculator;

import java.util.InputMismatchException;
import java.util.Scanner;

//TODO design implementation that doesn't use try catches
public class InputHelper {

    /**
     * Use for validating integers.
     * @param inputSource
     **/
    public static int inputInteger(Scanner inputSource) {
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
            inputtedNumber = inputInteger(inputSource);
        }
        return inputtedNumber;
    }

    /**
     * Use for validating integers with bounds.
     * @param inputSource
     * @param lowerBound
     * @param upperBound
     **/
    public static int inputBoundedInteger(Scanner inputSource, int lowerBound, int upperBound) {
        int inputtedNumber = 0;
        boolean needsRepeat = false;
        try {
            inputtedNumber = inputSource.nextInt();
            if(inputtedNumber<lowerBound||inputtedNumber>upperBound) {
                needsRepeat = true;
            }
        }
        catch(InputMismatchException e){
            needsRepeat = true;
        }
        if(needsRepeat){
            System.out.println("Please enter a number from "+lowerBound+"-"+upperBound+".");
            System.out.print("Number: ");
            inputSource.nextLine();
            inputtedNumber = inputBoundedInteger(inputSource, lowerBound, upperBound);
        }
        return inputtedNumber;
    }

}
