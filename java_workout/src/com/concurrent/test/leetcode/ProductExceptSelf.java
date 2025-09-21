package com.concurrent.test.leetcode;

import java.util.Arrays;

public class ProductExceptSelf {

    public static void main(String[] args) {
        int[] nums = new int[]{4, 2, 3};
        int[] nums1 = new int[]{-1, 1, 0, -3, 3};
        System.out.println(Arrays.toString(productExceptSelf1(nums)));
//        System.out.println(Arrays.toString(productExceptSelf(nums)));
//        System.out.println(Arrays.toString(productExceptSelf(nums1)));
    }

    public static int[] productExceptSelf1(int[] nums) {

        int n = nums.length;
        int[] result = new int[n];

        // First pass: calculate left products
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        // Second pass: multiply with right products
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= rightProduct;
            rightProduct *= nums[i];
        }
        return result;
    }

    public static int[] productExceptSelf(int[] nums) {
        int start = 0;
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = findProductExcept(i, nums);
        }
        return result;
    }

    private static int findProductExcept(int i, int[] nums) {
        int j = 0;
        int result = 1;
        while (j < nums.length) {
            if (i == j) {
                j++;
                continue;
            }
            result *= nums[j];
            j++;
        }

        return result;
    }
}
