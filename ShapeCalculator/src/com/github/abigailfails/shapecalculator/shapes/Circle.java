package com.github.abigailfails.shapecalculator.shapes;

import com.github.abigailfails.shapecalculator.InputHelper;

import java.util.Scanner;

public class Circle implements IShape {
    private String name = "circle";
    private int radius;

    public Circle(Scanner inputSource) {
        System.out.println("Please enter the circle's radius.");
        System.out.print("Radius: ");
        radius = InputHelper.inputInteger(inputSource);
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
