package com.concurrent.test.coding;

import java.util.ArrayList;
import java.util.List;

public class FindAllSubArraySumIsZero {

    public static void main(String[] args) {
        int[] array = new int[]{2, 3, -3, 1, -6, 5};
        System.out.println(findAllSubArrayWithSumZero(array));
    }

    private static List<List<Integer>> findAllSubArrayWithSumZero(int[] array) {

        List<List<Integer>> subArray = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            int sum = 0;
            List<Integer> subA = new ArrayList<>();
            int j = i;
            while (i < array.length) {
                subA.add(array[i]);
                sum += array[i];
                if (sum == 0) {
                    System.out.println(subA);
                    subArray.add(List.copyOf(subA));
                }
                i++;
            }
            i = j;
        }


        return subArray;
    }


    private static List<List<Integer>> findAllSubArrayWithSumZero1(int[] array) {

        List<List<Integer>> subArrays = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            List<Integer> subArray = expandAround(i, array);
            if (null != subArray && !subArray.isEmpty()) {
                subArrays.add(subArray);
            }
        }

        return null;
    }

    private static List<Integer> expandAround(int i, int[] array) {

        int start = i;
        int end = i;
        int sum = 0;
        while (start >= 0 && end < array.length && start < end) {

            start--;
            end++;
        }

        return null;
    }


}
