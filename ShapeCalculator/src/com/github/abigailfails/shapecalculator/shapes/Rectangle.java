package com.github.abigailfails.shapecalculator.shapes;

public class Rectangle implements IShape {
    private String name = "rectangle";
    private int length;
    private int width;
    
    public Rectangle(int lengthIn, int widthIn) {
        length = lengthIn;
        width = widthIn;
    }
    
    public int getLength() {
        return length;
    }

    public void setLength(int input) {
        length = input;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int input) {
        width = input;
    }

    public double getArea() {
        return length*width;
    }

    public String getName() {
        return name;
    }

}
