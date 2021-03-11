package vectors.util;

import java.math.BigDecimal;

/**
 * Methods to help with maths.
 *
 * @author flowers
 * */
public class MathHelper {

    /**
     * Adds two doubles, avoiding floating-point error by using {@link BigDecimal}.
     *
     * @param a the first number to add
     * @param b the second number to add
     *
     * @return the sum of {@code a} and {@code b}
     */
    public static double add(double a, double b) {
        return BigDecimal.valueOf(a).add(BigDecimal.valueOf(b)).doubleValue();
    }

    /**
     * Multiplies two doubles, avoiding floating-point error by using {@link BigDecimal}.
     *
     * @param a the first number to multiply
     * @param b the second number to multiply
     *
     * @return the product of {@code a} and {@code b}
     */
    public static double multiply(double a, double b) {
        return BigDecimal.valueOf(a).multiply(BigDecimal.valueOf(b)).doubleValue();
    }
}
