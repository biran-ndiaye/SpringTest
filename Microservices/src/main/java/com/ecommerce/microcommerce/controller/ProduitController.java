package com.ecommerce.microcommerce.controller;

import com.ecommerce.microcommerce.model.Produit;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProduitController {

    @GetMapping("/Produits")
    public String getProduits(){
        return "Produit 1";
    }
    @GetMapping("/Produits/{id}")
    public Produit getPrduit(@PathVariable("id") Long id){
        return new Produit(1L,"Aspirateur", 200.5);
    }

}
