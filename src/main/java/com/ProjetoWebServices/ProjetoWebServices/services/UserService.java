package com.ProjetoWebServices.ProjetoWebServices.services;

import java.util.List; 
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.ProjetoWebServices.ProjetoWebServices.entities.User;
import com.ProjetoWebServices.ProjetoWebServices.repositories.UserRepository;
import com.ProjetoWebServices.ProjetoWebServices.services.exceptions.DatabaseException;
import com.ProjetoWebServices.ProjetoWebServices.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	public User findById(Long Id) {
		Optional<User> obj = repository.findById(Id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(Id));
	}
	public User insert(User obj) {
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
	public User update(Long id, User obj) {
		if(repository.existsById(id)){
			User entity = repository.getReferenceById(id); //não vai no banco de dados, ele retorna um objeto monitorado pelo jpa
			updateData(entity, obj);
			return repository.save(entity);
		}
		else {
			throw new ResourceNotFoundException(id);
		}
	}
	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
		
	}
}
