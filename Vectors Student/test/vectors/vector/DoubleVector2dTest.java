/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vectors.vector;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 * @author dw
 */
public class DoubleVector2dTest {
    @Test
    public void add1() {
        assertEquals("add(new Vector(6,9), new Vector(7,3))", Vector2.add(new Vector2d(6, 9), new Vector2d(7, 3)), new Vector2d(13.0, 12.0));
    }
    
    @Test
    public void add2() {
        assertEquals("add(new Vector(3.6,5.4), new Vector(4.2,1.8))", Vector2.add(new Vector2d(3.6, 5.4), new Vector2d(4.2, 1.8)), new Vector2d(7.8, 7.2));
    }
    
    @Test
    public void multiply() {
        assertEquals("multiply(5, new Vector(6,9))", Vector2.multiply(5, new Vector2d(6, 9)), new Vector2d(30.0, 45.0));
    }
    
    @Test
    public void dotProduct() {
        assertEquals("dotProduct(new Vector(6,9), new Vector(7,3))", Vector2.dotProduct(new Vector2d(6, 9), new Vector2d(7, 3)), 69, 0.0);
    }
    
    @Test
    public void convexCombination1() {
        assertEquals("convexCombination(0.4, new Vector(6,9), 0.6 ,new Vector(7,3))", Vector2.convexCombination(0.4, new Vector2d(6, 9), 0.6, new Vector2d(7, 3)), new Vector2d(6.6, 5.4));
    }
    
    @Test
    public void convexCombination2() {
        assertEquals("convexCombination(0.3, new Vector(6,9), 0.7 ,new Vector(7,3))", Vector2.convexCombination(0.3, new Vector2d(6, 9), 0.7, new Vector2d(7, 3)), new Vector2d(6.7, 4.8));
    }
}
