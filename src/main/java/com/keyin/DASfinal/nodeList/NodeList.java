package com.keyin.DASfinal.nodeList;

import java.util.ArrayList;
import java.util.List;

import com.keyin.DASfinal.node.Node;
import jakarta.persistence.*;

@Entity
public class NodeList {
    @Id
    @SequenceGenerator(name = "nodeList_sequence", sequenceName = "nodeList_sequence",allocationSize = 1,initialValue = 1)
    @GeneratedValue(generator = "nodeList_sequence")
    private long id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Node> nodes;

    public NodeList() {
        nodes = new ArrayList<>();
    }

    public void insertValue(Node nodeList) {
        nodes.add(nodeList);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Node> getValues() {
        return nodes;
    }

    public void setValues(List<Node> nodeLists) {
        this.nodes = nodeLists;
    }
}
