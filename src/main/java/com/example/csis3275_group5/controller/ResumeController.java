package com.example.csis3275_group5.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.csis3275_group5.model.User;
import com.example.csis3275_group5.repository.UserRepo;

@CrossOrigin(origins = "http://localhost:8081") // for Vue.js
@RestController
@RequestMapping("/api")
public class ResumeController {

	@Autowired
	UserRepo userRepo;
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUser() {
		try {
			List<User> users = new ArrayList<>();
			
			userRepo.findAll().forEach(users::add);
				
			if (users.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<>(users, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("user/{username}")
	public ResponseEntity<User> getUser(@PathVariable String username) {
		 try {
			 Optional<User> user = userRepo.findByUsername(username);
			 
			 if (user.isPresent()) {
				 return new ResponseEntity<>(user.get(), HttpStatus.OK);
			 }
			 
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			 
		 } catch (Exception e) {
			 return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		 }
	}
	
//	@PostMapping("/users")
//	public ResponseEntity<User> createUser(@RequestBody User user) {
//		 try {
//			 User newUser = new User(user.getCode(), user.getTitle());
//			 userRepo.save(newUser);
//			 return new ResponseEntity<>(newUser, HttpStatus.CREATED);
//			 
//		 } catch (Exception e) {
//			 return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//		 }
//	}
	
}