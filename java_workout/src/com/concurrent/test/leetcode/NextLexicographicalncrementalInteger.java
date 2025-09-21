package com.concurrent.test.leetcode;

import java.util.Arrays;

public class NextLexicographicalncrementalInteger {

    public static void main(String[] args) {

        int[] array = new int[]{1, 2, 3};
        nextPermutation(array);
        System.out.println(Arrays.toString(array));
    }

    public static void nextPermutation(int[] nums) {

        int idx = -1;
        int n = nums.length;

        for(int i=n-2; i>=0; i--) {
            if(nums[i] < nums[i+1]) {
                idx = i;
                break;
            }
        }

        if(idx == -1) {
            reverse(nums, 0, n-1);
            return;
        }

        for(int i=n-1; i>idx; i--) {
            if(nums[i] > nums[idx]) {
                swap(nums, i, idx);
                break;
            }
        }

        reverse(nums, idx+1, n-1);
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void reverse(int[] nums, int i, int j) {
        while(i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}
