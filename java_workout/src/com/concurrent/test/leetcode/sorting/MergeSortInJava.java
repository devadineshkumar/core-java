package com.concurrent.test.leetcode.sorting;

import java.util.Arrays;

public class MergeSortInJava {

    public static void main(String[] args) {
        int[] array = new int[]{4, 1, 2, 3};
        mergeSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    private static void mergeSort(int[] array, int l, int r) {
        if (l < r) {
            int mid = (r + l) / 2;
            mergeSort(array, l, mid);
            mergeSort(array, mid + 1, r);
            merge(array, l, mid, r);
        }
    }

    private static void merge(int[] array, int l, int mid, int r) {

        int n1 = mid - l + 1;
        int n2 = r - mid;

        int[] array1 = new int[n1];
        int[] array2 = new int[n2];

        for (int i = 0; i < n1; i++) {
            array1[i] = array[l + i];
        }

        for (int i = 0; i < n2; i++) {
            array2[i] = array[mid + i + 1];
        }

        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {

            if (array1[i] < array2[j]) {
                array[k] = array1[i];
                i++;
            } else {
                array[k] = array2[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = array1[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = array2[j];
            j++;
            k++;
        }
    }
}
