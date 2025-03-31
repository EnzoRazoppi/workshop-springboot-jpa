package com.ProjetoWebServices.ProjetoWebServices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;  
import org.springframework.stereotype.Repository;

import com.ProjetoWebServices.ProjetoWebServices.entities.Product;

@Repository // não precisa pois o JpaResository já está marcado como componente do Spring
public interface ProductRepository extends JpaRepository<Product, Long> {
	
}
