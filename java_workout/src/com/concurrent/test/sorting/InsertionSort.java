package com.concurrent.test.sorting;


/**
 * This class demonstrates the insertion sort algorithm.
 *
 * Insertion Sort is a simple and intuitive sorting algorithm that builds the final sorted array one item at a time. It’s similar to how you might sort playing cards in your hands:
 *
 * Start with the second card.
 * Compare it with the cards before it.
 * Insert it into the correct position.
 * Repeat for all cards.
 */
public class InsertionSort {

    // Method to perform insertion sort
    public static void insertionSort(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i]; // Element to insert
            int j = i - 1;

            // Shift elements of arr[0..i-1] that are greater than key
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }

            // Place key at its correct position
            arr[j + 1] = key;
        }
    }

    // Method to print the array
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Main method
    public static void main(String[] args) {
        int[] numbers = {9, 5, 1, 4, 3};

        System.out.println("Original array:");
        printArray(numbers);

        insertionSort(numbers);

        System.out.println("Sorted array:");
        printArray(numbers);
    }
}
