package com.learning.springboot.controller.version;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.springboot.entity.version.Name;
import com.learning.springboot.entity.version.PersonV1;
import com.learning.springboot.entity.version.PersonV2;

@RestController
public class VersioningPersonSbiController {

	@GetMapping(value = "/{version}/personsbi", version = "1.0.0")
	public PersonV1 getFirstVersionOfPerson() {
		return new PersonV1("Bob Charlie");
	}

	@GetMapping(value = "/{version}/personsbi", version = "2.0.0")
	public PersonV2 getSecondVersionOfPerson() {
		return new PersonV2(new Name("Bob", "Charlie"));
	}

	@GetMapping(path = "/personsbi", version = "1.0.0")
	public PersonV1 getFirstVersionOfPersonRequestParameter() {
		return new PersonV1("Bob Charlie");
	}

	@GetMapping(path = "/personsbi", version = "2.0.0")
	public PersonV2 getSecondVersionOfPersonRequestParameter() {
		return new PersonV2(new Name("Bob", "Charlie"));
	}

}
