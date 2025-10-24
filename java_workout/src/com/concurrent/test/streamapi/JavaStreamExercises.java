package com.concurrent.test.streamapi;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaStreamExercises {

    public static void main(String[] args) {
        Map<String, Integer> map1 = Map.of("A", 1, "B", 2, "C", 3);
        Map<String, Integer> map2 = Map.of("B", 3, "C", 4, "D", 5);
        // Merge two maps, summing values of common keys
        Map<String, Integer> mergedMap = mergeMaps(map1, map2);
        System.out.println(mergedMap); // Output: {A=1, B=5, C=7, D=5}

    }

    public static Map<String, Integer> mergeMaps(Map<String, Integer> map1, Map<String, Integer> map2) {
        return Map.copyOf(
                Stream.concat(map1.entrySet().stream(), map2.entrySet().stream())
                        .collect(Collectors.toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue,
                                Integer::sum
                        ))
        );
    }
}
