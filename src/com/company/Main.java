package com.company;

import java.util.*;

import static java.util.Collections.binarySearch;

public class Main {

    public static final int BAG_WEIGHT = 23000;
    public static WeightComparator weightComparator = new WeightComparator();

    public static void main(String[] args) {
        ArrayList<Product> products = initializeList();
        int result = 0;
        long bestTime = Long.MAX_VALUE;

        for (int i = 0; i < 10; i++) {
            long currentMillis = System.nanoTime();

            result = solution3(products);

            long timeResult = System.nanoTime() - currentMillis;

            if (timeResult< bestTime)
                bestTime = timeResult;
        }

        System.out.println(result);
        System.out.println(bestTime/1000 + " microseconds");

    }

    public static ArrayList<Product> initializeList(){
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product(80, 80));
        products.add(new Product(100, 105));
        products.add(new Product(200, 200));
        products.add(new Product(200, 10));
        products.add(new Product(100, 34));
        products.add(new Product(1, 0));
        products.add(new Product(2, 1));
        products.add(new Product(150, 110));
        products.add(new Product(40, 35));
        products.add(new Product(5, 3));
        products.add(new Product(30, 25));
        products.add(new Product(230, 200));
        products.add(new Product(25, 24));
        products.add(new Product(133, 95));

        return products;
    }

    private static int solution3(ArrayList<Product> products){
        return fillBagSol3(BAG_WEIGHT, products);
    }

    private static int fillBagSol3(int bagWeight, ArrayList<Product> products) {
        int[] maxValues = new int[bagWeight+1];

        for (int iWeight = 1; iWeight <= bagWeight; iWeight++) {
            for (int item = 0; item < products.size() ; item++) {
                Product product = products.get(item);
                if (product.getWeight() <= iWeight){
                    maxValues[iWeight] = max(maxValues[iWeight],
                                            maxValues[iWeight-product.getWeight()]+product.getPrice());
                }
            }
        }

        return maxValues[bagWeight];
    }

    private static int solution1(ArrayList<Product> products) {
        return fillBagSol1(BAG_WEIGHT, products, 0, products.size()-1);
    }

    public static int fillBagSol1(int bagWeight,ArrayList<Product> products, int start, int end){
            if (start>end)
                return 0;
            Product first = products.get(start);
            int gain = 0;

            if (first.getWeight()<=bagWeight){
                gain = first.getPrice();
                int leftBagWeight = bagWeight - first.getWeight();

                if (first.getWeight()> leftBagWeight)
                    gain += fillBagSol1(leftBagWeight,products,start+1,end);
                else
                    gain += fillBagSol1(leftBagWeight,products,start,end);
            }
            int nextGain = fillBagSol1(bagWeight,products,start+1,end);
        return max(gain,nextGain);
    }

    private static int max(int a, int b){
        if(a>=b)
            return a;
        return b;
    }

    private static int solution2(ArrayList<Product> products){
        products.sort(new WeightComparator());
        int start = binaryIndex(binarySearch(products,searchProduct(BAG_WEIGHT), weightComparator));
        return fillBagSol2(BAG_WEIGHT, products, start);
    }

    private static int binaryIndex(int start) {
        if (start<0)
            return (start+1)*-1;
        return start;
    }

    private static Product searchProduct(int weight){
        return new Product(weight,Integer.MAX_VALUE);
    }

    private static int fillBagSol2(int bagWeight, ArrayList<Product> arrayList, int start) {
        if (start >= arrayList.size())
            return 0;
        Product first = arrayList.get(start);
        int gain = first.getPrice();
        int leftBagWeight = bagWeight - first.getWeight();

        if (first.getWeight()> leftBagWeight){
            int next = binaryIndex(binarySearch(arrayList, searchProduct(leftBagWeight), weightComparator));
            gain += fillBagSol2(leftBagWeight,arrayList,next);
        }
        else
            gain += fillBagSol2(leftBagWeight,arrayList,start);

        int nextGain = fillBagSol2(bagWeight,arrayList,start+1);

        return max(gain,nextGain);
    }

}
