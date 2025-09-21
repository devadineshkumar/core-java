package com.concurrent.test.leetcode.most100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SumTwoNumberIndex {

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 4, 6, 9};
        System.out.println(Arrays.toString(getSumOfTwoNum(array, 8)));
    }

    private static int[] getSumOfTwoNum(int[] array, int target) {

        List<Integer> visited = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {

            int exptValue = target - array[i];
            if (visited.contains(exptValue)) {
                return new int[]{visited.indexOf(exptValue), i};
            }
            visited.add(array[i]);
        }
        return null;
    }
}
