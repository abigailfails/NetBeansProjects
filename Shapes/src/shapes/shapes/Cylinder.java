package shapes.shapes;

public class Cylinder extends Circle {
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
