package vat.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CylinderTest {

    @Test
    void calculate() {
        Cylinder cylinder = new Cylinder(12, 5);
        assertEquals(60.0, cylinder.calculate(cylinder));
    }
}