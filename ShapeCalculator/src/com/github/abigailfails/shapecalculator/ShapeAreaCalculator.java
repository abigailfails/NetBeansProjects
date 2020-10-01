package com.github.abigailfails.shapecalculator;

import com.github.abigailfails.shapecalculator.shapes.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ShapeAreaCalculator {

    /**
     * Use for validating generic integers, or shape selections from 1-4
     **/
    private static int inputInteger(Scanner inputSource, boolean isShapeSelection) {
        int inputtedNumber = 0;
        boolean needsRepeat = false;
        try {
            inputtedNumber = inputSource.nextInt();
            if((isShapeSelection)&(inputtedNumber<1||inputtedNumber>4)) {
                needsRepeat = true;
            }
        }
        catch(InputMismatchException e){
            needsRepeat = true;
        }
        if(needsRepeat){
            System.out.println(isShapeSelection ? "Please enter a number from 1-4." : "Please enter a whole number.");
            System.out.print("Number: ");
            inputSource.nextLine();
            inputtedNumber = inputInteger(inputSource, isShapeSelection);
        }
        return inputtedNumber;
    }

    //TODO improve this implementation - is a switch really needed?
    private static IShape inputShape(Scanner inputSource, int shapeNumber) {
        int mathsValue1;
        int mathsValue2;
        int mathsValue3;
        IShape shape = new Rectangle(0,0); //empty initialisation - fix using bounded type paras?
        switch (shapeNumber) {
            case 1:
                System.out.println("Please enter the rectangle's length.");
                System.out.print("Length: ");
                mathsValue1 = inputInteger(inputSource, false);
                System.out.println("Please enter the rectangle's width.");
                System.out.print("Width: ");
                mathsValue2 = inputInteger(inputSource, false);
                shape = new Rectangle(mathsValue1, mathsValue2);
                break;
            case 2:
                System.out.println("Please enter the circle's radius.");
                System.out.print("Radius: ");
                mathsValue1 = inputInteger(inputSource, false);
                shape = new Circle(mathsValue1);
                break;
            case 3:
                System.out.println("Please enter the cylinder's radius.");
                System.out.print("Radius: ");
                mathsValue1 = inputInteger(inputSource, false);
                System.out.println("Please enter the cylinder's height.");
                System.out.print("Height: ");
                mathsValue2 = inputInteger(inputSource, false);
                shape = new Cylinder(mathsValue1, mathsValue2);
                break;
            case 4:
                System.out.println("Please enter the cuboid's length.");
                System.out.print("Length: ");
                mathsValue1 = inputInteger(inputSource, false);
                System.out.println("Please enter the cuboid's width.");
                System.out.print("Width: ");
                mathsValue2 = inputInteger(inputSource, false);
                System.out.println("Please enter the cuboid's height.");
                System.out.print("Height: ");
                mathsValue3 = inputInteger(inputSource, false);
                shape = new Cuboid(mathsValue1, mathsValue2, mathsValue3);
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
        shapeChoice = inputInteger(input, true);
        shape = inputShape(input, shapeChoice);
        System.out.println("Your " +shape.getName()+" has an area of "+shape.getArea()+".\n");

    }

    
}
