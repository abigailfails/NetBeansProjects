package shapes.shapes;

import shapes.template.I2DShape;
import shapes.template.I3DShape;

public class Cuboid extends Rectangle implements I3DShape {
    protected int height;

    public Cuboid() {
        System.out.println("Cuboid: " + this.toString());
    }

    public Cuboid (int length, int width, int height) {
       super(length, width);
        this.height = height;
    }

    @Override
    public String Name() {
        return "cuboid";
    }

    @Override
    public double Area() {
        return 2*((length*width) + (length*height) + (width*height));
    }

    @Override
    public int Sides()
    {
        return 16;
    }

    public int Height() {
        return this.height;
    }

    public double Volume() {
        return this.length * this.width * this.height;
    }
}
