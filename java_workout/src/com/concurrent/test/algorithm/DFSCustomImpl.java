package com.concurrent.test.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFSCustomImpl {

    public static void main(String[] args) {

        DFSNode dfsNode = new DFSNode(1);
        dfsNode.setLeft(new DFSNode(2));
        dfsNode.setRight(new DFSNode(3));

        dfsNode.getLeft().setLeft(new DFSNode(4));
        dfsNode.getLeft().setRight(new DFSNode(5));

        dfsNode.getRight().setLeft(new DFSNode(6));
        dfsNode.getRight().setRight(new DFSNode(7));

        doDFS(dfsNode);
    }

    private static void doDFS(DFSNode dfsNode) {

        List<DFSNode> visited = new ArrayList<>();

        Stack<DFSNode> stack = new Stack<>();
        stack.push(dfsNode);

        while (!stack.isEmpty()) {
            DFSNode nodeToCheck = stack.pop();
            visited.add(nodeToCheck);

            if (nodeToCheck.left != null) {
                stack.push(nodeToCheck.left);
            }

            if (nodeToCheck.right != null) {
                stack.push(nodeToCheck.right);
            }

            System.out.println("Node Value " + nodeToCheck.value);
        }
    }
}

class DFSNode {

    DFSNode left;
    DFSNode right;
    int value;

    DFSNode(int value) {
        this.value = value;
    }

    public DFSNode getLeft() {
        return left;
    }

    public void setLeft(DFSNode left) {
        this.left = left;
    }

    public DFSNode getRight() {
        return right;
    }

    public void setRight(DFSNode right) {
        this.right = right;
    }
}
