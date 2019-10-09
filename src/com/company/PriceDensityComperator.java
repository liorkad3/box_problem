package com.company;

import java.util.Comparator;

public class PriceDensityComperator implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        double result = o2.getPriceDensity()-o1.getPriceDensity();
        if (result!=0)
            return result>0 ? 1:-1;

        return new WeightComparator().compare(o1, o2);
    }
}
