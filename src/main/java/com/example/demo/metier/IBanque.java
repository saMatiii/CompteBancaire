package com.example.demo.metier;

import com.example.demo.entities.Compte;
import com.example.demo.entities.Operation;
import org.springframework.data.domain.Page;

/**
 * Created by mac on 03/08/2017.
 */
public interface IBanque {
    public Compte consulterCompte(String codeCompte);
    public void verser(String codecompte,double montant);
    public void retirer(String codecompte,double montant);
    public void virement(String codeCompt1,String codeCompt2,double moontant);
    Page<Operation> listOperation(String codeCompte,int page,int size);
}
