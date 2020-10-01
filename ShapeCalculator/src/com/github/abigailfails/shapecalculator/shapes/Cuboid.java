package com.github.abigailfails.shapecalculator.shapes;

public class Cuboid implements IShape{
    private String name = "cuboid";
    private int length;
    private int width;
    private int height;

    public Cuboid(int lengthIn, int widthIn, int heightIn) {
        length = lengthIn;
        width = widthIn;
        height = heightIn;
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

    public int getHeight() {
        return height;
    }

    public void setHeight(int input) {
        height = input;
    }

    public double getArea() {
        return 2*((length*width)+(length*height)+(height*width));
    }

    public String getName() {
        return name;
    }
}
