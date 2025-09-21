package com.concurrent.test.datastructures;

import java.util.Stack;

public class TreeProgram {

    public static void main(String[] args) {

        Stack<Node> stack1 = new Stack<>();

        Stack<Node> stack2 = new Stack<>();
        int[] array = new int[]{4,1,8,4,5};
        LinkedListImpl linkedList = new LinkedListImpl();

        for(int i: array) {
            linkedList.insertLast(i);
        }



        int[] array1 = new int[]{5,6,1,8,4,5};
        LinkedListImpl linkedList1 = new LinkedListImpl();

        for(int i: array1) {
            linkedList1.insertLast(i);
        }
//
//        Node n1 = linkedList.head;
//        while(n1 != null) {
//            stack1.add(n1);
//            n1 = n1.next;
//        }
//
//        Node n2 = linkedList1.head;
//        while(n2 != null) {
//            stack2.add(n2);
//            n2 = n2.next;
//        }
//
//        boolean equalValues = true;
//        Node node1 = stack1.pop();
//        Node node2 = stack2.pop();
//        while(node1 != null && node2 != null) {
//            node1 = stack1.pop();
//            node2 = stack2.pop();
//
//            if(node1.data == node2.data) {
//                equalValues = false;
//                node1 = node1.next;
//                node2 = node2.next;
//                break;
//            }
//        }
//
//        System.out.println("Intersecting node " + node1.data);


//        if (headA == null || headB == null) return null;

        Node pA = linkedList.head;
        Node pB = linkedList1.head;

        while (pA != pB) {
            pA = (pA == null) ? linkedList1.head : pA.next;
            pB = (pB == null) ? linkedList.head : pB.next;
        }

        System.out.println(pA); // Either the intersection node or null
        System.out.println(pB); // Either the intersection node or null
    }
}