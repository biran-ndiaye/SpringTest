package com.example.microservicecommandes.controller;

import com.example.microservicecommandes.exceptions.CommandNotModifiedException;
import com.example.microservicecommandes.exceptions.CommandeNotAddeException;
import com.example.microservicecommandes.exceptions.CommandeNotFounException;
import com.example.microservicecommandes.model.Commande;
import com.example.microservicecommandes.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CommandeController {

    @Autowired
    private CommandeService commandeService;

    @GetMapping("/commandes")
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Commande> getCommandes(){
        Iterable<Commande> commandes = commandeService.getCommandes();
        if(!commandes.iterator().hasNext()) throw new CommandeNotFounException("Aucune Commande existante");
        return commandes;
    }

    @GetMapping("/commande/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Commande> getCommande(@PathVariable Integer id){
        Optional<Commande> commande = commandeService.getCommande(id);
        if(commande.isEmpty()) throw new CommandeNotFounException("Cette Commande n'existe pas");
        return commande;
    }

    @PutMapping("/PaidCommand")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Commande updatePaidCommand(@RequestBody Commande commande){
        if(commande.getId() == null || commandeService.getCommande(commande.getId()).isEmpty()){throw new CommandNotModifiedException("La commande que vous voulez modifier n'existe pas");}
        commande.setEstPayee(true);
        Commande updatedCommande = commandeService.updateCommande(commande);
        if(updatedCommande == null) throw  new CommandNotModifiedException("Impossible de mettre a jour l'etat de paiement de cette commande");
        return updatedCommande;

    }


   @PostMapping("/commande")
   @ResponseStatus(HttpStatus.CREATED)
    public Commande addCommande(@RequestBody Commande commande){
       Commande nouvelleCommande = commandeService.addCommande(commande);
       if(nouvelleCommande == null) throw  new CommandeNotAddeException("Impossible d'ajouter la commande");
        return nouvelleCommande;
   }

}
