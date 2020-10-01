package com.github.abigailfails.caesarcipher;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CaesarCipher {

    private static boolean cryptText(String word) {
        //TODO: Write this, just parse like a char array
        String wordReversed = "";
        for(int i=word.length()-1; i>=0; i--){
            wordReversed += word.charAt(i);
        }
        return word.equals(wordReversed);
    }

    /*private static boolean validateChoice(Scanner inputSource) {
        String input;
        boolean needsRepeat = false;
        boolean answeredYes;
        input = inputSource.nextLine().toUpperCase();
        if(input=="E"){
            answeredYes = true;
        }
        else if(input=="D"){
            answeredYes = false;
        }
        else
            System.out.println("Please enter either E for encrypt or D for decrypt.");
            System.out.print("Choice: ");
            inputSource.nextLine();
            answeredYes =
        }
        return answeredYes;
    }*/

    public static void main(String[] args) {
        String wordInput;
        boolean isEncrypt;
        Scanner input = new Scanner(System.in);
        boolean shouldContinue = true;
        while(shouldContinue) {
            System.out.println("Do you want to encrypt, or decrypt a message? ");
            System.out.print("Choice: ");
            wordInput = input.next();
            //System.out.println(isPalindrome(wordInput) ? "That is a palindrome." : "That is not a palindrome");
            System.out.println("Do yuo want to check another word? (Y/N)");
            input.nextLine();
            String inputtedString = input.next();
            shouldContinue = (inputtedString.toUpperCase()).equals("Y");
        }
        System.out.println("Thank you for using Caesar Cipher Decoder!");
    }
    
}
