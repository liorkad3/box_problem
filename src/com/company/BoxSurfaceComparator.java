package com.company;

import java.util.Comparator;

public class BoxSurfaceComparator implements Comparator<Box> {
    @Override
    public int compare(Box box1, Box box2) {
        double result = box1.getBaseSurface()-box2.getBaseSurface();
        if (result == 0)
            return 0;
        if (result>0)
            return 1;
        return -1;
    }
}
