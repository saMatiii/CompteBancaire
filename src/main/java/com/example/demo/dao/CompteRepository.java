package com.example.demo.dao;

import com.example.demo.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by mac on 03/08/2017.
 */
public interface CompteRepository extends JpaRepository<Compte,String> {
}
