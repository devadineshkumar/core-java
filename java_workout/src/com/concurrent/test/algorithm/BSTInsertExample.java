package com.concurrent.test.algorithm;


// Define the BST
class BinarySearchTree {
    Node root;

    // Constructor
    BinarySearchTree() {
        root = null;
    }

    // Public method to insert a key
    void insert(int key) {
        root = insertRec(root, key);
    }

    // Recursive method to insert a new key
    Node insertRec(Node root, int key) {
        // Base case: found a null spot
        if (root == null) {
            root = new Node(key);
            return root;
        }

        // Recur down the tree
        if (key < root.value)
            root.left = insertRec(root.left, key);
        else if (key > root.value)
            root.right = insertRec(root.right, key);

        // Return unchanged node pointer
        return root;
    }

    // In-order traversal to test the tree
    void inorder() {
        inorderRec(root);
    }

    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.value + " ");
            inorderRec(root.right);
        }
    }
}

// Main class to test
public class BSTInsertExample {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);

        System.out.println("Inorder traversal of the BST:");
        tree.inorder();  // Output: 20 30 40 50 60 70 80
    }
}
