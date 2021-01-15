package main.stacks;

import com.sun.javafx.collections.ImmutableObservableList;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InputHelper {
    private static final ImmutableObservableList<String> ALLOWED_TRUES = new ImmutableObservableList<>("y", "yes", "true");
    private static final ImmutableObservableList<String> ALLOWED_FALSES = new ImmutableObservableList<>("n", "no", "false");

    /**
     * Use for validating integers.
     * @param inputMessage the message to show to the user before requesting input, executed in a print statement;
     *                     new lines must be added via \n
     * @param retryMessage the message to show to the user if they enter invalid input. need to add new lines and
     *                     input prompts (e.g. "Value: ") manually
     * @param inputSource where the input comes from
     **/
    public static int inputInteger(String inputMessage, String retryMessage, Scanner inputSource) {
        System.out.print(inputMessage);
        int inputtedNumber;
        try {
            inputtedNumber = inputSource.nextInt();
        }
        catch(InputMismatchException e){
            inputSource.nextLine();
            inputtedNumber = inputInteger(retryMessage, retryMessage, inputSource);
        }
        System.out.println();
        return inputtedNumber;
    }

    /**
     * Use for validating integers with bounds.
     * @param inputMessage the message to show to the user before requesting input, executed in a print statement;
     *                     new lines must be added via \n
     * @param retryMessage the message to show to the user if they enter invalid input. need to add new lines and
     *                     input prompts (e.g. "Value: ") manually
     * @param inputSource where the input comes from
     * @param lowerBound the lowest integer that should be accepted, exclusive
     * @param upperBound the highest integer that should be accepted, exclusive
     **/
    public static int inputBoundedInteger(String inputMessage, String retryMessage, Scanner inputSource, int lowerBound, int upperBound) {
        System.out.print(inputMessage);
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
        System.out.println();
        inputSource.nextLine();
        if(needsRepeat){
            inputtedNumber = inputBoundedInteger(retryMessage, retryMessage, inputSource, lowerBound, upperBound);
        }
        return inputtedNumber;
    }

    /**
     * Use for validating booleans.
     * @param inputMessage the message to show to the user before requesting input, executed in a print statement;
     *                     new lines must be added via \n
     * @param retryMessage the message to show to the user if they enter invalid input. need to add new lines and
     *                     input prompts (e.g. "Value: ") manually
     * @param inputSource where the input comes from
     **/
    public static boolean inputBoolean(String inputMessage, String retryMessage, Scanner inputSource) {
        System.out.print(inputMessage);
        String input = inputSource.next();
        boolean output;
        if(ALLOWED_TRUES.contains(input.toLowerCase())) {
            output = true;
        }
        else if(ALLOWED_FALSES.contains(input.toLowerCase())) {
            output = false;
        }
        else output = inputBoolean(retryMessage, retryMessage, inputSource);
        System.out.println();
        return output;
    }

    /**
     * Inputs a string requiring re-input if empty
     * @param inputMessage the message to show to the user before requesting input, executed in a print statement;
     *                     new lines must be added via \n
     * @param retryMessage the message to show to the user if they enter invalid input. need to add new lines and
     *                     input prompts (e.g. "Value: ") manually
     * @param inputSource where to get input from
     * */
    public static String inputNonEmptyString(String inputMessage, String retryMessage, BufferedReader inputSource) {
        System.out.print(inputMessage);
        String input;
        boolean needsRepeat = false;
        try {
            input = inputSource.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        if(input.isEmpty()) needsRepeat = true;
        if (needsRepeat) {
            input = inputNonEmptyString(retryMessage, retryMessage, inputSource);
        }
        return input;
    }

    /**
     * Inputs a string requiring re-input if empty
     * @param inputMessage the message to show to the user before requesting input, executed in a print statement;
     *                     new lines must be added via \n
     * @param retryMessage the message to show to the user if they enter invalid input. need to add new lines and
     *                     input prompts (e.g. "Value: ") manually
     * @param inputSource where to get input from
     * */
    public static LocalDate inputLocalDate(String inputMessage, String retryMessage, Scanner inputSource) { //TODO add format param
        System.out.print(inputMessage);
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
            date = inputLocalDate(retryMessage, retryMessage, inputSource);
        }
        return date;
    }
}