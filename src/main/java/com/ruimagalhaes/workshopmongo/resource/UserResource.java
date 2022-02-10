package com.ruimagalhaes.workshopmongo.resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ruimagalhaes.workshopmongo.domain.User;

//Informa que essa class é um recurso Rest
@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<User>> findAll() {
		
		List<User> list = new ArrayList<>();
		User maria = new User("1", "Maria Brown", "maria@gmail.com");
		User alex = new User("1", "Alex Green", "alex@gmail.com");
		
		list.addAll(Arrays.asList(maria,alex));
		return (ResponseEntity<List<User>>) ResponseEntity.ok().body(list);
	}

}
