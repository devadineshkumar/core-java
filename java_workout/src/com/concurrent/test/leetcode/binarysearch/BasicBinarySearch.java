package com.concurrent.test.leetcode.binarysearch;

public class BasicBinarySearch {

    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 5, 6};
        System.out.println(searchInsert(array, 5)); // Output: 2
        System.out.println(searchInsert(array, 2)); // Output: 1
        System.out.println(searchInsert(array, 7)); // Output: 4
        System.out.println(searchInsert(array, 0)); // Output: 0
        System.out.println(searchInsert(array, 6)); // Output: 3
    }

    public static int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // Prevents overflow

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;  // Search right half
            } else {
                right = mid - 1; // Search left half
            }
        }

        return -1; // Target not found
    }

    public static int searchInsertMyVersion(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return -1;
        }

        int mid = nums.length / 2;
        int start = 0;

        if (target == nums[mid]) {
            return mid;
        }

        if (target > nums[mid]) {
            start = mid;
            mid = nums.length;
        }
        int i = start;
        for (i = start; i < mid; i++) {
            if (nums[i] == target) {
                return i;
            } else if (nums[i] > target) {
                return i;
            }
        }
        return i;
    }
}
