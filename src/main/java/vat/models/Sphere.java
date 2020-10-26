package vat.models;

public class Sphere extends Shape{
    private double ray;

    public Sphere(double ray){
        super("Sphere", ray);
        this.ray = ray;
    }
}
