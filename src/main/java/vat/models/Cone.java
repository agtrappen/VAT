package vat.models;

public class Cone {
    private double height;
    private double ray;

    public Cone(double height, double ray){
        this.height = height;
        this.ray = ray;
    }

    public double calculate(Cone cone){
        return cone.height * cone.ray;
    }
}
