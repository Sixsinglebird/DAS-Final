package com.keyin.DASfinal.binaryTree;

import com.keyin.DASfinal.node.Node;
import com.keyin.DASfinal.nodeList.NodeList;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class BinaryTree {

    @Id
    @SequenceGenerator(name = "tree_sequence", sequenceName = "tree_sequence",allocationSize = 1,initialValue = 1)
    @GeneratedValue(generator = "tree_sequence")
    private long id;


    @OneToOne(cascade = CascadeType.ALL)
    private Node root;

    @OneToOne(cascade = CascadeType.ALL)
    private NodeList nodes = new NodeList();

    public BinaryTree() {
        root = null;
        nodes = new NodeList();
    }


    public void insert(int value) {
        root = insertRec(root, value);
    }

    Node insertRec(Node root, int value) {
        Node node = new Node(String.valueOf(value));
        nodes.insertValue(node);

        if (root == null) {
            root = new Node(String.valueOf(value));
            return root;
        }


        if (value < Integer.parseInt(String.valueOf(root.getValue()))) {
            root.setLeft(insertRec(root.getLeft(), value));

        }else if (value > Integer.parseInt(String.valueOf(root.getValue()))) {
            root.setRight(insertRec(root.getRight(), value));
        }

        return root;
    }


    // Traversal operations
    public List<Integer> traverse() {
        List<Integer> results = new ArrayList<>();
        traverseRec(root, results);
        return results;
    }

    private void traverseRec(Node root, List<Integer> result) {
        if (root != null) {
            result.add(Integer.parseInt(String.valueOf(root.getValue())));

            traverseRec(root.getLeft(), result);
            traverseRec(root.getRight(), result);
        }
    }

    public Node getRoot() {
        return root;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public NodeList getValues() {
        return nodes;
    }

    public void setValues(NodeList nodes) {
        this.nodes = nodes;
    }
}
