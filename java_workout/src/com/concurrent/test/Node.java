package com.concurrent.test;

public class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    public Node(Node left, Node right, int value) {
        this.left = left;
        this.right = right;
        this.value = value;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public int getValue() {
        return value;
    }

    public Node(int i, Node node) {
        this.value = i;
        this.right = node;
    }

    boolean isLast() {
        return (null == left && null == right);
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }
}