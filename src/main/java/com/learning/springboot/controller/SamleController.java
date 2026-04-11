package com.learning.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.learning.springboot.jsonClass.HelloWorld;

@RestController
public class SamleController {
	
	@GetMapping("/test")
	private String test() {
		System.err.println("validate working fine ");
		return "Test";
	}
	
	@GetMapping("/json")
	private HelloWorld getJsondata() {
		return new HelloWorld("testing");
	}
	
	@GetMapping("/path-variable/{name}")
	private HelloWorld getPathVariable(@PathVariable String name) {
		return new HelloWorld( String.format("Hello world %s", name));
	}

}
