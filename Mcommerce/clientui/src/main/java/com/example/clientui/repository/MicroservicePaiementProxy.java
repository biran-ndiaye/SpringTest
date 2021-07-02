package com.example.clientui.repository;

import com.example.clientui.model.Paiement;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "microservice-paiement", url="localhost:9091")
public interface MicroservicePaiementProxy {
    @PostMapping("/paiement")
    Paiement addPaiement(Paiement paiement);
}
