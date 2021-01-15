package shapes.shapes;

import shapes.Main;
import shapes.template.I2DShape;

public class Circle implements I2DShape {
    protected int radius;

    public Circle() {
        System.out.println("Circle: " + this.toString());
        Main.shapeNames.put("Circle", this.getClass());
    }

    public Circle(int radius) {
        this();
        this.radius = radius;
    }

    @Override
    public double Area() {
        return Math.PI * this.radius * this.radius;
    }


    public double Circumference() {
        return Math.PI * this.radius * 2;
    }

    public int Radius() {
        return this.radius;
    }
}
