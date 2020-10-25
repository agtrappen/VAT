package vat.database;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class JDBCUtilTest {
    private JDBCUtil db = new JDBCUtil();

    @Test
    void deleteShape() throws SQLException {
        db.deleteShape(1);
        assertEquals(4, db.getShape().size());
    }

    @Test
    void insertShape() throws SQLException {
        db.insertShape((double) 666, "Block");
        boolean isTrue = false;

        for (String s : db.getShape()) {
            if (s.contains("666")) {
                isTrue = true;
            }
        }

        assertTrue(isTrue);
    }

    @Test
    void getTotalContent() throws SQLException {
        assertEquals(6042.0, Double.valueOf(db.getTotalContent()));
    }
}