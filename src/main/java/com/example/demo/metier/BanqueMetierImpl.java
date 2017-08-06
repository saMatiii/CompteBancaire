package com.example.demo.metier;

import com.example.demo.dao.CompteRepository;
import com.example.demo.dao.OperationRepository;
import com.example.demo.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional
public class BanqueMetierImpl implements IBanque {
    @Autowired
    private CompteRepository compteRepository;
@Autowired
private OperationRepository operationRepository;
    @Override
    public Compte consulterCompte(String codeCompte) {
        Compte c=compteRepository.findOne(codeCompte);
        if(c==null) throw new RuntimeException("Compte introuvable");
        return c;
    }

    @Override
    public void verser(String codecompte, double montant) {
     Compte c=consulterCompte(codecompte);
        Versement versement=new Versement(new Date(),montant,c);
        operationRepository.save(versement);
        c.setSolde(c.getSolde()+montant);
        compteRepository.save(c);

    }

    @Override
    public void retirer(String codecompte, double montant) {
        Compte c=consulterCompte(codecompte);
        double faciliteCaisse=0;
        if(c instanceof CompteCourant)
            faciliteCaisse=((CompteCourant) c).getDecouvert();
        if(c.getSolde()+faciliteCaisse<montant) throw new RuntimeException("solde insufisant pour effectuer cette operation");

        Retrait retrait=new Retrait(new Date(),montant,c);
        operationRepository.save(retrait);
        c.setSolde(c.getSolde()-montant);
        compteRepository.save(c);
    }

    @Override
    public void virement(String codeCompt1, String codeCompt2, double montant) {
        if(codeCompt1.equals(codeCompt2)) throw new RuntimeException("Virement impossible sur le meme compte");
        retirer(codeCompt1,montant);
        verser(codeCompt2,montant);
    }

    @Override
    public Page<Operation> listOperation(String codeCompte, int page, int size) {
        return  operationRepository.listOperation(codeCompte,new PageRequest(page,size));

    }
}
