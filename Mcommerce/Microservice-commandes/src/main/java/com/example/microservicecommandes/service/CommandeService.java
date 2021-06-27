package com.example.microservicecommandes.service;

import com.example.microservicecommandes.model.Commande;
import com.example.microservicecommandes.repository.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Service
public class CommandeService {

    @Autowired
    private CommandeRepository commandeRepository;

    /**
     *
     * @param id - get order by id
     * @return an order or null
     */
    public Optional<Commande> getCommande(Integer id){
        return  commandeRepository.findById(id);
    }

    /**
     *
     * @param commande - order to add
     * @return added order
     */
    public Commande addCommande(Commande commande){
        return commandeRepository.save(commande);
    }
}
