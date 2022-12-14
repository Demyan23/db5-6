package com.kucher.la56.repository;

import com.kucher.la56.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

    List<User> findCategoryByName(String name);

    @Procedure("dymanic_procedure")
    void dymanicProcedure();

}
