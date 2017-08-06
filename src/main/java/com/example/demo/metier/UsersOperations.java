package com.example.demo.metier;

import com.example.demo.entities.Roles;
import com.example.demo.entities.Users;


public interface UsersOperations {

    public void ajouterUtilisateur(Users users);
    public  void ajouterRole(Roles roles);
    public void supprimerUtilisateur(Long id);

}
