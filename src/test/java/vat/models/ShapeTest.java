package vat.models;

import org.junit.jupiter.api.Test;
import vat.database.JDBCUtil;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class ShapeTest {

    @Test
    void save() throws SQLException {
        Shape shape = new Shape("Block", 999);
        JDBCUtil db = new JDBCUtil();
        Boolean isTrue = false;
        shape.save();

        for (String s : db.getShape()) {
            if (s.contains("999")) {
                isTrue = true;
            }
        }

        assertTrue(isTrue);
    }
}