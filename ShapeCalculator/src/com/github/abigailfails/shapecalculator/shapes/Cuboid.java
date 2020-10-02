package com.github.abigailfails.shapecalculator.shapes;

import com.github.abigailfails.shapecalculator.InputHelper;

import java.util.Scanner;

public class Cuboid implements IShape{
    private String name = "cuboid";
    private int length;
    private int width;
    private int height;

    public Cuboid(Scanner inputSource) {
        System.out.println("Please enter the cuboid's length.");
        System.out.print("Length: ");
        length = InputHelper.inputInteger(inputSource);
        System.out.println("Please enter the cuboid's width.");
        System.out.print("Width: ");
        width = InputHelper.inputInteger(inputSource);
        System.out.println("Please enter the cuboid's height.");
        System.out.print("Height: ");
        height = InputHelper.inputInteger(inputSource);
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
