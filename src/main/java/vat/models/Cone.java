package vat.models;

public class Cone implements Shape {
    private double content;
    private double surface;
    private double height;
    private double ray;

    public Cone(double height, double ray){
        this.height = height;
        this.ray = ray;
    }



    @Override
    public int calculateContent() {
    }
}
