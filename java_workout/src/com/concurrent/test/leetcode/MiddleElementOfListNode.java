package com.concurrent.test.leetcode;

import com.concurrent.test.Node;

public class MiddleElementOfListNode {

    public static void main(String[] args) {

    }

    public static Node middleNode(Node head) {


        if (head == null) {
            return null;
        }

        Node slow = head;
        Node fast = head;

        // Use two pointers: slow moves 1 step, fast moves 2 steps
        while (fast != null && fast.getRight() != null) {
            slow = slow.getRight();
            fast = fast.getRight().getRight();
        }

        return slow;
    }
}
