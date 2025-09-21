package com.concurrent.test.datastructures;

public class StackDemo {
    // Main method to test the stack
    public static void main(String[] args) {
        CustomStack stack = new CustomStack();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        stack.display(); // Output: Stack: 30 20 10

        System.out.println("Popped: " + stack.pop()); // Output: 30
        System.out.println("Top: " + stack.peek());    // Output: 20

        stack.display(); // Output: Stack: 20 10

        System.out.println("Stack size: " + stack.size()); // Output: 2
        System.out.println("Is empty: " + stack.isEmpty()); // Output: false

        stack.pop();
        stack.pop();
        stack.pop(); // Should show "Stack is empty"
    }
}


// Node class for the stack
class StackNode {
    int data;
    StackNode next;

    public StackNode(int data) {
        this.data = data;
        this.next = null;
    }
}

// Stack class using linked list
class CustomStack {
    private StackNode top;

    public CustomStack() {
        this.top = null;
    }

    // Push operation
    public void push(int data) {
        StackNode newNode = new StackNode(data);
        newNode.next = top;
        top = newNode;
        System.out.println("Pushed: " + data);
    }

    // Pop operation
    public int pop() {
        if (top == null) {
            System.out.println("Stack is empty");
            return -1;
        }

        int value = top.data;
        top = top.next;
        return value;
    }

    // Peek top element
    public int peek() {
        if (top == null) {
            System.out.println("Stack is empty");
            return -1;
        }
        return top.data;
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return top == null;
    }

    // Display stack elements
    public void display() {
        if (top == null) {
            System.out.println("Stack is empty");
            return;
        }

        StackNode temp = top;
        System.out.print("Stack: ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Get size of stack
    public int size() {
        int count = 0;
        StackNode temp = top;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}