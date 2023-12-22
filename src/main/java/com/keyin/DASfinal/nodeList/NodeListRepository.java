package com.keyin.DASfinal.nodeList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NodeListRepository extends CrudRepository<NodeList, Long> {
    NodeList findById(long id);
}
