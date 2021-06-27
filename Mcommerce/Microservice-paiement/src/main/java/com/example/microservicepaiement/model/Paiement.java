package com.example.microservicepaiement.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "paiement")
public class Paiement {
    @Id
    @GeneratedValue
    private Integer id;

    private double montant;

    @Column(name = "id_commande", unique = true)
    private Integer idCommande;

    private Integer numeroCarte;


}
