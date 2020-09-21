
package com.github.abigailfails.timestables;

import java.util.Scanner;
import java.util.InputMismatchException;

public class TimesTables {

    private static int inputNumber(Scanner inputSource){
        int inputtedNumber;
        try {
            inputtedNumber = inputSource.nextInt();
        }
        catch(InputMismatchException e){
            System.out.println("Please enter a whole number.");
            System.out.print("Number: ");
            inputSource.nextLine();
            inputtedNumber = inputNumber(inputSource);
        }
        return inputtedNumber;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int multipliedNumber;
        int upperLimit;
        boolean shouldContinue = true;
        while(shouldContinue) {
            System.out.println("Please enter the number you want to generate a times table for.");
            System.out.print("Number: ");
            multipliedNumber = inputNumber(input);
            System.out.println("Please enter the highest number to multiply that by.");
            System.out.print("Number: ");
            upperLimit = inputNumber(input);
            for(int i=1; i<=upperLimit; i++){
                System.out.println(i+" x "+multipliedNumber+" = "+(i*multipliedNumber));
            }
            System.out.println("Do you want to generate another table? (Y/N)");
            input.nextLine();
            String inputtedString = input.next();
            shouldContinue = (inputtedString.toUpperCase()).equals("Y");
        }
        System.out.println("Thank you for using Times Table Generator!");
    }

}
