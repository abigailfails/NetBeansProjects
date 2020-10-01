package com.github.abigailfails.shapecalculator.shapes;

public class Circle implements IShape {
    private String name = "circle";
    private int radius;

    public Circle(int radiusIn) {
        radius = radiusIn;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int input) {
        radius = input;
    }

    public double getArea() {
        return radius*radius*Math.PI;
    }

    public String getName() {
        return name;
    }
}
