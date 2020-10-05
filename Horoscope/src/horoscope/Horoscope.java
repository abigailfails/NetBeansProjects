package horoscope;

import com.sun.javafx.scene.traversal.SubSceneTraversalEngine;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.Scanner;

/**
 * @author T-flowers
 */
public class Horoscope {


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String name;
        LocalDate birthday;
        boolean shouldContinue = true;

        System.out.println("Welcome to your daily Horoscope.");
        while(shouldContinue) {
            System.out.println("1 - Display Horoscope");
            System.out.println("2 - Exit");
            System.out.print("Choice: ");
            if (InputHelper.inputBoundedInteger(input, 1, 2, "choice")==2) {
                break;
            }
            System.out.println("\nWhat's your name?");
            System.out.print("Name: ");
            name = InputHelper.inputNonEmptyString(new BufferedReader(new InputStreamReader(System.in)), "name");
            System.out.println("\nWhat's your birthday? (DD/MM/YYYY)");
            System.out.print("Birthday: ");
            birthday = InputHelper.inputLocalDate(input, "birthday");
            StarSign sign = new StarSign(birthday);
            System.out.println("\nHello "+name+", here is your "+sign.getSign()+" horoscope for today:\n");
            System.out.println(sign.getMessage()+"\n");
            System.out.println("Do you want to see another Horoscope?");
        }
    }

}
