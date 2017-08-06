package com.example.demo.web;


import com.example.demo.entities.Compte;
import com.example.demo.entities.Operation;
import com.example.demo.metier.IBanque;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BanqueController {
@Autowired
private IBanque iBanque;
    @RequestMapping("/operations")
    public String index(){
     return "comptes";
    }


    @RequestMapping("/consulterCompte")
    public String consulter(Model model, String codeCompte, @RequestParam(name = "page",defaultValue = "0")int page,
                            @RequestParam(name = "size",defaultValue = "5")int size) {
        model.addAttribute("codeCompte",codeCompte);
        try {
            Compte c=iBanque.consulterCompte(codeCompte);
            Page<Operation> pageOperation=iBanque.listOperation(codeCompte,page,size);
            int[] pages=new int[pageOperation.getTotalPages()];
            model.addAttribute("pages",pages);
            model.addAttribute("listeOperation",pageOperation.getContent());
            model.addAttribute("compte",c);
        } catch (Exception e) {
            model.addAttribute("exeption",e);
        }
        return "comptes";
    }

    @RequestMapping(value = "/saveOperation",method = RequestMethod.POST)
    public String save(Model model,String codeCompte,String typeOperation,double montant,String codecompte2){

        try {
            if(typeOperation.equals("vers")){
                iBanque.verser(codeCompte,montant);
            }
            if(typeOperation.equals("retr")){
                iBanque.retirer(codeCompte,montant);
            }
            if(typeOperation.equals("virm")){
                iBanque.virement(codeCompte,codecompte2,montant);
            }
        } catch (Exception e) {
            model.addAttribute("saveExeption",e);
            return "redirect:/consulterCompte?codeCompte="+codeCompte+"&error="+e.getMessage();
        }

        return "redirect:/consulterCompte?codeCompte="+codeCompte;
    }


}
