package com.example.demo.metier;

import com.example.demo.dao.RolesRepository;
import com.example.demo.dao.UserRepository;
import com.example.demo.entities.Roles;
import com.example.demo.entities.Users;
import org.springframework.beans.factory.annotation.Autowired;


public class UserOperationImpl implements UsersOperations {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RolesRepository rolesRepository;

    @Override
    public void ajouterUtilisateur(Users users) {
        Users users1=userRepository.save(users);
    }

    @Override
    public void ajouterRole(Roles roles) {
        Roles roles1=rolesRepository.save(roles);

    }

    @Override
    public void supprimerUtilisateur(Long id) {
       userRepository.delete(id);
    }
}
