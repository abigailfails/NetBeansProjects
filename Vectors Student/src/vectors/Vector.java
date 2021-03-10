/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vectors;

/**
 *
 * @author dw
 */
public class Vector implements IVector {
    private final double x;
    private final double y;

    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    @Override
    public double x() {
        return x;
    }
    
    @Override
    public double y() {
        return y;
    }    
    
    @Override
    public String toString() {
        return x() + ":" + y();
    }
}
