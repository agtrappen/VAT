package vat.models;

public class Cylinder extends Shape{
    private double height;
    private double ray;

    public Cylinder(double height, double ray){
        super("Cylinder", height * ray);
        this.height = height;
        this.ray = ray;
    }
}
