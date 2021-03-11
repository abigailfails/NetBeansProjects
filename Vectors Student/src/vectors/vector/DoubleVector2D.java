/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vectors.vector;

/**
 * Implementation of {@link Vector2D} using double values.
 *
 * @author dw, flowers
 */
public class DoubleVector2D extends Vector2D {
    private final double x;
    private final double y;

    public DoubleVector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Gives the x value of the vector.
     *
     * @return the vector's x coordinate
     */
    @Override
    public double x() {
        return x;
    }

    /**
     * Gives the y value of the vector.
     *
     * @return the vector's y coordinate
     */
    @Override
    public double y() {
        return y;
    }

    /**
     * Checks whether the inputted object equals this object
     * <p>If o is a vector, compares both {@code} x and {@code y} values.</p>
     *
     * @param o the object to compare this vector
     *
     * @return whether {@code o} is a vector and equals this vector
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        else if (o instanceof Vector2D) {
            Vector2D vector = (Vector2D) o;
            return x() == vector.x() && y() == vector.y() && !(x() == 0 && y() == 0);
        }
        return false;
    }

    /**
     * Formats this vector's values into a string.
     *
     * @return this vector in string format
    */
    @Override
    public String toString() {
        return x() + ":" + y();
    }
}
