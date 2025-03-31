package com.ProjetoWebServices.ProjetoWebServices.services;

import java.util.List; 
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProjetoWebServices.ProjetoWebServices.entities.Category;
import com.ProjetoWebServices.ProjetoWebServices.repositories.CategoryRepository;



@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;
	
	public List<Category> findAll(){
		return repository.findAll();
	}
	public Category findById(Long Id) {
		Optional<Category> objOptional = repository.findById(Id);
		return objOptional.get();
	}
}
