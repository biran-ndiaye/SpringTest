package com.ecommerce.microcommerce.service;

import com.ecommerce.microcommerce.model.Produit;
import com.ecommerce.microcommerce.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProduitService {

    @Autowired
    ProduitRepository produitRepository;

    /**
     *
     * @param id product id
     * @return a product or null
     */
    public Optional<Produit> getProduct(Long id){
        return produitRepository.findById(id);
    }

    /**
     *
     * @return Iterable products
     */
    public Iterable<Produit> getProducts(){
        return produitRepository.findAll();
    }

    /**
     *
     * @param id a product id
     */
    public void deleteProduct(final Long id){
        produitRepository.deleteById(id);
    }

    /**
     *
     * @param p product to save
     * @return product saved
     */
    public Produit saveProduct(Produit p){
        return produitRepository.save(p);
    }
}
