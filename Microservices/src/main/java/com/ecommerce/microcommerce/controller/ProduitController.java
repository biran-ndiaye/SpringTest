package com.ecommerce.microcommerce.controller;

import com.ecommerce.microcommerce.exception.ProduitNotFoundException;
import com.ecommerce.microcommerce.model.Produit;
import com.ecommerce.microcommerce.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
public class ProduitController {

    @Autowired
    ProduitService produitService;

    @GetMapping("/Produits")
    public Iterable<Produit> getProduits(){
        return produitService.getProducts();
    }
    @GetMapping("/Produit/{id}")
    public Optional<Produit> getPrduit(@PathVariable("id") Long id) throws ProduitNotFoundException {
        Optional<Produit> produit = produitService.getProduct(id);
        if(produit.isEmpty()){
            throw new ProduitNotFoundException("Le produit avec l'id "+ id+" est introuvable");
        }
        return produit;
    }

    @DeleteMapping("/Produit/{id}")
    public void deletePrduit(@PathVariable("id") Long id){
        produitService.deleteProduct(id);
    }

    @PostMapping("/Produit")
    @ResponseStatus(HttpStatus.CREATED)
    public Produit addProduit(@Valid @RequestBody Produit produit){ //@Valid specify that product must be valid
        return produitService.saveProduct(produit);
    }
}
