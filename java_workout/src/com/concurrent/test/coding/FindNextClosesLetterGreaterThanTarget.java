package com.concurrent.test.coding;

public class FindNextClosesLetterGreaterThanTarget {

    public static void main(String[] args) {
        char[] array = new char[]{'c', 'f', 'j'};
        System.out.println(nextGreatestLetter(array, 'c'));
    }

    public static char nextGreatestLetter(char[] letters, char target) {

        if (letters == null || letters.length == 0) {
            return letters[0];
        }

        int left = 0;
        int right = letters.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (letters[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return letters[left] > target ? letters[left] : letters[0];
    }
}
