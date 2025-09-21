package com.concurrent.test.leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;

public class RemoveDuplicateInSortedArray {

    public static void main(String[] args) {

        int[] array = new int[]{0, 1, 1, 2, 3, 3, 4, 5};
        int[] array1 = new int[]{0, 1, 2, 3, 4, 5};
        int nonDuplicate = removeDuplicates(array);
        System.out.println("New array size with non duplicate value is " + nonDuplicate + "" + Arrays.toString(array));
        int nonDuplicate1 = removeDuplicates(array1);
        System.out.println("New array size with non duplicate value is " + nonDuplicate1 + "" + Arrays.toString(array1));

    }

    public static int removeDuplicates(int[] nums) {

        int index = 0;
        int i = 0;
        while (i < nums.length - 1) {
            if (nums[i + 1] > nums[i]) {
                nums[index++] = nums[i];
            }
            i++;
        }
        nums[index] = nums[i];
        return (index + 1);
    }
}
