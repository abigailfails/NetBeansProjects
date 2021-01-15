package com.github.abigailfails.palindromes;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    private static boolean isPalindrome(String word) {
        char[] letters = word.toCharArray();
        int length = letters.length;
        for (int i=0; i<length/2; i++) {
            if(letters[i] != letters[length-(i+1)]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(reader);
        boolean shouldContinue = true;
        while (shouldContinue) {
            boolean isPalindrome = isPalindrome(Objects.requireNonNull(InputHelper.inputNonEmptyString(
                    "Please enter a word to see if it is a palindrome.\n\nWord: ",
                    "Please enter a non-empty word\n\nWord: ", reader)));
            System.out.println("Your word is " + (isPalindrome ? "" : "not ") + "a palindrome.\n");
            shouldContinue = InputHelper.inputBoolean("Do you want to enter another word? (y/n)\n\nAnswer: ", "\nInvalid answer. Please type y for yes or n for no.\n\nAnswer: ", scanner);
        }
    }
}
