package com.example.microservicepaiement.controller;

import com.example.microservicepaiement.exceptions.PaiementExistantException;
import com.example.microservicepaiement.exceptions.PaiementImpossibleException;
import com.example.microservicepaiement.model.Paiement;
import com.example.microservicepaiement.service.PaiementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class PaiementController {

    @Autowired
    private PaiementService paiementService;

    @PostMapping("/paiement")
    @ResponseStatus(HttpStatus.CREATED)
    public Paiement addPaiement(@RequestBody Paiement paiement){
        //check if order is aleready paied
        Optional<Paiement> paiementExistant = paiementService.getPaiementByIdCommande(paiement.getIdCommande());
        if(paiementExistant.isPresent()) throw new PaiementExistantException("Cette commande est deja paye");

        Paiement nouvePaiement = paiementService.addPaiement(paiement);
        if(nouvePaiement == null) throw new PaiementImpossibleException("Erreur, Impossible d'etablir le paiement");
        return nouvePaiement;
    }
}
