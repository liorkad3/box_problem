package com.company;

public class BaseBox {

    double width,depth;

    public BaseBox(double width, double depth) {
        this.width = width;
        this.depth = depth;
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

    public boolean isPlaceableOnTop(Box box){
        return box.getDepth()<this.getDepth() && box.getWidth()<this.getWidth();
    }
}
