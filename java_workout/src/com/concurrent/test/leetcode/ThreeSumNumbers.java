package com.concurrent.test.leetcode;

import java.util.ArrayList;
import java.util.List;

class ThreeSumNumbers {

    public static void main(String[] args) {

        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));

    }

    public static List<List<Integer>> threeSum(int[] nums) {

        int i = 0;
        int j = i + 1;
        List<List<Integer>> result = new ArrayList<>();

        while (i < (nums.length - 2)) {

            if ((nums[i] + nums[j] + nums[j + 1]) == 0) {
                List<Integer> sets = List.of(nums[i], nums[j], nums[j + 1]);
                result.add(sets);
            }

            if ((j + 1) < nums.length - 2) {
                j++;
            } else {
                i++;
                j = i + 1;
            }
        }

        return result;

    }

}