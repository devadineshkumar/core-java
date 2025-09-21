package com.concurrent.test.leetcode.most100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAnagramsIndexes {

    public static void main(String[] args) {
        String s = "cbaebabacd", p = "abc";
        System.out.println(findAnagrams(s, p));
    }

    public static List<Integer> findAnagrams(String s, String p) {

        List<Integer> indexs = new ArrayList<>();
        char[] sortedArray = p.toCharArray();
        Arrays.sort(sortedArray);
        String sortedString = new String(sortedArray);
        for (int i = 0; i < s.length() - p.length(); i++) {
            String subString = s.substring(i, i + p.length());

            char[] sortSunString = subString.toCharArray();
            Arrays.sort(sortSunString);
            String sortSunStringValue = new String(sortSunString);

            if (sortedString.equals(sortSunStringValue)) {
                indexs.add(i);
            }
        }
        return indexs;
    }
}
