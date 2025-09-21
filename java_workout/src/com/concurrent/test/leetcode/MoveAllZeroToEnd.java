package com.concurrent.test.leetcode;

import java.util.Arrays;

public class MoveAllZeroToEnd {

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 0, 0, 0, 1, 3, 4, 0, 0, 1, 4, 5, 6, 0};
        moveZeroes(array);
        System.out.println(Arrays.toString(array));
    }

    public static void moveZeroes(int[] nums) {

        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }

        while (index < nums.length) {
            nums[index] = 0;
            index++;
        }

    }
}
