package com.concurrent.test.comparator;

import com.concurrent.test.streamapi.Task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ComparatorTests {

    public static void main(String[] args) {
        System.out.println(" Comparator Tests ");
        List<String> names = List.of("John", "Alice", "Bob", "Charlie");
        List<String> reversedNames = names.stream()
                .sorted(Comparator.reverseOrder())
                .toList();
        System.out.println(reversedNames);
        //Comparator.comparing(String::compare).reversed();


        Comparator<String> custom1 = Comparator.comparing(String::length).reversed();
        List<String> customSorted1 = names.stream()
                .sorted(custom1)
                .toList();
        System.out.println(customSorted1);

        Comparator<String> custom2 = (a, b) -> Character.compare(a.charAt(0), b.charAt(0));
        List<String> customSorted2 = names.stream()
                .sorted(custom2)
                .toList();
        System.out.println(customSorted2);


        Comparable<String> custom3 = (s) -> Integer.compare(s.length(), 3);
        System.out.println(custom3.compareTo("Test"));

        Comparator<String> intComparator = (a, b) -> Integer.compare(a.length(), b.length());
        List<String> intSorted = names.stream()
                .sorted(intComparator)
                .toList();
        System.out.println(intSorted);


        Task task1 = new Task(1, "Alice", "HR", "NYC", System.currentTimeMillis());
        Task task2 = new Task(2, "Bob", "Engineering", "LA", System.currentTimeMillis());
        Task task3 = new Task(3, "Charlie", "Sales", "Chicago", System.currentTimeMillis());
        Task task4 = new Task(4, "David", "Engineering", "Seattle", System.currentTimeMillis());
        Task task5 = new Task(5, "Eve", "HR", "Houston", System.currentTimeMillis());
        Task task6 = new Task(6, "Frank", "Sales", "NYC", System.currentTimeMillis());
        Task task7 = new Task(7, "Grace", "Engineering", "LA", System.currentTimeMillis());
        List<Task> tasks = List.of(task1, task2, task3, task4, task5, task6, task7);
        List<Task> sortedTasks = tasks.stream()
                .sorted(Comparator.comparing(Task::getDepartment)
                        .thenComparing(Task::getName))
                .toList();
        sortedTasks.forEach(System.out::println);


        List<String> list = tasks.stream().sorted(Comparator.comparing(Task::getDestination)).map(Task::getDestination).toList();
        System.out.println(list);

        List<String> anotherList = new ArrayList<>(list);

//        Map<String, Integer> mapsss = anotherList.stream().collect(Collectors.toMap(Function.identity(),
//                s -> Collections.frequency(anotherList, s)));
//
//        System.out.println(mapsss);

        List<List<String>> lists = List.of(list, anotherList);
        List<String> reduce = lists.stream().reduce(new ArrayList<>(), (a, b) -> {
            a.addAll(b);
            return a;
        });

        List<String> flatmapCollect = lists.stream().flatMap(List::stream).toList();

        System.out.println(flatmapCollect);

        List<Integer> integers = IntStream.range(1, 11).boxed().toList();

        List<Integer> multiCollect = integers.stream().collect(ArrayList::new,
                (aList, a) -> {
                    if (a % 2 == 0) aList.add(a);
                }, ArrayList::addAll);
        System.out.println(multiCollect);


        StringBuilder multiCollect1 = integers.stream().collect(StringBuilder::new,
                (aList, a) -> {
                    if (a % 2 == 0) {
                        aList.append("").append(a);
                    }
                }, StringBuilder::append);


        System.out.println(multiCollect1);


        List<Integer> intValues = IntStream.range(0, 11).boxed().toList();

        int sum = IntStream.range(0, 11).sum();

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int min = numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();

        List<String> list1111 = Arrays.asList("Java", "Spring", "Lambda");
        Map<Integer, List<String>> map = list1111.stream()
                .collect(Collectors.groupingBy(String::length,
                        Collectors.collectingAndThen(Collectors.toList(),
                                l -> {
                                    l.sort((a, b) -> Character.compare(a.charAt(1), b.charAt(1)));
                                    return l;
                                })));
        System.out.println(map);

    }

}
