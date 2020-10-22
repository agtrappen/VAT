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

    public void save(Block block) {
        System.out.println(block.length + block.height + block.width);
    }
}
