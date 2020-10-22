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
    double calculateContent(){
        double content = this.length * this.height * this.width;
        return content;
    }
}
