package com.keyin.DASfinal.binaryTree;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BTController {

    @Autowired
    private BinaryTreeRepository BTRepository;

    private final BinaryTree bt = new BinaryTree();

    @PostMapping("/process-numbers")
    public void insertValues(@RequestBody List<String> values) {
        for (String value : values) {
            bt.insert(Integer.parseInt(value));
        }
        BTRepository.save(bt);
    }

    @GetMapping("/tree")
    public Node viewTree() {
        return bt.getRoot();
    }

    @GetMapping("/traverse")
    public List<Integer> inorder() {
        return bt.traverse();
    }
}
