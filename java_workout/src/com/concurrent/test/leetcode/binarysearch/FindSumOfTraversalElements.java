package com.concurrent.test.leetcode.binarysearch;

import java.util.ArrayList;
import java.util.List;

public class FindSumOfTraversalElements {

    public static void main(String[] args) {
        /*

                      5
                3           7
            2       4   6        9
        1
        */

        TreeNode treeNode = new TreeNode(5);
        treeNode.setLeft(new TreeNode(3));
        treeNode.getLeft().setLeft(new TreeNode(2));
        treeNode.getLeft().getLeft().setLeft(new TreeNode(1));

        treeNode.getLeft().setRight(new TreeNode(4));

        treeNode.setRight(new TreeNode(7));
        treeNode.getRight().setRight(new TreeNode(9));
        treeNode.getRight().getRight().setLeft(new TreeNode(6));

    }


    public boolean hasPathSum(TreeNode root, int targetSum) {


        findSum(root, targetSum);

        return false;

    }

    private static boolean findSum(TreeNode root, int targetSum) {

        if(root == null) {
            return false;
        }

        if(root.isLeaf()) {
            return targetSum == root.getVal();
        }

        int remaining = targetSum - root.getVal();
        return findSum(root.getLeft(), remaining) || findSum(root.getRight(), remaining);
    }

}
