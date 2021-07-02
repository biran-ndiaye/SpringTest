package com.example.clientui.repository;

import com.example.clientui.model.Produit;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name = "microservice-produits", url="localhost:9090")
public interface MicroserviceProduitProxy {
    @GetMapping(value = "/Produits")
    Iterable<Produit> getProduits();

    @GetMapping(value = "/Produit/{id}")
    Optional<Produit> getPrduit(@PathVariable("id") int id);
}
