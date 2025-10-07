package com.concurrent.test.coding;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MergeTwoSortedArray {

    public static void main(String[] args) {

        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0}, nums2 = new int[]{2, 5, 6};
        int n = 3, m = 3;
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));

    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = 0, j = 0;
        int l = 0;

        int[] copyArray = new int[m + n];

        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                copyArray[l++] = nums1[i++];
            } else {
                copyArray[l++] = nums2[j++];
            }
        }

        while (i < m) {
            copyArray[l++] = nums1[i++];
        }

        while (j < n) {
            copyArray[l++] = nums2[j++];
        }

        System.arraycopy(copyArray, 0, nums1, 0, copyArray.length);

    }


}
