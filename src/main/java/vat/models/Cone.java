package vat.models;

public class Cone {
    private double height;
    private double ray;
    private double pie;

    public Cone(double height, double ray){
        this.height = height;
        this.ray = ray;
        this.pie = 3.141592653;
    }

    public double calculate(Cone cone){
        return Math.round(pie * (cone.ray * cone.ray) * cone.height / 3);
    }
}
