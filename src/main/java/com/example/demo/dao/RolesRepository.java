package com.example.demo.dao;

import com.example.demo.entities.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<Roles,String> {
}
