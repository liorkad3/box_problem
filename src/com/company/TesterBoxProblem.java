package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

public class TesterBoxProblem {
    public static void main(String[] args) {
        Box[] boxes = initializeBoxes();
        Arrays.sort(boxes,new BoxSurfaceComparator());
        double maxHeight = pyramidHeight(boxes);
        System.out.println(maxHeight);
    }
//    recursive solution => low efficiency
    private static double pyramidHeight(Box[] boxes, Box base, int i) {
        if (i>boxes.length-1)
            return 0;
        if (!base.isTopable(boxes[i]))
            return pyramidHeight(boxes,base,i+1);
        double withBox = boxes[i].getHeight() + pyramidHeight(boxes,boxes[i],i+1);
        double withoutBox = pyramidHeight(boxes,base,i+1);

        return max(withBox,withoutBox);
    }

//      iterative solution => better efficiency
    private static double pyramidHeight(Box[] boxes){
//        boxes argument is a box array that are sorted by surface area ascending.
        double[] maxOnto = new double[boxes.length+1];
        Box infiniteBase = new Box(Double.MAX_VALUE,Double.MAX_VALUE);
        // infinite base is practically the floor, on which each box can be placed.
        for (int n = 0; n < maxOnto.length; n++) {
            //loop over the boxes, and find the max height that can be placed on him excluding the box itself.
            Box base = n == maxOnto.length-1 ? infiniteBase : boxes[n];//the last place in array is for the 'floor'
            for (int m = n-1; m >=0; m--) {
                //loop over the max heights that each box can have on itself.
                Box box = boxes[m];
                if (base.isTopable(box)) {
                    maxOnto[n] = max(maxOnto[n],maxOnto[m]+box.getHeight());
                }
            }
        }
        return maxOnto[maxOnto.length-1];
    }

    private static Box[] initializeBoxes() {
        Box[] boxes = {
                new Box(4,10,3),
                new Box(3,8,3),
                new Box(5,2,7),
                new Box(1,2,2)
        };

        return boxes;
    }

    public static double max(double a, double b){
        if(a>b)
            return a;
        return b;
    }
}
