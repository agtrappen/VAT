package vat.models;

import vat.database.JDBCUtil;

import java.sql.SQLException;

public class Shape implements Methods {
    private String shapeName;
    private double content;
    private Shape shape;
    private final JDBCUtil db = new JDBCUtil();

    public Shape(String shapeName, double content){
        this.shapeName = shapeName;
        this.content = content;
    }


    public void save(Shape shape){
        try {
            insertShape();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void insertShape() throws SQLException {
        db.insertShape(this.content, this.shapeName);
    }

}
