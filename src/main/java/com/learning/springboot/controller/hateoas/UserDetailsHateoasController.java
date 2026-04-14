package com.learning.springboot.controller.hateoas;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.learning.springboot.entity.UserDetails;
import com.learning.springboot.service.UserService;

@RestController
public class UserDetailsHateoasController {

	@Autowired
	private UserService userService;

	// READ ALL
	@GetMapping("/alluser")
	public List<UserDetails> getAllUsers() {
		return userService.getAllUsers();
	}

	// READ BY ID
	@GetMapping("/user/{id}")
	public EntityModel<UserDetails> getUserById(@PathVariable Long id) {
		UserDetails userDetails = userService.getUserById(id);
		EntityModel<UserDetails> entityModel = EntityModel.of(userDetails);
		WebMvcLinkBuilder link=WebMvcLinkBuilder.linkTo(methodOn(this.getClass()).getAllUsers());
		entityModel.add(link.withRel("all-users"));
		return entityModel;
	}

}
