package com.example.demo.dao;

import com.example.demo.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by mac on 03/08/2017.
 */
public interface ClientRepository extends JpaRepository<Client,Long> {

}
