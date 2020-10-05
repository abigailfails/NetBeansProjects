package horoscope;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InputHelper {

    /**
     * Use for validating integers with bounds.
     *
     * @param inputSource where to get input from
     * @param lowerBound returns false if input is less than this
     * @param upperBound returns false if input is greater than this
     * @param inputType what type of data to tell the user to re-enter
     **/
    public static int inputBoundedInteger(Scanner inputSource, int lowerBound, int upperBound, String inputType) {
        int inputtedNumber = 0;
        boolean needsRepeat = false;

        try {
            inputtedNumber = inputSource.nextInt();
            if (inputtedNumber < lowerBound || inputtedNumber > upperBound) {
                needsRepeat = true;
            }
        } catch (InputMismatchException e) {
            needsRepeat = true;
        }
        if (needsRepeat) {
            System.out.println("\nPlease enter a "+inputType+" from " + lowerBound + " - " + upperBound + ".");
            System.out.print(inputType.substring(0,1).toUpperCase()+inputType.substring(1)+": ");
            inputSource.nextLine();
            inputtedNumber = inputBoundedInteger(inputSource, lowerBound, upperBound, inputType);
        }
        return inputtedNumber;
    }

    /**
     * Inputs a string requiring re-input if empty
     * @param inputSource where to get input from
     * @param inputType what type of data to tell the user to re-enter
     * */
    public static String inputNonEmptyString(BufferedReader inputSource, String inputType) {
        String input = null;
        boolean needsRepeat = false;

        try {
            input = inputSource.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(input.isEmpty()) needsRepeat = true;
        if (needsRepeat) {
            inputType = inputType.toLowerCase();
            System.out.println("\nPlease enter a "+inputType+" that is not empty.");
            System.out.print(inputType.substring(0,1).toUpperCase()+inputType.substring(1)+": ");
            input = inputNonEmptyString(inputSource, inputType);
        }
        return input;
    }

    /**
     * Inputs a string requiring re-input if empty
     * @param inputSource where to get input from
     * @param inputType what type of data to tell the user to re-enter, e.g. birthday. Leave as date if none exists.
     * */
    public static LocalDate inputLocalDate(Scanner inputSource, String inputType) {
        String input;
        LocalDate date = null;
        boolean needsRepeat = false;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        input = inputSource.next();
        try {
            date = LocalDate.parse(input, formatter);
        }
        catch (DateTimeException e) {
            needsRepeat = true;
        }
        if (needsRepeat) {
            inputType = inputType.toLowerCase();
            System.out.println("\nPlease enter a "+inputType+" with the format DD/MM/YYYY.");
            System.out.print(inputType.substring(0,1).toUpperCase()+inputType.substring(1)+": ");
            date = inputLocalDate(inputSource, inputType);
        }
        return date;
    }

}


