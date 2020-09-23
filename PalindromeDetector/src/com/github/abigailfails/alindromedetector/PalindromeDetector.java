package com.github.abigailfails.alindromedetector;

public class PalindromeDetector {

    private static boolean isPalindrome(String word){
        //TODO: Write this, just parse like a char array
    }

    public static void main(String[] args) {
        String wordInput;
        Scanner input = new Scanner(System.in);
        boolean shouldContinue;
        while(shouldContinue) {
            System.out.println("Please enter a word to find out if it is a palindrome.");
            System.out.print("Word: ");
            wordInput = input.read();
            System.out.println(isPalindrome(wordInput) ? "That is a palindrome." : "That is not a palindrome");
            System.out.println("Do you want to check aniother word? (Y/N)");
            input.nextLine(); 
            String inputtedString = input.next();
            shouldContinue = (inputtedString.toUpperCase()).equals("Y");
        }
        System.out.println("Thank you for using Times Table Generator!");
    }

}