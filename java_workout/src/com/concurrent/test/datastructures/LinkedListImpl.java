package com.concurrent.test.datastructures;

public class LinkedListImpl {
    public Node head;
    public Node last;

    public LinkedListImpl() {
        this.head = null;
        this.last = null;
    }

    public void insertLast(int val) {
        if (head == null) {
            head = new Node(val);
            last = head;
            return;
        }

        Node node = new Node(val);
        last.next = node;
        last = node;
    }

    public void print() {
        if (head == null) {
            System.out.println("Empty linked list ");
            return;
        }
        Node n = head;
        while (n != null) {
            System.out.println(" --> " + n.data);
            n = n.next;
        }
    }

    public Node removeNode(int index) {

        if (index == 0) {
            Node oldHead = head;
            head = head.next;
            return oldHead;
        }

        Node n = head;
        Node previous = head;
        Node forward = null;
        int i = 0;
        for (int j = 0; j <= index; j++) {
            if (n.next != null) {
                previous = n;
                n = n.next;
            }
        }
        previous.next = n.next;
        return n;
    }

    public Node getHead() {
        return head;
    }

    public void reverseLinkedList() {

        if( head == null || head.next == null) {
            return;
        }

        Node current = head;
        Node previous = null;

        while (current != null) {
            Node temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }

        head = previous;
    }

    public static void main(String[] args) {
        LinkedListImpl linkedListImpl = new LinkedListImpl();
        linkedListImpl.insertLast(10);
        linkedListImpl.insertLast(20);
        linkedListImpl.insertLast(30);
        linkedListImpl.insertLast(40);

        linkedListImpl.print();

        linkedListImpl.reverseLinkedList();;
        System.out.println("");
        linkedListImpl.print();

//        Node n = linkedListImpl.removeNode(3);
//        System.out.println(n.data);
//        n = linkedListImpl.removeNode(2);
//        System.out.println(n.data);
//        n = linkedListImpl.removeNode(0);
//        System.out.println(n.data);
//
//        n = linkedListImpl.removeNode(0);
//        System.out.println(n.data);
//
//        linkedListImpl.print();
    }
}
