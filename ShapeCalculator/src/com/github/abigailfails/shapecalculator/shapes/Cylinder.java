package com.github.abigailfails.shapecalculator.shapes;

public class Cylinder implements IShape {
    private String name = "cylinder";
    private int radius;
    private int height;

    public Cylinder(int radiusIn, int heightIn) {
        radius = radiusIn;
        height = heightIn;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int input) {
        radius = input;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int input) {
        height = input;
    }

    public double getArea() {
        return (2*Math.PI*radius*height)+(2*Math.PI*radius);
    }

    public String getName() {
        return name;
    }
}
