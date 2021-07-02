package com.example.clientui.repository;

import com.example.clientui.model.Commande;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@FeignClient(name = "microservice-commandes", url="localhost:9092")
public interface MicroserviceCommandeProxy {

    @GetMapping("/commande/{id}")
    Optional<Commande> getCommande(@PathVariable Integer id);

    @PostMapping("/commande")
    Commande addCommande(@RequestBody Commande commande);

    @PutMapping("/PaidCommand")
   Commande updatePaidCommand(@RequestBody Commande commande);

}
