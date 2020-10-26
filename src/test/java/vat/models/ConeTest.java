package vat.models;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConeTest {

    @Test
    void calculate() {
        Cone cone = new Cone(12, 5, 3.141592653);
        assertEquals(314.16, cone.getContent());
    }
}