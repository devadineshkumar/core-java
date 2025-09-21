package com.concurrent.test.leetcode.sorting;

public class FindIndexOfANumber {

    public static void main(String[] args) {
        int[] array = new int[]{2, 7, 8, 9, 11, 15, 16};
        System.out.println(search(array, 9)); // Output: 3
        System.out.println(search(array, 2)); // Output: 0
        System.out.println(search(array, 12)); // Output: 0
    }

    public static int search(int[] nums, int target) {
        return getTargetIndex(nums, target, 0, nums.length - 1);
    }

    private static int getTargetIndex(int[] nums, int target, int left, int right) {


        if (left > right) {
            return -1;
        }

        int mid = left + (right - left) / 2;

        if (nums[mid] == target) {
            return mid;
        }

        if (nums[mid] < target) {
            return getTargetIndex(nums, target, mid + 1, right);
        } else {
            return getTargetIndex(nums, target, left, mid - 1);
        }
    }
}
