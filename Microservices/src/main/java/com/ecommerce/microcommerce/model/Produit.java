package com.ecommerce.microcommerce.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "produit")
public class Produit {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String nom;

    @Column(name = "price")
    private  double prix;

    public Produit(){}

    public Produit(Long id, String nom, double prix) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
    }
}
