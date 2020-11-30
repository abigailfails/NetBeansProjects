/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shapes.shapes;

import shapes.template.I2DShape;
import shapes.template.Polygon;

/**
 *
 * @author dw
 */
public class Triangle implements Polygon {
    private int base;
    private int height;
              
    public Triangle(int base, int height)
    {   
        this.base = base;
        this.height = height;
    }

    @Override
    public String Name() {
        return "triangle";
    }

    public double Area()
    {
        return 0.5 * base * height;        
    }

    @Override
    public int Sides() {
        return 3;
    }

    public int Base()
    {
        return base;        
    }
    
    public int Height()
    {
        return height;        
    }

}
