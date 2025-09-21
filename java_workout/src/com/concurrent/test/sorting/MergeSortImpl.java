package com.concurrent.test.sorting;

import java.util.Arrays;

public class MergeSortImpl {

    public static void main(String[] args) {

        int[] numbers = {23, 38, 271, 43, 3, 92, 82, 1110};

        System.out.println("Original array: " + Arrays.toString(numbers));

        mergeSort(numbers, 0, numbers.length - 1);
        System.out.println("Sorted array: " + Arrays.toString(numbers));
    }

    private static void mergeSort(int[] numbers, int l, int r) {
        if (l < r) {
            int mid = (l + r) / 2;

            mergeSort(numbers, l, mid);
            mergeSort(numbers, mid + 1, r);

            mergeResult(numbers, l, mid, r);
        }
    }

    private static void mergeResult(int[] numbers, int l, int m, int r) {

        int n1 = m - l + 1;
        int n2 = r - m;

        int[] lArray = new int[n1];
        int[] rArray = new int[n2];

        for (int i = 0; i < n1; i++) {
            lArray[i] = numbers[l + i];
        }

        for (int i = 0; i < n2; i++) {
            rArray[i] = numbers[m + 1+ i];
        }

        System.out.println("Left array: " + Arrays.toString(lArray));
        System.out.println("Right array: " + Arrays.toString(rArray));


        int i = 0, j = 0, k = l;

        while (i < n1 && j < n2) {

            if (lArray[i] < rArray[j]) {
                numbers[k] = lArray[i];
                i++;
            } else {
                numbers[k] = rArray[j];
                j++;
            }
            k++;
        }


        while (i < n1) {
            numbers[k] = lArray[i];
            k++;
            i++;
        }

        while (j < n2) {
            numbers[k] = rArray[j];
            k++;
            j++;
        }
    }
}
