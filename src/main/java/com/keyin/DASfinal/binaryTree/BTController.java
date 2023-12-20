package com.keyin.DASfinal.binaryTree;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BTController {

    private final BinaryTree bt = new BinaryTree();

    @PostMapping("/insert")
    public void insert(@RequestParam int value) {
        bt.insert(value);
    }

    @PostMapping("/process-numbers")
    public void insertValues(@RequestBody List<String> values) {
        for (String value : values) {
            bt.insert(Integer.parseInt(value));
        }
    }

    @GetMapping("/search/{value}")
    public Node search(@PathVariable int value) {
        return bt.search(value);
    }

    @DeleteMapping("/delete/{value}")
    public void delete(@PathVariable int value) {
        bt.delete(value);
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
