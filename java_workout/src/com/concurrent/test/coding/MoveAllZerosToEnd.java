package com.concurrent.test.coding;

import java.util.Arrays;

public class MoveAllZerosToEnd {

    public static void main(String[] args) {

        int[] array = new int[]{1, 0, 2, 0, 2, 7, 3, 9, 4};
        moveZerosToEnd(array);


    }

    public static void moveZerosToEnd(int[] array) {
        int writeIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                array[writeIndex++] = array[i];
            }
        }

        while (writeIndex < array.length) {
            array[writeIndex++] = 0;
        }

        System.out.println(Arrays.toString(array));
    }

}
