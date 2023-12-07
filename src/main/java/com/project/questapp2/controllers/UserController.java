package com.project.questapp2.controllers;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.questapp2.entities.User;
import com.project.questapp2.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	private UserService userService; 
	
	public UserController(UserService userService) { //UserRepository'e değer atamamızı sağlayacak
		this.userService = userService;
	}
	
	@GetMapping //get all users
	public List <User> getAllUsers(){ //get all users
		return userService.getAllUsers() ; //it will get all user from service layer
		 
	}
	@PostMapping //bir şeyler yaratmak için kullanılır
	public User createUser(@RequestBody User newUser) { //Aldığın create requestinin bodysini user objesi olarak maple ve döndür
		return userService.saveOneUser(newUser);
	} 
	
	@GetMapping("/{userId}") //get a spesicific user
	public User getOneUser(@PathVariable Long userId) {
		return userService.getOneUser(userId);
	}
	@PutMapping("/{userId}") //update specific user
	public User updateOneUser(@PathVariable Long userId, @RequestBody User newUser) {
		return userService.updateOneUser(userId, newUser);
	}
	@DeleteMapping("/{userId}")
	public void deleteOneUser(@PathVariable Long userId) {//delete user accordig to their ID
		userService.deleteById(userId);
	}
	
		
		
	}

