package com.kucher.la56.repository;

import com.kucher.la56.domain.Objectc;
import com.kucher.la56.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
public interface ObjectRepository extends JpaRepository<Objectc, Integer>{

    @Procedure("add_base_object")
    void addBaseObject(int objectId, int userId);
}


