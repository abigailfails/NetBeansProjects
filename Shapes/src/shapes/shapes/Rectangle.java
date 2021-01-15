/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shapes.shapes;

import shapes.Main;

/**
 *
 * @author dw
 */
public class Rectangle extends Parallelogram {
            
    public Rectangle() {
        System.out.println("Rectangle: " + this.toString());
        Main.shapeNames.put("Rectangle", this.getClass());
    }
    
    public Rectangle(int width, int length)
    {   
        this();
        this.base = width;
        this.length = length;
    }

    @Override
    public int Sides()
    {
        return 4;              
    }
    
    @Override
    public double Area()
    {
        return length * base;
    }

    @Override
    public int Length() {
        return length;
    }
    
    public int Width() {
        return base;
    }

}
