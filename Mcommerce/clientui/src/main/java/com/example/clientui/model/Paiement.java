package com.example.clientui.model;

import lombok.Data;

@Data
public class Paiement {
    private Integer id;
    private double montant;
    private Long numeroCarte;
    private Integer idCommande;
}
