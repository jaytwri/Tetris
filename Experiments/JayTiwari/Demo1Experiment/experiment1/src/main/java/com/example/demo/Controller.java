package com.example.demo;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
@RestController
public class Controller {

	ArrayList<Student> names = new ArrayList<Student>();

	@GetMapping("/")
	public String welcome() {
		return "Just testing GetMapping";
	}

	@PostMapping("/people")
	public String method1(@RequestBody Student name) {
		names.add(name);
		return "Name has been added to the arraylist:" + name.toString();
	}

	@GetMapping("/people")
	public ArrayList<Student> returnName() {
		return names;
	}

}
