package com.concurrent.test.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    public static void main(String[] args) {

        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));

    }

    public static List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> listMap = new HashMap<>();

        for (String s : strs) {
            char[] array = s.toCharArray();
            Arrays.sort(array);
            listMap.computeIfAbsent(String.valueOf(array), k -> new ArrayList<String>()).add(s);
        }

        return new ArrayList<>(listMap.values());
    }
}
