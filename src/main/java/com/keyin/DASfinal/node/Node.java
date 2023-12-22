package com.keyin.DASfinal.node;


import jakarta.persistence.*;

@Entity
public class Node {

    @Id
    @SequenceGenerator(name = "node_sequence", sequenceName = "node_sequence",allocationSize = 1,initialValue = 1)
    @GeneratedValue(generator = "node_sequence")
    private long id;

    private int value;

    @OneToOne(cascade = CascadeType.ALL)
    Node left;

    @OneToOne(cascade = CascadeType.ALL)
    Node right;

    public Node() {
        value = 0;
        right = null;
        left = null;
    }

    public Node (String val) {
        value = Integer.parseInt(val);
        right = null;
        left = null;
    }

    public int getValue() {
        return value;
    }

    public void setValue(String value) {

        this.value = Integer.parseInt(value);
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
