package com.concurrent.test.algorithm;

import java.util.*;

public class BFSExample {
    // Method to perform BFS
    public static boolean bfsSearch(Map<Integer, List<Integer>> graph, int start, int target) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.println("Visiting node: " + current);

            if (current == target) {
                System.out.println("Target " + target + " found!");
                return true;
            }

            for (int neighbor : graph.getOrDefault(current, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }

        System.out.println("Target " + target + " not found in the graph.");
        return false;
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
        int targetNode = 5;

        System.out.println("Starting BFS from node " + startNode + " to find node " + targetNode);
        bfsSearch(graph, startNode, targetNode);
    }
}
