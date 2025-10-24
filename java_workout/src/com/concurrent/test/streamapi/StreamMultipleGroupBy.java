// src/com/concurrent/test/streamapi/StreamMultipleGroupBy.java
package com.concurrent.test.streamapi;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamMultipleGroupBy {

    public static void main(String[] args) {

        List<Task> tasks = new ArrayList<>();
        String[] departments = {"Sales", "HR", "Engineering"};
        String[] destinations = {"NYC", "LA", "Chicago", "Houston", "Seattle"};
        for (int i = 0; i < 10; i++) {
            int id = ThreadLocalRandom.current().nextInt(1, 1001);
            String name = "User" + (i + 1);
            String dept = departments[i % departments.length];
            String dest = destinations[i % destinations.length];
            Task t = new Task(id, name, dept, dest, System.currentTimeMillis() + i);
            tasks.add(t);
        }
        //        tasks.forEach(System.out::println);
        //
        //        Map<List<String>, List<Task>> response =
        //                tasks.stream().collect(Collectors.groupingBy(e -> Arrays.asList(e.getDestination(), e.getDepartment())));
        //        System.out.println(response.size());
        //        System.out.println(response.keySet());


        List<Task> responsList =
                tasks.stream().sorted(Comparator.comparing(Task::getDepartment).thenComparing(Task::getId, Comparator.reverseOrder()))
                        .toList();
        responsList.forEach(System.out::println);
        System.out.println(responsList);

        Stream.Builder<String> sb = Stream.builder();
        sb.accept("b");

        sb.add("a").accept("1");

        //sb.build().forEach(System.out::println);

        List<String> supplier = IntStream.range(1, 11).boxed().map(e -> "" + e).toList();

        Supplier<Stream> sup = () -> supplier.stream();

        Stream<Stream> supGen = Stream.generate(sup);


//        long count = Stream.concat(supGen, sb.build()).count();
//        System.out.println(count);

        List<Integer> arrivals = List.of(8, 9, 10, 11, 12, 7, 13);

// .filter: keep all arrivals after 10
        List<Integer> filtered = arrivals.stream()
                .filter(time -> time > 10)
                .toList();
        System.out.println(filtered);
// Output: [11, 12]

// .dropWhile: skip arrivals until someone comes after 10
        List<Integer> dropped = arrivals.stream()
                .dropWhile(time -> time <= 10)
                .toList();
        System.out.println(dropped);
// Output: [11, 12]


    }

}

