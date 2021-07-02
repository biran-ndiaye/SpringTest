package com.example.clientui.model;

import lombok.Data;

@Data
public class Produit {
    private Integer id;
    private String titre;
    private String description;
    private double prix;
    private String image;
}
