package com.concurrent.test.coding;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CharArrayStreamOperation {


    public static void main(String[] args) {
        String str = "aabbbcddddeeeaaa";

        Map<Character, Long> value = str.chars().mapToObj(c -> (char) c).collect(Collectors
                .groupingBy(c -> c, Collectors.counting()));


        Map<Character, Long> value11 = str.chars().mapToObj(c -> (char) c).collect(Collectors
                .toMap(Function.identity(), i -> 1L, Long::sum));

        String value1 = str.chars().mapToObj(c -> (char) c).collect(Collectors
                        .groupingBy(c -> c, Collectors.counting()))
                .entrySet().stream()
                .map(c -> "" + c.getKey() + c.getValue()).collect(Collectors.joining());

        String value2 = str.chars().mapToObj(c -> (char) c).collect(Collectors
                        .groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .map(c -> "" + c.getKey() + c.getValue()).collect(Collectors.joining("--"));

        System.out.println(value1);
        System.out.println(value2);


    }
}
