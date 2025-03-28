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
}
