package com.github.abigailfails.shapecalculator;

import com.github.abigailfails.shapecalculator.shapes.*;

import java.util.Scanner;

public class ShapeAreaCalculator {

    public IShape createShapeFromChoice(int choice, Scanner inputSource) {
        IShape shape;
        switch (choice) {
            case 1:
                shape = new Rectangle(inputSource);
                break;
            case 2:
                shape = new Circle(inputSource);
                break;
            case 3:
                shape = new Cylinder(inputSource);
                break;
            case 4:
                shape = new Cuboid(inputSource);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + choice);
        }
        return shape;
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int shapeChoice;
        IShape shape;
        System.out.println("Please choose a shape.");
        System.out.println("1 - Rectangle");
        System.out.println("2 - Circle");
        System.out.println("3 - Cylinder");
        System.out.println("4 - Cuboid\n");
        System.out.print("Number: ");
        shapeChoice = InputHelper.inputBoundedInteger(input, 1, 4);
        shape = new ShapeAreaCalculator().createShapeFromChoice(shapeChoice, input);
        System.out.println("Your " +shape.getName()+" has an area of "+shape.getArea()+".\n");

    }

    
}
