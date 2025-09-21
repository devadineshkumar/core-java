package com.concurrent.test.leetcode.binarysearch;

public class PeakIndexInMountainArray {

    public static void main(String[] args) {
        int[] array = new int[]{0, 2, 3, 1, 0};
        System.out.println(peakIndexInMountainArray(array));
//
        int[] array1 = new int[]{9, 10, 11, 12, 14, 3, 5};
        System.out.println(peakIndexInMountainArray(array1));

        int[] array11 = new int[]{9, 10, 11, 12, 14};
        System.out.println(peakIndexInMountainArray(array11));

        int[] array2 = new int[]{3, 5, 3, 2, 0};
        System.out.println(peakIndexInMountainArray(array2));
    }

    public static int peakIndexInMountainArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1; // Invalid input
        }

        int left = 0;
        int right = arr.length - 1;
        int mid;

        //[0,3,2,1,0]
        while (left < right) {

            mid = left + (right - left) / 2;

            if (arr[mid] > arr[mid + 1] && arr[mid - 1] < arr[mid]) {
                return mid;
            } else if (arr[mid] < arr[mid - 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }

        }
        return left;
    }

}
