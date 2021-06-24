package com.ecommerce.microcommerce.controller;

import com.ecommerce.microcommerce.model.Produit;
import com.ecommerce.microcommerce.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Optional<Produit> getPrduit(@PathVariable("id") Long id){
        return produitService.getProduct(id);
    }

    @DeleteMapping("/Produit/{id}")
    public void deletePrduit(@PathVariable("id") Long id){
        produitService.deleteProduct(id);
    }

    @PostMapping("/Produit")
    public Produit addProduit(@RequestBody Produit produit){
        return produitService.saveProduct(produit);
    }
}
