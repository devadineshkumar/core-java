package com.concurrent.test.datastructures;

public class PriorityQueueDemo {

    public static void main(String[] args) {
        // Test Java's built-in PriorityQueue
        testBuiltInPriorityQueue();

        System.out.println("\n" + "=".repeat(50) + "\n");

        // Test custom priority queue
        testCustomPriorityQueue();
    }

    private static void testBuiltInPriorityQueue() {
        System.out.println("Testing Java's Built-in PriorityQueue:");

        // Min heap (default)
        java.util.PriorityQueue<Integer> minHeap = new java.util.PriorityQueue<>();

        // Add elements
        minHeap.offer(30);
        minHeap.offer(10);
        minHeap.offer(20);
        minHeap.offer(5);
        minHeap.offer(15);

        System.out.println("Min Heap elements: " + minHeap);

        // Poll elements (should come out in ascending order)
        System.out.print("Polling from min heap: ");
        while (!minHeap.isEmpty()) {
            System.out.print(minHeap.poll() + " ");
        }
        System.out.println();

        // Max heap using custom comparator
        java.util.PriorityQueue<Integer> maxHeap = new java.util.PriorityQueue<>(
                java.util.Collections.reverseOrder()
        );

        maxHeap.offer(30);
        maxHeap.offer(10);
        maxHeap.offer(20);
        maxHeap.offer(5);
        maxHeap.offer(15);

        System.out.println("Max Heap elements: " + maxHeap);

        // Poll elements (should come out in descending order)
        System.out.print("Polling from max heap: ");
        while (!maxHeap.isEmpty()) {
            System.out.print(maxHeap.poll() + " ");
        }
        System.out.println();

        // Priority queue with custom objects
        testCustomObjectPriorityQueue();
    }

    private static void testCustomObjectPriorityQueue() {
        System.out.println("\nTesting PriorityQueue with custom objects:");

        java.util.PriorityQueue<Task> taskQueue = new java.util.PriorityQueue<>();

        taskQueue.offer(new Task("Low priority task", 3));
        taskQueue.offer(new Task("High priority task", 1));
        taskQueue.offer(new Task("Medium priority task", 2));
        taskQueue.offer(new Task("Critical task", 0));

        System.out.println("Tasks in priority order:");
        while (!taskQueue.isEmpty()) {
            Task task = taskQueue.poll();
            System.out.println(task);
        }
    }

    private static void testCustomPriorityQueue() {
        System.out.println("Testing Custom PriorityQueue Implementation:");

        CustomPriorityQueue pq = new CustomPriorityQueue(10);

        // Insert elements
        System.out.println("Inserting elements: 30, 10, 20, 5, 15");
        pq.insert(30);
        pq.insert(10);
        pq.insert(20);
        pq.insert(5);
        pq.insert(15);
        pq.display(); // 5 10 15 30 20
        // Remove elements
        System.out.println("\nRemoving elements:");
        System.out.println("Removed min: " + pq.removeMin()); // 5
        pq.display(); // 10 20 15 30

        System.out.println("Removed min: " + pq.removeMin()); // 10
        pq.display(); // 15 30 20

        System.out.println("Peek min: " + pq.peek()); // 15

        // Remove all remaining elements
        System.out.println("\nRemoving all remaining elements:");
        while (pq.peek() != -1) {
            System.out.println("Removed: " + pq.removeMin());
        }

        // Try to remove from empty queue
        System.out.println("Trying to remove from empty queue:");
        pq.removeMin();
    }
}

// Task class for priority queue with custom objects
class Task implements Comparable<Task> {
    private String name;
    private int priority;

    public Task(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    @Override
    public int compareTo(Task other) {
        return Integer.compare(this.priority, other.priority);
    }

    @Override
    public String toString() {
        return "Task{name='" + name + "', priority=" + priority + "}";
    }
}
