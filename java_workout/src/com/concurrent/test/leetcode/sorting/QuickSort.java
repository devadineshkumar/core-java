package com.concurrent.test.leetcode.sorting;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] array = new int[]{3, 4, 2, 1};
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = arr[high];
            int position = partition(arr, low, high, pivot);
            quickSort(arr, low, position - 1);
            quickSort(arr, position + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high, int pivot) {
        int i = low;
        int j = low;
        while (i <= high) {

            if (arr[i] > pivot) {
                i++;
            } else {
                swap(arr, i++, j++);
            }
        }
        return j - 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
