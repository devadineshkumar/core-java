package com.concurrent.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;

class Employee {
    String name;
    String department;

    Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "Name " + name + "-- Department " + department;
    }
}

public class CollectingAndThenCustomExample {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("Alice", "HR"),
                new Employee("Bob", "IT"),
                new Employee("Charlie", "HR"),
                new Employee("David", "IT"),
                new Employee("Eve", "Finance")
        );


        Map<String, String> values = employees.stream().collect(Collectors.toMap(Employee::getName, Employee::getDepartment));

        Map<String, List<String>> nameToDepartments = employees.stream()
                .collect(Collectors.toMap(
                        Employee::getName,
                        e -> new ArrayList<>(List.of(e.getDepartment())),
                        (list1, list2) -> {
                            list1.addAll(list2);
                            return list1;
                        }
                ));

        Map<String, Set<Employee>> sortedNamesByDept = employees.stream().collect(groupingBy(Employee::getDepartment, Collectors.toSet()));
        Map<String, Long> sortedNamesByDept11 =
                employees.stream().collect(groupingBy(Employee::getDepartment, Collectors.counting()));
        Map<String, String> empNameAndDepartment =
                employees.stream().collect(Collectors.toMap(Employee::getName, Employee::getDepartment));


        Map<String, List<String>> sortedNamesByDept1 = employees.stream().collect(
                groupingBy(Employee::getDepartment,
                        collectingAndThen(mapping(Employee::getName, toList()),
                                list -> {
                                    list.sort(Comparator.reverseOrder());
                                    return list;
                                })));

        System.out.println(sortedNamesByDept1);


        sortedNamesByDept.forEach((dept, names) ->
                System.out.println(dept + ": " + names)
        );
    }
}

