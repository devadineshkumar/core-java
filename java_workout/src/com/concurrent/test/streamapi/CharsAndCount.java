package com.concurrent.test.streamapi;

//import com.concurrent.test.Employee;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;

public class CharsAndCount {

    public static void main(String[] args) {
        String s = "Java learning";

        Map<Character, Long> counts = s.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()));

        List<Character> sortedByCountDesc = counts.entrySet().stream()
                .sorted(Map.Entry.<Character, Long>comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .toList();

        System.out.println(counts.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).findFirst().orElseGet(null));
//
//        // Corrected version (counting() returns Long, not Integer)
//        Map<Character, Long> counts1 = s.chars()
//                .collect(Collectors.groupingBy(
//                        c -> (char) c,
//                        Collectors.counting()
//                ));
//
//// If you specifically need Integer values:
//        Map<Character, Integer> counts2 = s.chars()
//                .mapToObj(c -> (char) c)
//                .collect(Collectors.groupingBy( Function.identity(),
//                        Collectors.collectingAndThen(
//                                cc -> cc,
//                                list -> list.sort(Character::compare)
//
//                        )
//                ));

//        Map<String, List<String>> sortedNamesByDept1 = employees.stream().collect(
//                groupingBy(Employee::getDepartment,
//                        collectingAndThen(mapping(Employee::getName, toList()),
//                                list -> {
//                                    list.sort(Comparator.naturalOrder());
//                                    return list;
//                                })));
////
//// More readable alternative:
//        Map<Character, Long> counts3 = s.chars()
//                .mapToObj(c -> (char) c)
//                .collect(Collectors.groupingBy(
//                        Function.identity(),
//                        Collectors.counting()
//                ));
//
//// Complete method example:
//        public static Map<Character, Long> getCharacterCounts(String s) {
//            return s.chars()
//                    .mapToObj(c -> (char) c)
//                    .collect(Collectors.groupingBy(
//                            Function.identity(),
//                            Collectors.counting()
//                    ));
//        }

    }

}
