package com.keyin.DASfinal.binaryTree;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BinaryTreeRepository extends CrudRepository<BinaryTree, Long> {
    BinaryTree findById(long id);
}
