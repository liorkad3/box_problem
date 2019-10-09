package com.company;

public class Product {
    private int weight;
    private int price;

    public Product(int weight, int price) {
        this.weight = weight;
        this.price = price;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getPriceDensity(){
        return ((double)price)/weight;
    }

    public int howManyInBag(int bagW){
        return bagW/weight;
    }

    @Override
    public String toString() {
        return "[w : "+ weight+",p : "+price+"]";
    }
}
