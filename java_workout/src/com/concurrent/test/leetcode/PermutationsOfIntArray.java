package com.concurrent.test.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PermutationsOfIntArray {

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3};
        permuteArray(array);

    }

    public static void permuteArray(int[] array) {

        if (array.length <= 1) {
            return;
        }

        int start = 0;

        List<Integer> comb = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

//        combination(array, array.length, start, comb, result);
//        System.out.println(" result " + result);
        List<List<Integer>> result1 = new ArrayList<>();

        combination(array, new ArrayList<>(), result1);
        System.out.println(" result1 " + result);


    }

    private static void combination(int[] array, List<Integer> comb, List<List<Integer>> result) {

        for (int i = 0; i < array.length; i++) {
            int take = array[i];
            comb.add(take);

            for (int j = 0; j < array.length; j++) {
                if (!comb.contains(array[j])) {
                    comb.add(array[j]);
                }
            }
            result.add(new ArrayList<>(comb));
            comb.clear();
        }
        System.out.println(" My Result : " + result);
    }

    private static void combination(int[] array, int length, int start, List<Integer> comb, List<List<Integer>> result) {

        if (start == array.length) {
            result.add(new ArrayList<>(comb));
            return;
        }

        for (int i = 0; i < length; i++) {
            comb.add(array[i]);
            combination(array, length, i + 1, comb, result);
        }
    }
}
