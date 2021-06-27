package com.example.microservicepaiement.repository;

import com.example.microservicepaiement.model.Paiement;
import org.springframework.data.repository.CrudRepository;

public interface PaiementRepository extends CrudRepository<Paiement, Integer> {
}
