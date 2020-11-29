package shapes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

//TODO design implementation that doesn't use try catches
public class InputHelper {
    private static final ArrayList<String> ALLOWED_TRUES = new ArrayList<>(Arrays.asList("y", "yes", "true"));
    private static final ArrayList<String> ALLOWED_FALSES = new ArrayList<>(Arrays.asList("n", "no", "false"));

    /**
     * Use for validating integers.
     * @param inputMessage the message to show to the user before requesting input, executed in a print statement;
     *                     new lines must be added via \n
     * @param inputSource where the input comes from
     **/
    public static int inputInteger(String inputMessage, String retryMessage, Scanner inputSource) {
        int inputtedNumber;
        System.out.print(inputMessage);
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
     * @param inputSource where the input comes from
     * @param lowerBound the lowest integer that should be accepted, inclusive
     * @param upperBound the highest integer that should be accepted, inclusive
     **/
    public static int inputBoundedInteger(String inputMessage, String retryMessage, Scanner inputSource, int lowerBound, int upperBound) {
        int inputtedNumber = 0;
        boolean needsRepeat = false;
        System.out.print(inputMessage);
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

}
