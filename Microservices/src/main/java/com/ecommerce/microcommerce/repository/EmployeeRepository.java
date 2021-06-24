package com.ecommerce.microcommerce.repository;

import com.ecommerce.microcommerce.model.Produit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Produit,Long> {
}
