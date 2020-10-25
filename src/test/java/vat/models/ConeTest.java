package vat.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConeTest {

    @Test
    void calculate() {
        Cone cone = new Cone(12, 5);
        assertEquals(314.0, cone.calculate(cone));
    }
}