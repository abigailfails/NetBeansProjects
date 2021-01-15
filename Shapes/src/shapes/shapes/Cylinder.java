package shapes.shapes;

import shapes.Main;
import shapes.template.I3DShape;

public class Cylinder extends Circle implements I3DShape {
    protected int height;

    public Cylinder() {
        System.out.println("Cylinder: " + this.toString());
        Main.shapeNames.put("Cylinder", this.getClass());
    }

    public Cylinder(int radius, int height) {
        super(radius);
        this.height = height;
    }

    @Override
    public double Area() {
        return 2*Math.PI*radius*(height+radius);
    }

    public double Volume() {
        return this.Area() * height;
    }
}
