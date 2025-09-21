package com.concurrent.test.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSOwnSorting {

    public static void main(String[] args) {

        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);

        node.left.left = new Node(new Node(5), new Node(6), 4);

        node.right.right = new Node(new Node(8), new Node(9), 7);

        doBFS(node);
    }

    private static void doBFS(Node node) {

        List<Node> visited = new ArrayList<>();

        Queue<Node> traversing = new LinkedList<>();

        traversing.add(node);

        while (!traversing.isEmpty()) {
            Node nodeToCheck = traversing.poll();

            if (nodeToCheck.left != null) {
                traversing.add(nodeToCheck.left);
            }

            if (nodeToCheck.right != null) {
                traversing.add(nodeToCheck.right);
            }

            visited.add(nodeToCheck);
            System.out.println("Node value " + nodeToCheck.value);
        }
    }
}

class Node {

    Node left;
    Node right;
    int value;

    Node(int value) {
        this.value = value;
    }

    Node(Node left, Node right, int value) {
        this.left = left;
        this.right = right;
        this.value = value;
    }

    boolean isLast() {
        return (null == left && null == right);
    }

}
