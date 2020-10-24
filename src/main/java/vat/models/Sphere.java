package vat.models;

public class Sphere {
    private double ray;

    public Sphere(double ray){
        this.ray = ray;
    }

    public void save(Sphere sphere) {
        System.out.println(sphere);
    }
}
