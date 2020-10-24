package vat.models;

public class Sphere {
    private double ray;

    public Sphere(double ray){
        this.ray = ray;
    }

    public double calculate(Sphere sphere){
        return sphere.ray;
    }
}
