package com.concurrent.test.coding;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WriteMostUsedTop10WordsFromFile {

    public static void main(String[] args) {

        String str = "The most used words in sentence is the most the most the most the most";

        Map<String, Long> map = Arrays.stream(str.trim().split("\\s+")).collect(Collectors.toMap(Function.identity(), v -> 1L, Long::sum))
                .entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(2)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        System.out.println(map);

        Map<String, Long> map1 = Arrays.stream(str.trim().split("\\s+"))
                .collect(Collectors.groupingBy(Function.identity(), TreeMap::new, Collectors.counting()));
        System.out.println(map1);
    }
}
