package com.higoramorim.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.higoramorim.workshopmongo.domain.User;
import com.higoramorim.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();

		User higor = new User(null, "Higor Amorim", "higor137785@gmail.com");
		User davi = new User(null, "Davi Amorim", "davi171213@gmail.com");
		User sandra = new User(null, "Sandra Ramos", "sandra.d.almeida@hotmail.com");

		userRepository.saveAll(Arrays.asList(higor, davi, sandra));
	}

}
