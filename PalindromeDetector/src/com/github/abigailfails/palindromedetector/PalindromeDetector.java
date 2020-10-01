package com.github.abigailfails.palindromedetector;

import java.util.Scanner;

public class PalindromeDetector {

    private static boolean isPalindrome(String word){
        //TODO: Write this, just parse like a char array
        String wordReversed = "";
        for(int i=word.length()-1; i>=0; i--){
            wordReversed += word.charAt(i);
        }
        return word.equals(wordReversed);
    }
    public static void main(String[] args) {
        String wordInput;
        Scanner input = new Scanner(System.in);
        boolean shouldContinue = true;

        while(shouldContinue) {
            System.out.println("Please enter a word to find out if it is a palindrome.");
            System.out.print("Word: ");
            wordInput = input.next();
            System.out.println(isPalindrome(wordInput) ? "That is a palindrome." : "That is not a palindrome");
            System.out.println("Do you want to check aniother word? (Y/N)");
            input.nextLine(); 
            String inputtedString = input.next();
            shouldContinue = (inputtedString.toUpperCase()).equals("Y");
        }
        System.out.println("Thank you for using Palindrome Checker!");
    }

}