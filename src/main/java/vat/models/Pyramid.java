package vat.models;

public class Pyramid {
    private double length;
    private double height;
    private double width;

    public Pyramid(double length, double height, double width){
        this.length = length;
        this.height = height;
        this.width = width;
    }

    public void save(Pyramid pyramid) {
        System.out.println(pyramid);
    }
}
