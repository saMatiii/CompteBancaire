package com.example.demo.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 * Created by mac on 31/07/2017.
 */
@Entity
public class Client implements Serializable
{
    @Id
    @GeneratedValue
    private Long code;
    private String nom;
    private String mail;
    @OneToMany(mappedBy = "client",fetch = FetchType.LAZY)
    private Collection<Compte> compte;

    public Client(String nom, String mail, Collection<Compte> compte) {
        this.nom = nom;
        this.mail = mail;
        this.compte = compte;
    }

    public Client(String mail, String nom) {
        this.nom=nom;
        this.mail=mail;
    }

    public Long getCode() {
        return code;
    }

    public String getNom() {
        return nom;
    }

    public String getMail() {
        return mail;
    }

    public Collection<Compte> getComptes() {
        return compte;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setComptes(Collection<Compte> comptes) {
        this.compte = comptes;
    }

    public Client() {
        super();
    }
}
