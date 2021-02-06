package com.github.abigailfails.snakecase;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please type a string in PascalCase or camelCase to convert to snake_case\n\nString: ");
        System.out.println("\nYou typed: '" + snakeCase(scanner.nextLine()) + "'.");
    }

    /**
     * Converts {@code PascalCase} or {@code camelCase} strings to a {@code snake_case} format.
     * <p>Can insert underscores between a lowercase letter and a capital letter <b>or</b> a number,
     * or alternatively between a capital letter and a number.</p>
     * <p>e.g:<br>
     *        fgaAbc -> fga_abc  <br>
     *        era09  -> era_09   <br>
     *        kiAN0  -> ki_an_0  <br>
     *        sy70p  -> sy_70p   <br>
     *        sy70P  -> sy_70_p  </p>
     *
     * @param string the string to format
     * @return {@code string}, formatted into snake case
     *
     * @author abigailfails
     *
     */
    public static String snakeCase(String string) {
        return string.replaceAll("((?<=[a-z])([A-Z]|[0-9]))|((?<=[0-9])[A-Z])|((?<=[A-Z])[0-9])", "_$0").toLowerCase();
    }
}
