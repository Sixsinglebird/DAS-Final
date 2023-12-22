package com.keyin.DASfinal.binaryTree;

import com.keyin.DASfinal.node.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
public class BTController {

    @Autowired
    private BinaryTreeRepository BTRepository;

    private BinaryTree bt;

    @PostMapping("/process-numbers")
    public void insertValues(@RequestBody List<String> values) {
        bt = new BinaryTree();
        for (String value : values) {
            bt.insert(Integer.parseInt(value));
        }
        BTRepository.save(bt);

    }

    @GetMapping("/tree")
    public Node viewTree() {
        if (bt == null) {
            return new Node();
        }
        return bt.getRoot();
    }

    @PostMapping("/orderTree")
    public void orderTree(@RequestBody List<String> values) {
        Collections.sort(values);
        bt = new BinaryTree();
        for (String value : values) {
            bt.insert(Integer.parseInt(value));
        }
        BTRepository.save(bt);
    }


    @GetMapping("/traverse")
    public List<Integer> inorder() {
        return bt.traverse();
    }

    @GetMapping("/tree/{id}")
    public Optional<BinaryTree> getTree(@PathVariable Long id) {
        return BTRepository.findById(id);
    }
}
