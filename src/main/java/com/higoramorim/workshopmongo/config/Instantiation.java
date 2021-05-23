package com.higoramorim.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.higoramorim.workshopmongo.domain.Post;
import com.higoramorim.workshopmongo.domain.User;
import com.higoramorim.workshopmongo.dto.AuthorDTO;
import com.higoramorim.workshopmongo.dto.CommentDTO;
import com.higoramorim.workshopmongo.repository.PostRepository;
import com.higoramorim.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();

		User higor = new User(null, "Higor Amorim", "higor137785@gmail.com");
		User davi = new User(null, "Davi Amorim", "davi171213@gmail.com");
		User sandra = new User(null, "Sandra Ramos", "sandra.d.almeida@hotmail.com");
		
		userRepository.saveAll(Arrays.asList(higor, davi, sandra));
		
		Post post1 = new Post(null, sdf.parse("21/03/2021"), "title", "mensagem", new AuthorDTO(higor));
		Post post2 = new Post(null, sdf.parse("30/03/2021"), "title: happy bithday", "mensagem: quero bolo", new AuthorDTO(sandra));
		Post post3 = new Post(null, sdf.parse("17/12/2020"), "title: happy bithday", "mensagem: te amo pai", new AuthorDTO(davi));

		CommentDTO c1 = new CommentDTO("comment1", sdf.parse("21/03/2021"), new AuthorDTO(higor));
		CommentDTO c2 = new CommentDTO("comment2", sdf.parse("30/03/2021"), new AuthorDTO(sandra));
		CommentDTO c3 = new CommentDTO("comment3", sdf.parse("17/12/2020"), new AuthorDTO(davi));

		post1.getComments().addAll(Arrays.asList(c1));
		post2.getComments().addAll(Arrays.asList(c2));
		post3.getComments().addAll(Arrays.asList(c3));

		postRepository.saveAll(Arrays.asList(post1, post2, post3));
		higor.getPosts().addAll(Arrays.asList(post1));
		sandra.getPosts().addAll(Arrays.asList(post2));
		davi.getPosts().addAll(Arrays.asList(post3));
		userRepository.save(higor);
		userRepository.save(sandra);
		userRepository.save(davi);
		
	}

}
