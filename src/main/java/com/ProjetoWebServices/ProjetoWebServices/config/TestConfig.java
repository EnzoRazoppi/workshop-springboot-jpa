package com.ProjetoWebServices.ProjetoWebServices.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.ProjetoWebServices.ProjetoWebServices.entities.User;
import com.ProjetoWebServices.ProjetoWebServices.repositories.UserRepository;

// classe de configuração do perfil de teste

@Configuration //annotation para o spring entender que é uma classe de configuração
@Profile("test") // especificar que essa classe é uma configutação especifica do perfil de teste 
public class TestConfig implements CommandLineRunner{
	
	@Autowired // o spring vai instanciar e associar um user repository automaticamnete
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 

		userRepository.saveAll(Arrays.asList(u1, u2));
	}
}
