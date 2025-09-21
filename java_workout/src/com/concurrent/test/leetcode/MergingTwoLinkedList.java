package com.concurrent.test.leetcode;

import com.concurrent.test.Node;
import com.concurrent.test.datastructures.LinkedListImpl;

public class MergingTwoLinkedList {

    public static void main(String[] args) {

        LinkedListImpl list1 = new LinkedListImpl();
        list1.insertLast(1);
        list1.insertLast(3);
        list1.insertLast(5);


        LinkedListImpl list2 = new LinkedListImpl();
        list1.insertLast(2);
        list1.insertLast(4);
        list1.insertLast(6);

//        mergeTwoLists(list1.getHead(), list2.getHead());

    }

//    public static Node mergeTwoLists(Node list1, Node list2) {
//
//        Node current = null;
//
//        while(list1 != null && list2 != null) {
//
//            if (list1.getValue() < list2.getValue()) {
//                current = list1;
//                list1 = list1.getRight();
//                current.setRight(list1);
//            } else {
//                current = list2;
//                list2 = list2.getRight();
//                current.setRight(list1);
//            }
//        }
//
//
//
//
//        return head;
//    }
}
