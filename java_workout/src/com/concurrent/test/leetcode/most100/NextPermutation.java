package com.concurrent.test.leetcode.most100;

import java.util.Arrays;

public class NextPermutation {

    public static void main(String[] args) {
        int[] array = new int[]{5, 1, 3, 4, 2};
        nextPermutation(array);
        System.out.println(Arrays.toString(array));
    }

    public static void nextPermutation(int[] nums) {
        int i = nums.length - 2;

        // Step 1: Find the first decreasing element from the end
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        System.out.println("int I " + i);

        // Step 2: If such element exists, find the next larger element to swap
        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }

        // Step 3: Reverse the suffix starting at i + 1
        reverse(nums, i + 1, nums.length - 1);
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start++, end--);
        }
    }
}