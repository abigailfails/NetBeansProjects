package com.github.abigailfails.shapecalculator.shapes;

import com.github.abigailfails.shapecalculator.InputHelper;

import java.util.Scanner;

public class Rectangle implements IShape {
    private String name = "rectangle";
    private int length;
    private int width;
    
    public Rectangle(Scanner inputSource) {
        System.out.println("Please enter the rectangle's length.");
        System.out.print("Length: ");
        length = InputHelper.inputInteger(inputSource);
        System.out.println("Please enter the rectangle's width.");
        System.out.print("Width: ");
        width = InputHelper.inputInteger(inputSource);
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
