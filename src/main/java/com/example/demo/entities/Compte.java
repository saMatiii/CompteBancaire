package com.example.demo.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Type_Compte",discriminatorType = DiscriminatorType.STRING,length =2)
public abstract class Compte implements Serializable {
    @Id
    private String codeCompte;
    private Date dateCreation;
    private double solde;
    @ManyToOne
    @JoinColumn(name = "CODE_Client")
    private Client client;
    @OneToMany(mappedBy = "compte")
    private Collection<Operation> operations;

    public Compte(String codeCompte, Date dateCreation, double solde, Client client) {
        this.codeCompte = codeCompte;
        this.dateCreation = dateCreation;
        this.solde = solde;
        this.client = client;
    }

    public Compte() {
        super();
    }

    public String getCodeCompte() {
        return codeCompte;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public double getSolde() {
        return solde;
    }

    public Client getClient() {
        return client;
    }

    public Collection<Operation> getOperations() {
        return operations;
    }

    public void setCodeCompte(String codeCompte) {
        this.codeCompte = codeCompte;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setOperations(Collection<Operation> operations) {
        this.operations = operations;
    }
}
