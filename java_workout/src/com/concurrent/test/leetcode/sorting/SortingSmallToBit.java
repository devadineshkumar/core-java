package com.concurrent.test.leetcode.sorting;

import java.util.Arrays;

public class SortingSmallToBit {

    public static void main(String[] args) {
        int[] array = new int[]{3, 3, 2, 1, 0, 3, 4, 4, 2, 0};
        sortColors(array);
        System.out.println(Arrays.toString(array));
    }

    public static void sortColors(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;
        }

    }
}
