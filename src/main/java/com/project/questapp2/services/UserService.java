package com.project.questapp2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.questapp2.entities.User;
import com.project.questapp2.repos.UserRepository;

@Service
public class UserService {
	
	UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<User> getAllUsers() { //Tüm userları bulacak
		return userRepository.findAll(); //findAll() = jpa repository'nin bir methodu tüm kullanıcıları veritabanından çeker.
	}

	public User saveOneUser(User newUser) {
		return userRepository.save(newUser); //user'ı database'e kaydet ve dön
	}

	public User getOneUser(Long userId) {
		return userRepository.findById(userId).orElse(null);
		
	}

	public User updateOneUser(Long userId, User newUser) {
		Optional<User>user = userRepository.findById(userId); //Optional: it is used to represent a value that may or may not be present. 
		if(user.isPresent()) {
			User foundUser = user.get(); //if user is present get the value that optional has
			foundUser.setUserName(newUser.getUserName()); 
			foundUser.setPassword(newUser.getPassword());
			userRepository.save(foundUser);	//save updates
			return foundUser;
			
		}else
			return null;
	}

	public void deleteById(Long userId) {
		userRepository.deleteById(userId);
	}
	

}
