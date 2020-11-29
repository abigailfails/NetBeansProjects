package com.github.abigailfails.projectcreation;

import java.util.Scanner;

public class ProjectCreation {

    private static boolean compareIntegers(int int1, int int2) {
        return int1 == int2;
    }
    
    private static boolean isInteger(String string) {
        try {
            Integer.parseInt(string);
        }
        catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        int computerValue = 4;
        Scanner inputSource = new Scanner(System.in);
        String input;
        input = inputSource.next();
        if(isInteger(input)) {
            if(compareIntegers(computerValue,Integer.parseInt(input))) {
                System.out.println("You guessed correctly.");
            }
        }
    }
}
