package com.concurrent.test.leetcode.most100;

/**
 * https://leetcode.com/problems/maximum-product-subarray/description/
 * <p>
 * 152. Maximum Product Subarray
 * Medium
 * Topics
 * premium lock icon
 * Companies
 * Given an integer array nums, find a subarray that has the largest product, and return the product.
 * <p>
 * The test cases are generated so that the answer will fit in a 32-bit integer.
 */
public class MaxProductSubArray {
    public static int maxProduct(int[] nums) {
        int maxSoFar = nums[0];
        int minSoFar = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];

            // If current number is negative, swap max and min
            if (curr < 0) {
                int temp = maxSoFar;
                maxSoFar = minSoFar;
                minSoFar = temp;
            }

            maxSoFar = Math.max(curr, maxSoFar * curr);
            minSoFar = Math.min(curr, minSoFar * curr);

            result = Math.max(result, maxSoFar);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};
        System.out.println("Maximum product subarray: " + maxProduct(nums)); // Output: 6
    }

}