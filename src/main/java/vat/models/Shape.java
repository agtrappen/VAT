package vat.models;

import vat.database.JDBCUtil;

import java.sql.SQLException;

public class Shape implements Methods {
    private String shapeName;
    private double content;
    private final JDBCUtil db = new JDBCUtil();

    public Shape(String shapeName, double content){
        this.shapeName = shapeName;
        this.content = content;
    }
    public void save(){
        try {
            this.db.insertShape(this.content, this.shapeName);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public String getShapeName() {
        return shapeName;
    }

    public double getContent() {
        return content;
    }

    public void setContent(double content) {
        this.content = content;
    }
}
