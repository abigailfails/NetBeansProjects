/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shapes.template;

import shapes.template.Shape;

/**
 *
 * @author dw
 */
public abstract class Polygon extends Shape {
    public Polygon() {
        System.out.println("Polygon: " + this.toString());        
    }
    
    @Override
    public abstract double Area();
                
    public abstract int Sides();
}
