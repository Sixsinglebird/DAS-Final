package com.keyin.DASfinal.binaryTree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {

    Node root;

    public BinaryTree() {
        root = null;
    }

    public void insert(int value) {
        root = insertRec(root, value);
    }


    Node insertRec(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }

        if (value < root.value)
            root.left = insertRec(root.left, value);
        else if (value > root.value)
            root.right = insertRec(root.right, value);

        return root;
    }

    // Search operation
    public Node search(int value) {
        return searchRec(root, value);
    }

    private Node searchRec(Node root, int value) {
        if (root == null || root.value == value)
            return root;

        if (root.value > value)
            return searchRec(root.left, value);

        return searchRec(root.right, value);
    }

    // Delete operation
    public void delete(int value) {
        root = deleteRec(root, value);
    }

    private Node deleteRec(Node root, int value) {
        if (root == null) return root;

        if (value < root.value)
            root.left = deleteRec(root.left, value);
        else if (value > root.value)
            root.right = deleteRec(root.right, value);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            root.value = minValue(root.right);

            root.right = deleteRec(root.right, root.value);
        }

        return root;
    }

    private int minValue(Node root) {
        int minv = root.value;
        while (root.left != null) {
            minv = root.left.value;
            root = root.left;
        }
        return minv;
    }


    // Traversal operations
    public List<Integer> traverse() {
        List<Integer> results = new ArrayList<>();
        traverseRec(root, results);
        return results;
    }

    private void traverseRec(Node root, List<Integer> result) {
        if (root != null) {
            result.add(root.value);
            traverseRec(root.left, result);
            traverseRec(root.right, result);
        }
    }

    public Node getRoot() {
        return root;
    }

}
