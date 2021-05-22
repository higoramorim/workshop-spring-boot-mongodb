package com.higoramorim.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.higoramorim.workshopmongo.domain.User;

@RestController
@RequestMapping(value="/users")
public class UserResource {

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<User>> findAll(){
		User higor = new User("1", "Higor Amorim", "higor137785@gmail.com");
		User davi = new User("1", "Davi Amorim", "davi171213@gmail.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(higor, davi));
		return ResponseEntity.ok().body(list);
	}
}
