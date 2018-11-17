package mcgill.ca.ecse321.group6backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mcgill.ca.ecse321.group6backend.model.User;
import mcgill.ca.ecse321.group6backend.repository.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	UserRepository uRepository;
	
	@RequestMapping("/")
	public String greeting() {
		return "Hello world!";
	}
	
	@PostMapping("/user/{name}")
	public String createUser(@PathVariable("name") String name) {
		User user = uRepository.createUser(name);
		return user.getName();
	}
	
	@RequestMapping("/user/{name}")
	public User getUser(@PathVariable("name") String name) {
		User user = uRepository.getUser(name);
		return user;
	}
}
