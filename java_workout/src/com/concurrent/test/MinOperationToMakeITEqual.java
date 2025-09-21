package com.concurrent.test;

import java.sql.SQLOutput;
import java.util.Arrays;

public class MinOperationToMakeITEqual {
    public static void main(String[] args) {
//        int[] array = new int[]{1, 2, 3};
        int[] array = new int[]{12, 10, 9, 11};

        int min = findMin(array);
        int max = findMax(array);

        int mid = (max + min) / 2;
        System.out.println("Mid value " + mid);
        int operation = 0;

        for (int i = 0; i < array.length; i++) {
            while ((array[i] < mid) || (array[i] > mid)) {
                operation++;
                if (array[i] < mid) {
                    array[i]++;
                } else {
                    array[i]--;
                }
            }
        }

        System.out.println(Arrays.toString(array));
        System.out.println(operation);
    }

    private static int findMin(int[] array) {

        int min = array[0];

        for (int i : array) {
            if (i < min) {
                min = i;
            }
        }
        return min;
    }

    private static int findMax(int[] array) {

        int max = array[0];

        for (int i : array) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

}
