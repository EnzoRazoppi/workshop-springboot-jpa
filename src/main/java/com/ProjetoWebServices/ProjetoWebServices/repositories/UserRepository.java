package com.ProjetoWebServices.ProjetoWebServices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ProjetoWebServices.ProjetoWebServices.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
}
