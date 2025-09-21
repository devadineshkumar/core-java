package com.concurrent.test.coding;

public class DecimalToBaseConverter {
    public static String convertToBase(int number, int base) {
        if (number == 0) return "0";

        StringBuilder result = new StringBuilder();
        while (number > 0) {
            int remainder = number % base;
            result.insert(0, remainder);
            number /= base;
        }
        return result.toString();
    }



    public static void main(String[] args) {


        int min = Integer.MAX_VALUE;

        for (int i = 2; i < 36; i++) {
            String avl = convertToBase(50, i);
            int integer = Integer.parseInt(avl);
            System.out.println("Base " + i + " : " + integer);
            if(integer < min && integer > 0) {
                System.out.println(" i " + i);
                min = integer;
            }
        }
        System.out.println("Base 50  : " + min);



//        String converted = convertToBase(number, base);
//        System.out.println("Number " + number + " in base " + base + " is: " + converted);
    }
}
