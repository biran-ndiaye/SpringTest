package com.ecommerce.microcommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
@Data
@Table(name = "produit")
public class Produit {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    @Length(min=1 ,max = 20, message = "le nom doit etre compris entre 1 et 20")
    private String nom;

    @JsonIgnore // pour cacher certaines informations
    @Column(name = "price")
    @Min(value = 1)
    private  double prix;
}
