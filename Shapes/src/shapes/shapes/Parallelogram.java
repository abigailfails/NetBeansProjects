package shapes.shapes;

import shapes.template.IPolygon;

public class Parallelogram implements IPolygon {
    protected int base;
    protected int length;
    public Parallelogram() {
        System.out.println("Rectangle: " + this.toString());
    }

    public Parallelogram(int base, int length) {
        this.base = base;
        this.length = length;
    }

    @Override
    public int Sides() {
        return 4;
    }

    @Override
    public double Area() {
        return this.base*this.length;
    }

    @Override
    public String Name() {
        return "parallelogram";
    }

    public int Base() {
        return this.base;
    }

    public int Length() {
        return this.length;
    }

}
