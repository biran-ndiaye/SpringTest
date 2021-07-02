package com.example.clientui.controller;

import com.example.clientui.model.Commande;
import com.example.clientui.model.Paiement;
import com.example.clientui.model.Produit;
import com.example.clientui.repository.MicroserviceCommandeProxy;
import com.example.clientui.repository.MicroservicePaiementProxy;
import com.example.clientui.repository.MicroserviceProduitProxy;
import org.bouncycastle.math.raw.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.Date;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@Controller
public class ClientController {

    @Autowired
    private MicroserviceProduitProxy microserviceProduitProxy;

    @Autowired
    private MicroserviceCommandeProxy microserviceCommandeProxy;

    @Autowired
    private MicroservicePaiementProxy microservicePaiementProxy;

    @GetMapping("/error")
    public String ErrorPage(@RequestHeader Map<String, String> headers, Model model) {
        //headers.forEach((key, value) -> System.out.printf("Header '%s' = %s%n", key, value));
        model.addAttribute("headers",headers);
        return "error";
    }

    //Etape 1
    @GetMapping("/")
    public String homePage(Model model){
        Iterable<Produit> produits = microserviceProduitProxy.getProduits();

        model.addAttribute("produits",produits);

        return "home";
    }

    //Etape 2
    @GetMapping("/details-produit/{id}")
    public String detailProduitPAge(Model model, @PathVariable Integer id){
        Optional<Produit> produit = microserviceProduitProxy.getPrduit(id);
        model.addAttribute("produit",produit);
        return "detailProduit";
    }

    //Etape 3 et 4
    @GetMapping("/commander-produit/{id}/{montant}")
    public String passerCommande(@PathVariable Integer id, @PathVariable double montant, Model model){

        Commande commande = new Commande();
        commande.setIdProduit(id);
        commande.setDate(new Date());
        commande.setQuantite(1);

        Commande commandeAjoutee = microserviceCommandeProxy.addCommande(commande);

        model.addAttribute("commande", commandeAjoutee);
        model.addAttribute("montant", montant);

        return "Paiement";
    }

    //Etape (5)
    @GetMapping("/payer-commande/{id}/{montant}")
    public String payerCommande(@PathVariable Integer id, @PathVariable double montant, Model model){

        Paiement paiementToAdd = new Paiement();
        paiementToAdd.setIdCommande(id);
        paiementToAdd.setMontant(montant);
        paiementToAdd.setNumeroCarte(ThreadLocalRandom.current().nextLong(1000000000000000L,9000000000000000L ));

        Paiement paiement = microservicePaiementProxy.addPaiement(paiementToAdd);
        if(paiement != null){
            //mettre a jour la commande dont l'id est {id}
            Optional<Commande> paidcommande = microserviceCommandeProxy.getCommande(id);
            paidcommande.ifPresent(commande -> microserviceCommandeProxy.updatePaidCommand(commande));

        }

        model.addAttribute("paiementOk",paiement != null);

        return "Confirmation";
    }
}
