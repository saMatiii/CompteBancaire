package com.example.demo.dao;

import com.example.demo.entities.Operation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by mac on 03/08/2017.
 */
public interface OperationRepository extends JpaRepository<com.example.demo.entities.Operation,Long> {

    @Query("select o from Operation o where o.compte.codeCompte=:x order by o.dateOperation desc ")
    public Page<Operation> listOperation(@Param("x") String codecompte, Pageable pageable);
}
