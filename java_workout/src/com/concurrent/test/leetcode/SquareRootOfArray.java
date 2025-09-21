package com.concurrent.test.leetcode;

import java.util.Arrays;

public class SquareRootOfArray {

    public static void main(String[] args) {

        int[] array = new int[]{2, 3, 4, 5};
        System.out.println("Square Roots " + Arrays.toString(sortedSquares(array)));

    }

    public static int[] sortedSquares(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;

    }
}
