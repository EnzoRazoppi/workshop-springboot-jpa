package com.ProjetoWebServices.ProjetoWebServices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProjetoWebServices.ProjetoWebServices.entities.User;
import com.ProjetoWebServices.ProjetoWebServices.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	public User findById(Long Id) {
		Optional<User> objOptional = repository.findById(Id);
		return objOptional.get();
	}
	public User insert(User obj) {
		return repository.save(obj);
	}
	public void delete(Long id) {
		repository.deleteById(id);
	}
	public User update(Long id, User obj) {
		User entity = repository.getReferenceById(id); //não vai no banco de dados, ele retorna um objeto monitorado pelo jpa
		updateData(entity, obj);
		return repository.save(entity);
	}
	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
		
	}
}
