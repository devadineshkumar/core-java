package com.concurrent.test.leetcode.binarysearch;

public class FindMinimumRotations {

    public static void main(String[] args) {

        int[] array = new int[]{5, 6, 1, 3, 4};
        System.out.println(findMin(array));

        int[] array1 = new int[]{2, 3, 4, 5, 6};
        System.out.println(findMin(array1));
    }

    public static int findMin(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int left = 0;
        int right = nums.length - 1;
        // 3, 4, 5, 1, 2
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[right] < nums[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return nums[left];
    }

}
