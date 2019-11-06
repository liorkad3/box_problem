package com.company;

public class Box {
    private double width;
    private double depth;
    private double height;

    public Box(double width, double depth, double height) {
        this.width = width;
        this.depth = depth;
        this.height = height;
    }

    public Box(double width, double depth) {
        this.width = width;
        this.depth = depth;
        this.height = 0;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getDepth() {
        return depth;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getBaseSurface(){
        return width*depth;
    }

    public boolean isTopable(Box other){
        return other.getDepth()<this.getDepth() && other.getWidth()<this.getWidth();
    }
}
