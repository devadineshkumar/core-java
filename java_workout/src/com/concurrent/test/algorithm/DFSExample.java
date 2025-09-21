package com.concurrent.test.algorithm;

import java.util.*;

public class DFSExample {
    // Method to perform DFS
    public static void dfs(Map<Integer, List<Integer>> graph, int start, Set<Integer> visited) {
        if (visited.contains(start)) {
            return;
        }

        System.out.println("Visiting node: " + start);
        visited.add(start);

        for (int neighbor : graph.getOrDefault(start, new ArrayList<>())) {
            dfs(graph, neighbor, visited);
        }
    }

    public static void main(String[] args) {
        // Predefined graph using adjacency list
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(1, Arrays.asList(2, 3));
        graph.put(2, Arrays.asList(4, 5));
        graph.put(3, Arrays.asList(6));
        graph.put(4, Arrays.asList());
        graph.put(5, Arrays.asList());
        graph.put(6, Arrays.asList());

        int startNode = 1;

        System.out.println("Starting DFS from node " + startNode);
        Set<Integer> visited = new HashSet<>();
        dfs(graph, startNode, visited);
    }
}
