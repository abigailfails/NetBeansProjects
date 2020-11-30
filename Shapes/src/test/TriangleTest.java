package test;

import org.junit.Test;
import shapes.shapes.Triangle;

import static org.junit.Assert.*;

public class TriangleTest {

    @Test
    public void area() {
        Triangle instance = new Triangle(10, 5);
        assertEquals("Area 10, height 5 - should be 25", 25, instance.Area());
    }
}