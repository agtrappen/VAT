package vat.models;

public class Pyramid extends Shape{
    private double length;
    private double height;
    private double width;

    public Pyramid(double length, double height, double width){
        super("Pyramid", length * height * width);
        this.length = length;
        this.height = height;
        this.width = width;
    }
}
