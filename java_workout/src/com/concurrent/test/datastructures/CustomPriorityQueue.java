package com.concurrent.test.datastructures;

public class CustomPriorityQueue {

    private int[] heap;
    private int size;
    private int capacity;

    public CustomPriorityQueue(int capacity) {
        this.capacity = capacity;
        this.heap = new int[capacity];
        this.size = 0;
    }

    // Insert an element into the priority queue
    public void insert(int value) {
        if (size == capacity) {
            System.out.println("Priority Queue is full");
            return;
        }

        heap[size] = value;
        int current = size;
        size++;

        // Heapify up
        while (current > 0 && heap[current] < heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    // Remove and return the minimum element (root)
    public int removeMin() {
        if (size == 0) {
            System.out.println("Priority Queue is empty");
            return -1;
        }

        int min = heap[0];
        heap[0] = heap[size - 1];
        size--;

        heapifyDown(0);
        return min;
    }

    // Peek the minimum element
    public int peek() {
        if (size == 0) {
            System.out.println("Priority Queue is empty");
            return -1;
        }
        return heap[0];
    }

    // Heapify down from a given index
    private void heapifyDown(int i) {
        int smallest = i;
        int left = leftChild(i);
        int right = rightChild(i);

        if (left < size && heap[left] < heap[smallest]) {
            smallest = left;
        }

        if (right < size && heap[right] < heap[smallest]) {
            smallest = right;
        }

        if (smallest != i) {
            swap(i, smallest);
            heapifyDown(smallest);
        }
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int leftChild(int i) {
        return 2 * i + 1;
    }

    private int rightChild(int i) {
        return 2 * i + 2;
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // Display the heap
    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    // Main method to test the priority queue
    public static void main(String[] args) {
        CustomPriorityQueue pq = new CustomPriorityQueue(10);

        pq.insert(30);
        pq.insert(10);
        pq.insert(20);
        pq.insert(5);

        pq.display(); // Output: 5 10 20 30 (heap order)

        System.out.println("Min: " + pq.removeMin()); // Output: 5
        pq.display(); // Output: 10 30 20
    }
}
