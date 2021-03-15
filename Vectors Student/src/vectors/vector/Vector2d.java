/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vectors.vector;

/**
 * Implementation of {@link Vector2} using double values.
 *
 * @author dw, flowers
 */
public class Vector2d extends Vector2 {
    private final double x;
    private final double y;

    public Vector2d(double x, double y) {
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
     * Formats this vector's values into a string.
     *
     * @return this vector in string format
    */
    @Override
    public String toString() {
        return x() + ":" + y();
    }
}
