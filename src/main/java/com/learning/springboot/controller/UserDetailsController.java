package com.learning.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.URL;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.learning.springboot.entity.UserDetails;
import com.learning.springboot.service.UserService;

@RestController
@RequestMapping("user/v1")
public class UserDetailsController {

	@Autowired
	private UserService userService;

	// CREATE
	@PostMapping("/save")
	public ResponseEntity<UserDetails> createUser(@RequestBody UserDetails user) {
		UserDetails saveUser = userService.saveUser(user);
		System.err.println("saveUser.getId()   "+ saveUser.getId());
		System.err.println("ServletUriComponentsBuilder.fromCurrentContextPath() "+ ServletUriComponentsBuilder.fromCurrentContextPath());
		
		
		URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/user/v1/{id}")
				.buildAndExpand(saveUser.getId()).toUri();
		
		/*
		 * suppose get mapping URL will be different use fromCurrentContextPath instead of  fromCurrentRequest 
		 * fromCurrentRequest() - http://localhost:8080/user/v1/users/save 
		 * fromCurrentContextPath() - http://localhost:8080
		 * 
		 * Receive in postman header from response 
		 * output like this : Location : 	http://localhost:8080/user/v1/3
		 * 
		 */
		return ResponseEntity.created(location).build();
	}

	// READ ALL
	@GetMapping
	public List<UserDetails> getAllUsers() {
		return userService.getAllUsers();
	}

	// READ BY ID
	@GetMapping("/{id}")
	public UserDetails getUserById(@PathVariable Long id) {
		return userService.getUserById(id);
	}

	// UPDATE
	@PutMapping("/{id}")
	public UserDetails updateUser(@PathVariable Long id, @RequestBody UserDetails user) {
		return userService.updateUser(id, user);
	}

	// DELETE
	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
		return "User deleted successfully";
	}

}
