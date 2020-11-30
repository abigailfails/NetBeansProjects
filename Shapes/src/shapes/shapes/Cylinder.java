package shapes.shapes;

import shapes.template.I3DShape;

public class Cylinder extends Circle implements I3DShape {
    protected int height;

    public Cylinder() {
        System.out.println("Cylinder: " + this.toString());
    }

    public Cylinder(int radius, int height) {
        super(radius);
        this.height = height;
    }

    @Override
    public String Name() {
        return "cylinder";
    }

    @Override
    public double Area() {
        return 2*Math.PI*radius*(height+radius);
    }

    public double Volume() {
        return this.Area() * height;
    }
}
