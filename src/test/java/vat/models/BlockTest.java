package vat.models;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class  BlockTest {

    @Test
    void calculate() {
        Block block = new Block(20, 20, 20);
        assertEquals(8000.0, block.getContent());
    }
}