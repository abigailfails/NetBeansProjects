package shapes;

import shapes.shapes.Circle;
import shapes.shapes.Cuboid;
import shapes.shapes.Cylinder;
import shapes.shapes.Rectangle;
import shapes.template.Polygon;
import shapes.template.Shape;

import javax.swing.*;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class Main {
    //public static Set<Class> shapeTypes;
    public static final String choiceMessage = """
                 Select your shape.
                 1. Rectangle
                 2. Circle
                 3. Cuboid
                 4. Cylinder
                 
                 Choice: """;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        var inputSource = new Scanner(System.in);
        var shouldContinue = false;
        Shape largestArea = null;
        do {
            Shape shape;
            switch (InputHelper.inputBoundedInteger(choiceMessage, inputSource, 1, 4)) {
                case 1 -> {
                    int length = InputHelper.inputInteger("Please input the rectangle's length.\nLength: ", inputSource);
                    int width = InputHelper.inputInteger("Please input the rectangle's width.\nWidth: ", inputSource);
                    shape = new Rectangle(length, width);
                    System.out.println("output message");
                }
                case 2 -> {
                    int radius = InputHelper.inputInteger("Please input the circle's radius.\nRadius: ", inputSource);
                    shape = new Circle(radius);
                }
                case 3 -> {
                    int length = InputHelper.inputInteger("Please input the cuboid's length.\nLength: ", inputSource);
                    int width = InputHelper.inputInteger("Please input the cuboid's width.\nWidth: ", inputSource);
                    int height = InputHelper.inputInteger("Please input the cuboid's height.\nHeight: ", inputSource);
                    shape = new Cuboid(length, width, height);
                }
                case 4 -> {
                    int radius = InputHelper.inputInteger("Please input the cylinder's radius.\nRadius: ", inputSource);
                    int height = InputHelper.inputInteger("Please input the cylinder's height.\nHeight: ", inputSource);
                    shape = new Cylinder(radius, height);
                }
                default -> throw new IllegalStateException("Shape choice out of bounds. This should not be happening!");
            }
            largestArea = (largestArea == null) ? shape : ((shape.Area() >= largestArea.Area()) ? shape : largestArea);
        }
        while(shouldContinue);
    }
}
