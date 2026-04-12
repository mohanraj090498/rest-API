package com.learning.springboot.controller;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.learning.springboot.jsonClass.HelloWorld;

@RestController
public class SamleController {
	
	private MessageSource messageSource;
	
	public SamleController(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

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
	
	@GetMapping("/json-internationlize")
	private String getJsondataInternationalize() {
		Locale locale=LocaleContextHolder.getLocale();
		return	messageSource.getMessage("goodMorning.message",null,"Default message",locale);
	}
	
	//Request param version
	@GetMapping(path = "/version",params = "version=v1")
	private HelloWorld getRequestParamParametersV1() {
		return new HelloWorld( String.format("Hello world v1"));
	}
	
	@GetMapping(path = "/version",params = "VERSION=v2")
	private HelloWorld getRequestParamParametersV2() {
		return new HelloWorld( String.format("Hello world v2"));
	}
	
}
