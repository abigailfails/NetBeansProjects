package shapes.shapes;

import shapes.template.Shape;

public class Circle extends Shape {
    protected int radius;

    public Circle() {
        System.out.println("Circle: " + this.toString());
    }

    @Override
    public String Name() {
        return "circle";
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
