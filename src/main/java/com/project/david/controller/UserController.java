package com.project.david.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.david.entity.User;
import com.project.david.reposiory.UserRepository;

@RestController
@RequestMapping("/api/users")
public class UserController{
	private static final Logger logger=LogManager.getLogger(UserController.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping
	public List<User> getAllUsers(){
		logger.debug("Retrieving list of users...");
		return userRepository.findAll();
	}
	
	@PostMapping
	public User createUser(@RequestBody User user) {
		logger.info("Creating user:{}",user.getName());
		return userRepository.save(user);
	}
	@GetMapping("/{id}")
	public User getUserById(@PathVariable("id") Integer id) {
		logger.debug("Retrieving user with id {}",id);
		return userRepository.findById(id).orElse(null);
	}
	
	@PutMapping("/{id}")
	public User updateUser(@PathVariable("id")Integer id,@RequestBody User userDetail) {
		return userRepository.findById(id).map(user->{
			user.setName(userDetail.getName());
			user.setEmail(userDetail.getEmail());
			logger.info("Updating user with id {}",id);
			return userRepository.save(user);
		}).orElseGet(() -> {
			logger.error("User not found with id {}",id);
			return null;
		});
	}
	
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable("id") Integer id) {
		logger.info("Deleting user with id {}",id);
		userRepository.deleteById(id);
	}
}
