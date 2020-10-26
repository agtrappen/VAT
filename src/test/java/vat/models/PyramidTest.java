package vat.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PyramidTest {

    @Test
    void calculate() {
        Pyramid pyramid = new Pyramid(20, 20, 20);
        assertEquals(8000.0, pyramid.getContent());
    }
}