package vat.models;

public class Block {
    private double length;
    private double height;
    private double width;

    public Block(double length, double height, double width){
        this.length = length;
        this.height = height;
        this.width = width;
    }
    public double calculate(Block block){
        return block.length * block.height * block.width;
    }
}
