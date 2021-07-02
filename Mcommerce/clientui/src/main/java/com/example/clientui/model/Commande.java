package com.example.clientui.model;

import lombok.Data;

import java.util.Date;

@Data
public class Commande {
    private Integer id;
    private Date date;
    private boolean estPayee;
    private Integer idProduit;
    private Integer quantite;
}
