package com.concurrent.test.algorithm;

public class DoubleLinkedListImpl {
    public static void main(String[] args) {

        MyDoubleLinkedList list = new MyDoubleLinkedList();
        list.insertNode(10);
        list.insertNode(12);
        list.insertNode(15);
        list.insertAtIndex(20, 10);

        list.print();
    }
}

class MyDoubleLinkedList {

    Node head;
    Node tail;


    public MyDoubleLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void insertNode(int value) {
        if (this.head == null) {
            this.head = new Node(value);
            this.head.right = null;
            return;
        }

        Node node = this.head;
        while (node.right != null) {
            node = node.right;
        }
        node.right = new Node(value);
        tail = node.right;
    }

    public void insertAtIndex(int value, int index) {

        if (index == 0) {
            Node newHead = new Node(value);
            newHead.right = head;
            head = newHead;
        }

        int i = 1;
        Node prev = head;
        while (i < (index) && prev != null) {
            prev = prev.right;
            i++;
        }
        if (prev == null) {
            throw new IndexOutOfBoundsException("Index greater than size.");
        }
        Node newNode = new Node(value);
        newNode.right = prev.right;
        prev.right = newNode;
    }

    public void print() {
        Node current = this.head;
        while (current != null) {
            System.out.println("Node Value " + current.value);
            current = current.right;
        }
    }
}
