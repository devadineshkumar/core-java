package com.concurrent.test.coding;

public class MinimumSubArrayLengthEqualOrGreater {

    public static void main(String[] args) {

        int target = 7;
        int[] nums = new int[]{2, 3, 1, 2, 4, 3};
        System.out.println(minSubArrayLen(target, nums));

    }

    public static int minSubArrayLen(int target, int[] nums) {

        int sum = 0;
        int left = 0;
        int right = 0;
        int minArray = Integer.MAX_VALUE;

        int i = 0;
        while (left < nums.length && right < nums.length) {
            if (sum >= target) {
                minArray = Math.min(minArray, (right - left));
                sum -= nums[left++];
            } else {
                sum += nums[right++];
            }
        }

        while (sum >= target && left < nums.length) {
            minArray = Math.min(minArray, (right - left));
            sum -= nums[left++];
        }

        return minArray == Integer.MAX_VALUE ? 0 : minArray;

    }
}
