/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shapes.shapes;

import shapes.template.IPolygon;

/**
 *
 * @author dw
 */
public class Rectangle implements IPolygon {
    protected int length = 0;
    protected int width = 0;
            
    public Rectangle()
    {   
        System.out.println("Rectangle: " + this.toString());          
    }
    
    public Rectangle(int length, int width)
    {   
        this();
        this.length = length;
        this.width = width;
    }

    @Override
    public  String Name() {
        return "rectangle";
    }

    @Override
    public int Sides()
    {
        return 4;              
    }
    
    @Override
    public double Area()
    {
        return length * width;        
    }
    
    public int Length()
    {
        return length;        
    }
    
    public int Width()
    {
        return width;        
    }

}
