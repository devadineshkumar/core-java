package com.concurrent.test.leetcode;

public class ClosestThreeSumNumber {

    public static void main(String[] args) {
        int[] array = new int[]{-1, 2, 1, -4};
        int[] array1 = new int[]{0, 0, 0};
        int[] array2 = new int[]{0, 1, 2};
        int[] array3 = new int[]{10, 20, 30, 40, 50, 60, 70, 80, 90};
        int target = 1;
        System.out.println("Closest target of three sum " + threeSumClosest(array, target));
//        System.out.println("Closest target of three sum " + threeSumClosest(array1, target));
        System.out.println("Closest target of three sum " + threeSumClosest(array2, 0));
        System.out.println("Closest target of three sum " + threeSumClosest(array3, 1));
    }

    public static int threeSumClosest(int[] nums, int target) {
        int i = 0;
        int j = i + 1;
        int sum = 0;
        while (i < nums.length - 2) {
            int total = nums[i] + nums[j] + nums[j + 1];
            if (sum == 0 || Math.abs(target - total) < Math.abs(target - sum)) {
                sum = total;
            }
            i++;
            j = i + 1;
        }

        return sum;
    }

    public static int threeSumClosest1(int[] nums, int target) {


        return 0;

    }
}
