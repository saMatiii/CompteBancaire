package com.example.demo.dao;

import com.example.demo.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by mac on 05/08/2017.
 */
public interface UserRepository extends JpaRepository<Users,Long> {
}
