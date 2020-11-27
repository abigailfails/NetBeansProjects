package shapes;

import java.util.InputMismatchException;
import java.util.Scanner;

//TODO design implementation that doesn't use try catches
public class InputHelper {

    /**
     * Use for validating integers.
     * @param inputMessage the message to show to the user before requesting input, executed in a print statement;
     *                     new lines must be added via \n
     * @param inputSource where the input comes from
     **/
    public static int inputInteger(String inputMessage, Scanner inputSource) {
        int inputtedNumber;
        System.out.print(inputMessage);
        try {
            inputtedNumber = inputSource.nextInt();
        }
        catch(InputMismatchException e){
            inputtedNumber = inputInteger("Please enter a whole number.\nNumber: ", inputSource);
        }
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
    public static int inputBoundedInteger(String inputMessage, Scanner inputSource, int lowerBound, int upperBound) {
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
        if(needsRepeat){
            inputtedNumber = inputBoundedInteger("Please enter a number from "+lowerBound+"-"+upperBound+".\nNumber: ", inputSource, lowerBound, upperBound);
        }
        return inputtedNumber;
    }

}
