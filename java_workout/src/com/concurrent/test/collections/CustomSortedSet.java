package com.concurrent.test.collections;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

class Person {

    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return name + " (" + age + ")";
    }
}

public class CustomSortedSet {
    public static void main(String[] args) {
        Comparator<Person> byAgeDesc = (p1, p2) -> Integer.compare(p1.age, p2.age);

        Set<Person> people = new TreeSet<>(byAgeDesc);
        people.add(new Person("Alice", 30));
        people.add(new Person("Bob", 25));
        people.add(new Person("Charlie", 35));

        for (Person p : people) {
            System.out.println(p);
        }
    }
}
