package com.example.microservicepaiement.service;

import com.example.microservicepaiement.model.Paiement;
import com.example.microservicepaiement.repository.PaiementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaiementService {

    @Autowired
    private PaiementRepository paiementRepository;

    /**
     *
     * @param paiement paiement d'une commande
     * @return paiement si tout s'est bien passe
     */
    public Paiement addPaiement(Paiement paiement){
        return paiementRepository.save(paiement);
    }

    /**
     *
     * @param id - order id
     * @return  paiement
     */
    public Optional<Paiement> getPaiementByIdCommande(Integer id){
        return paiementRepository.findById(id);
    }
}
