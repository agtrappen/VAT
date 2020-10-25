package vat.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SphereTest {

    @Test
    void calculate() {
        Sphere sphere = new Sphere(50);
        assertEquals(50.0, sphere.calculate(sphere));
    }
}