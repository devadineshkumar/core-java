package com.concurrent.test;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class HashMapTest {

    public static void main(String[] args) {

        long startValue = System.currentTimeMillis();
        Map<Integer, Node> hashMapTest = new HashMap<>();

        IntStream.range(1, 1000000).forEach(i -> {
            hashMapTest.put(i, new Node(i));
        });

        System.out.println("Total time for non sized hash map  " + (System.currentTimeMillis() - startValue) + "ms");

        startValue = System.currentTimeMillis();

        Map<Integer, Node> hashMapTest1 = new HashMap<>(1000000);

        IntStream.range(1, 1000000).forEach(i -> {
            hashMapTest1.put(i, new Node(i));
        });


        System.out.println("Total time for size hashmap " + (System.currentTimeMillis() - startValue) + "ms");
    }
}
