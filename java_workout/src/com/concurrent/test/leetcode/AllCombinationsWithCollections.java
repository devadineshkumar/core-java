package com.concurrent.test.leetcode;

import java.util.*;

public class AllCombinationsWithCollections {
    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(1, 2, 3);
        Set<String> result = new HashSet<>();

        for (int r = 1; r <= input.size(); r++) {
            generatePermutations(input, r, new ArrayList<>(), new HashSet<>(), result);
        }

        // Print all combinations in one line separated by space
        System.out.println(String.join(" ", result));
    }

    private static void generatePermutations(List<Integer> input, int r, List<Integer> current, Set<Integer> used, Set<String> result) {
        if (current.size() == input.size()) {
            result.add(listToString(current));
            return;
        }

        for (Integer num : input) {
            if (!used.contains(num)) {
                current.add(num);
                used.add(num);
                generatePermutations(input, r, current, used, result);
                used.remove(num);
                current.remove(current.size() - 1);
            }
        }
    }

    private static String listToString(List<Integer> list) {
        return String.join("--", list.stream().map(String::valueOf).toArray(String[]::new));
    }
}
