package vectors.vector;

import vectors.util.MathHelper;

/**
 * A double 2-vector specification, with static methods for addition, multiplication, dot product and convex combination.
 *
 * @author dw, flowers
 */
public abstract class AbstractVector2d {

    /**
     * Gives the x value of the vector.
     *
     * @return the vector's x coordinate
     */
    public abstract double x();

    /**
     * Gives the y value of the vector.
     *
     * @return the vector's y coordinate
     */
    public abstract double y();

    /**
     * Adds two vectors, returning a new vector that is the sum of both.
     *
     * @param a the first vector to add
     * @param b the second vector to add
     *
     * @return the sum of {@code a} and {@code b}
     */
    public static AbstractVector2d add(AbstractVector2d a, AbstractVector2d b) {
        return new Vector2d(MathHelper.add(a.x(), b.x()), MathHelper.add(a.y(), b.y()));
    }

    /**
     * Multiplies a vector by a scalar, returning a new vector as the result.
     *
     *
     * @param a the vector to multiply
     * @param scalar the value to multiply {@code a} by
     *
     * @return {@code a} multiplied by {@code b}
     */
    public static AbstractVector2d multiply(double scalar, AbstractVector2d a) {
        return new Vector2d(MathHelper.multiply(a.x(), scalar), MathHelper.multiply(a.y(), scalar));
    }

    /**
     * Multiplies two vectors, returning their dot product.
     *
     * @param a the first vector to multiply
     * @param b the second vector to multiply
     *
     * @return the dot product of {@code a} and {@code b}
     */
    public static double dotProduct(AbstractVector2d a, AbstractVector2d b) {
        return MathHelper.add(MathHelper.multiply(a.x(), b.x()), MathHelper.multiply(a.y(), b.y()));
    }

    /**
     * Returns the convex combination vector of two vectors and two corresponding scalars.
     * <p>This means that the two vectors are multiplied by their scalars, then added.</p>
     *
     * @param scalara the value to multiply {@code a} by
     * @param a the first vector to add
     * @param scalarb the value to multiply {@code b} by
     * @param b the second vector to add
     *
     * @return the convex combination {@code a} and {@code b}
     */
    public static AbstractVector2d convexCombination(double scalara, AbstractVector2d a, double scalarb, AbstractVector2d b) {
        if (scalara + scalarb == 1 && scalara >= 0 && scalarb >= 0)
            return add(multiply(scalara, a), multiply(scalarb, b));
        else throw new IllegalArgumentException("Invalid scalar values");
    }

    /**
     * Checks whether the inputted object equals this object
     * <p>If o is a vector, compares both {@code} x and {@code y} values.</p>
     *
     * @param o the object to compare this vector
     *
     * @return whether {@code o} is a vector and equals this vector
     */
    public boolean equals(Object o) {
        if (this == o)
            return true;
        else if (o instanceof AbstractVector2d) {
            AbstractVector2d vector = (AbstractVector2d) o;
            return x() == vector.x() && y() == vector.y() && !(x() == 0 && y() == 0);
        }
        return false;
    }
}
