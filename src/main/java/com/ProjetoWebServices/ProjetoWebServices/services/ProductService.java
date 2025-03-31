package com.ProjetoWebServices.ProjetoWebServices.services;

import java.util.List;  
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProjetoWebServices.ProjetoWebServices.entities.Product;
import com.ProjetoWebServices.ProjetoWebServices.repositories.ProductRepository;


@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	public List<Product> findAll(){
		return repository.findAll();
	}
	public Product findById(Long Id) {
		Optional<Product> objOptional = repository.findById(Id);
		return objOptional.get();
	}
}
