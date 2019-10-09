package com.company;

import java.util.Comparator;

public class WeightComparator implements Comparator<Product> {

    @Override
    public int compare(Product o1, Product o2) {
        int result = o2.getWeight()-o1.getWeight();
        if (result!=0)
            return result;

        result = o2.getPrice()-o1.getPrice();
        return result;
    }
}
