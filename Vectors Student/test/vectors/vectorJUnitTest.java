/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vectors;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dw
 */
public class vectorJUnitTest {          
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void add1() 
    {
        assertTrue("add(new Vector(6,9), new Vector(7,3))", IVector.add(new Vector(6,9), new Vector(7,3)).compareTo(new Vector(13.0, 12.0)) == 0);   
    }
    
    @Test
    public void add2() 
    {
        assertTrue("add(new Vector(3.6,5.4), new Vector(4.2,1.8))", IVector.add(new Vector(3.6,5.4), new Vector(4.2,1.8)).compareTo(new Vector(7.8, 7.2)) == 0);   
    }
    
    @Test
    public void multiply() 
    {
        assertTrue("multiply(5, new Vector(6,9))", IVector.multiply(5, new Vector(6,9)).compareTo(new Vector(30.0, 45.0)) == 0);        
    }
    
    @Test
    public void dotProduct() 
    {
        assertEquals("dotProduct(new Vector(6,9), new Vector(7,3))", 69, IVector.dotProduct(new Vector(6,9), new Vector(7,3)));              
    }
    
    @Test
    public void convexCombination1() 
    {        
        assertTrue("convexCombination(0.4, new Vector(6,9), 0.6 ,new Vector(7,3))", IVector.convexCombination(0.4, new Vector(6,9), 0.6 ,new Vector(7,3)).compareTo(new Vector(6.6, 5.4)) == 0);  
    }
    
    @Test
    public void convexCombination2() 
    {
        assertTrue("convexCombination(0.3, new Vector(6,9), 0.7 ,new Vector(7,3))", IVector.convexCombination(0.3, new Vector(6,9), 0.7 ,new Vector(7,3)).compareTo(new Vector(6.7, 4.8)) == 0);          
    }
}
