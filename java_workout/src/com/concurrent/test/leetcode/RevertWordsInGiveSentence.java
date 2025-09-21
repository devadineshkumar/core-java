package com.concurrent.test.leetcode;

public class RevertWordsInGiveSentence {

    public static void main(String[] args) {
        String s = "the sky is blue";
        String s1 = "a good   example";
        System.out.println("Reversed String [" + reverseWords(s1) + "]");
    }

    public static String reverseWords(String s) {

        String[] array = s.trim().split(" ");

        StringBuilder sb = new StringBuilder();

        for (int i = array.length - 1; i >= 0; i--) {
            if (!(array[i].isEmpty())) {
                sb.append(array[i]);
                if (i != 0) sb.append(" ");
            }
        }
        return sb.toString().trim();
    }


}
