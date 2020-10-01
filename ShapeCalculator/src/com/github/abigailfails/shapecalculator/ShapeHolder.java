package com.github.abigailfails.shapecalculator;

public class ShapeHolder {
    private Shape storedShape;
    private int shapeLength1;
    private int shapeLength2;
    private int shapeLength3;

    /**
     * Input radius (circle)
     * */
    public ShapeHolder(Shape shape, int radius){
       storedShape = shape;
       shapeLength1 = radius;
    }

    /**
     * Input height and width (rectangle) or height and radius (cylinder)
     * */
    public ShapeHolder(Shape shape, int length1, int length2){
        storedShape = shape;
        shapeLength1 = length1;
        shapeLength2 = length2;
    }

    /**
     * Input length of sides (cuboid)
     * */
    public ShapeHolder(Shape shape, int length1, int length2, int length3){
        storedShape = shape;
        shapeLength1 = length1;
        shapeLength2 = length2;
        shapeLength3 = length3;
    }

    public double getArea() {
        switch (storedShape) {
            case RECTANGLE:
                return shapeLength1 * shapeLength2; //length * width
            case CIRCLE:
                return shapeLength1*shapeLength1*3.14; //pi * radius^2
            case CYLINDER:
                return 2*3.14*shapeLength2*(shapeLength1+shapeLength2); //2 * pi * radius * (height + radius)
            case CUBOID:
                return 2*((shapeLength1*shapeLength2)+(shapeLength1*shapeLength3)+(shapeLength2*shapeLength3));
                //2 * (ab+ac+bc)
        }
    }
}
