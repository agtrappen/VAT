package vat.models;

public class Block extends Shape{
    private final double length;
    private final double height;
    private final double width;

    public Block(double length, double height, double width){
        super("Block", length*width*height);
        this.length = length;
        this.height = height;
        this.width = width;
    }

}
