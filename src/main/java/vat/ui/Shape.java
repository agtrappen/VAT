package vat.ui;

public class Shape {
    private String shapeName;
    private double content;
    private Shape shape;

    public Shape(String shapeName, double content){
        this.shapeName = shapeName;
        this.content = content;
    }

    public void save(Shape shape){
//        add to db
        System.out.println("test"+  shape.shapeName + shape.content);
    }

}
