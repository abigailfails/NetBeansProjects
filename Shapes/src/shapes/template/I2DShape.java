package shapes.template;

public interface I2DShape extends Comparable<I2DShape> {
    double Area();
    String Name();

    @Override
    default int compareTo(I2DShape s) {
        return Double.compare(this.Area(), s.Area());
    }

}
