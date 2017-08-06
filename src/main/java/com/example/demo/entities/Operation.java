package com.example.demo.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_Operation",discriminatorType = DiscriminatorType.STRING,length = 2)
public abstract class Operation implements Serializable {
    @Id
    @GeneratedValue
    private Long numero;
    private Date dateOperation;
    private double montant;
    @ManyToOne
    @JoinColumn(name = "Code_compte")
    private Compte compte;

    public Operation() {
        super();
    }

    public Operation( Date dateOperation, double montant, Compte compte) {
        this.dateOperation = dateOperation;
        this.montant = montant;
        this.compte = compte;
    }

    public Long getNumero() {
        return numero;
    }

    public Date getDateOperation() {
        return dateOperation;
    }

    public double getMontant() {
        return montant;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public void setDateOperation(Date dateOperation) {
        this.dateOperation = dateOperation;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }
}
