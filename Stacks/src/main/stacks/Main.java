package main.stacks;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
        ArrayList<Integer> test = new ArrayList<>();
        test.add(1);
        test.add(8);
        test.add(4);
        test.add(5);
        test.add(3);
        for (int i=0; i<test.size(); i++) {
            if (test.get(i)<5) {
                test.remove((int)i);
            }
        }
        System.out.println(test.toString());
    }
}
