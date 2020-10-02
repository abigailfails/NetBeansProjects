package com.github.abigailfails.shapecalculator.shapes;

import com.github.abigailfails.shapecalculator.InputHelper;

import java.util.Scanner;

public class Cylinder implements IShape {
    private String name = "cylinder";
    private int radius;
    private int height;

    public Cylinder(Scanner inputSource) {
        System.out.println("Please enter the cylinder's radius.");
        System.out.print("Radius: ");
        radius = InputHelper.inputInteger(inputSource);
        System.out.println("Please enter the cylinder's height.");
        System.out.print("Height: ");
        height = InputHelper.inputInteger(inputSource);
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
