package shapes.shapes;

import shapes.template.I2DShape;
import shapes.template.I3DShape;

public class Cuboid extends Rectangle implements I3DShape {
    protected int height;

    public Cuboid() {
        System.out.println("Cuboid: " + this.toString());
    }

    public Cuboid (int width, int length, int height) {
       super(width, length);
       this.height = height;
    }

    @Override
    public String Name() {
        return "cuboid";
    }

    @Override
    public double Area() {
        return 2*((length*base) + (length*height) + (base*height));
    }

    @Override
    public int Sides()
    {
        return 16;
    }

    @Override
    public int Length() {
        return this.length;
    }

    public int Height() {
        return this.height;
    }

    public double Volume() {
        return this.length * this.base * this.height;
    }
}
