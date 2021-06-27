package com.example.microservicecommandes.repository;

import com.example.microservicecommandes.model.Commande;
import org.springframework.data.repository.CrudRepository;

public interface CommandeRepository extends CrudRepository<Commande, Integer> {
}
