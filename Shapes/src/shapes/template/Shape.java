/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shapes.template;

/**
 *
 * @author dw
 */
public abstract class Shape {    
    public Shape() {
        System.out.println("Shape: " + this.toString());
    }

    public abstract String Name();

    public abstract double Area();
}
