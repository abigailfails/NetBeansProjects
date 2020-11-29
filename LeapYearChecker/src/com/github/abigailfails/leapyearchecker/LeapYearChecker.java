package com.github.abigailfails.leapyearchecker;

import java.util.Scanner;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;

public class LeapYearChecker {

    private static boolean isLeapYear(int year) {
        boolean flag = false;
        if(year%4==0){
            if(year%100==0){
                if(year%400==0){
                    flag = true;
                }
            }
            flag = true;
        }
        return flag;
    }

    public static void inputYear() {
        int inputtedYear;
        boolean isLeap;
        System.out.print("Year: ");
        try {
            Scanner input = new Scanner(System.in);
            inputtedYear = input.nextInt();
            if(inputtedYear != -1) {
                isLeap = isLeapYear(inputtedYear);
                System.out.println(isLeap ? "That is a leap year." : "That is not a leap year." + " Please enter another year to check, or type -1 to exit.");
                inputYear();
            }
        }
        catch(InputMismatchException e) {
            System.out.println("Please enter a number.");
            inputYear();
        }
        
    }

    public static void main(String[] args) {
        System.out.println("Please enter the year you want to check.");
        inputYear();
    }
    
}
