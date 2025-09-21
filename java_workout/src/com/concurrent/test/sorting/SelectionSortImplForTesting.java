package com.concurrent.test.sorting;

import java.util.Arrays;

public class SelectionSortImplForTesting {
    public static void main(String[] args) {
        int[] array = new int[]{3, 5, 1, 8, 4};
//        selectionSort(array);
//        System.out.println(Arrays.toString(array));

        mergeSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[minIndex] > array[j]) {
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }

    public static void mergeSort(int[] array, int left, int right) {

        if (left < right) {

            int middle = (left + right) / 2;

            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);
            mergeResult(array, left, middle, right);
        }
    }

    //1234 2 1 4 3
    private static void mergeResult(int[] array, int left, int middle, int right) {

        int l1 = middle - left + 1;
        int l2 = right - middle;

        int[] n1 = new int[l1];
        int[] n2 = new int[l2];


        for (int i = 0; i < l1; i++) {
            n1[i] = array[left + i];
        }

        for (int i = 0; i < l2; i++) {
            n2[i] = array[middle + 1 + i];
        }

        int i = 0;
        int j = 0;
        int k = left;

        while (i < l1 && j < l2) {

            if (n1[i] < n2[j]) {
                array[k] = n1[i];
                i++;
            } else {
                array[k] = n2[j];
                j++;
            }

            k++;
        }

        while (i < n1.length) {
            array[k] = n1[i];
            i++;
            k++;
        }


        while (j < n2.length) {
            array[k] = n2[j];
            j++;
            k++;
        }
    }
}
