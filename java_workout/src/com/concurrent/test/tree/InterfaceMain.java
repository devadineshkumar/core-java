package com.concurrent.test.tree;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

interface InterfaceMain {
    public static void main(String[] args) {
        System.out.println(" Hello World !");

        String str = "Dinesh Kumar rrrr";

        Optional<Map.Entry<Character, Integer>> charToIntegerValue = str.chars().mapToObj(c -> (char) c)
                .collect(Collectors.toMap(k -> k,
                        v -> 1,
                        Integer::sum)).entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).findFirst();

        System.out.println(charToIntegerValue.get().getKey() + " : " + charToIntegerValue.get().getValue());

        List<Character> repeatedchars = str.chars().mapToObj(c -> (char) c)
                .filter(Character::isLetter)
                .collect(Collectors.toMap(k -> k,
                        v -> 1,
                        Integer::sum)).entrySet().stream().filter(e -> e.getValue() > 1)
                .map(Map.Entry::getKey).toList();

        LinkedHashMap<Character, Long> linkedHashMap = str.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

        System.out.println("Repeated Character " + repeatedchars);
    }
}
