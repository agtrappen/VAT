package vat.models;

public class Cone extends Shape{
    private double height;
    private double ray;

    public Cone(double height, double ray, double pie){
        super("Cone", (double) Math.round(pie * (ray * ray) * height / 3 * 100) / 100);
        this.height = height;
        this.ray = ray;
    }
}
