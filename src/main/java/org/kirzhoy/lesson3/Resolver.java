package org.kirzhoy.lesson3;

import java.lang.reflect.Array;

public class Resolver {


    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 8, 5};
        System.out.println(getMin(arr));
    }

    public static int getMin(int[] array) {
        int min = Integer.MAX_VALUE;
        for (int i : array) {
            if (i < min) {
                min = i;
            }
        }
        return min;
    }
}
