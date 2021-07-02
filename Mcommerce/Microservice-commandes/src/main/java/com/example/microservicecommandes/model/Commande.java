package com.example.microservicecommandes.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.Date;

@Data
@Entity
@Table(name = "commande")
public class Commande {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "id_produit")
    private Integer idProduit;

    @Min(value = 1)
    private Integer quantite;

    @Column(name = "est_payee")
    private boolean estPayee;

    private Date date;

}
