package com.ProjetoWebServices.ProjetoWebServices.services;

import java.util.List; 
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.ProjetoWebServices.ProjetoWebServices.entities.Category;
import com.ProjetoWebServices.ProjetoWebServices.entities.User;
import com.ProjetoWebServices.ProjetoWebServices.repositories.CategoryRepository;
import com.ProjetoWebServices.ProjetoWebServices.services.exceptions.DatabaseException;
import com.ProjetoWebServices.ProjetoWebServices.services.exceptions.ResourceNotFoundException;



@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;
	
	public List<Category> findAll(){
		return repository.findAll();
	}
	
	public Category findById(Long Id) {
		Optional<Category> obj = repository.findById(Id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(Id));
	}
	public Category insert(Category obj) {
		return repository.save(obj);
	}
	public void delete(Long id) {
		try{
			if(repository.existsById(id)){
				repository.deleteById(id);
			}
			else {
				throw new ResourceNotFoundException(id);
			}
		}
		catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	public Category update(Long id, Category obj) {
		if(repository.existsById(id)){
			Category entity = repository.getReferenceById(id); //não vai no banco de dados, ele retorna um objeto monitorado pelo jpa
			updateData(entity, obj);
			return repository.save(entity);
		}
		else {
			throw new ResourceNotFoundException(id);
		}
	}
	private void updateData(Category entity, Category obj) {
		entity.setName(obj.getName());
		
	}
	
}
