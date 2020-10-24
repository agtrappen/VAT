package vat.models;

public class Cylinder {
    private double height;
    private double ray;

    public Cylinder(double height, double ray){
        this.height = height;
        this.ray = ray;
    }

    public double calculate(Cylinder cylinder){
        return cylinder.height * cylinder.ray;
    }
}