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

    public double Volume() {
        return this.Area() * height;
    }
}
