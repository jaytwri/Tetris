package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class Controller {
	@GetMapping("/")
	public String welcome() {
		return "This is my hello world program for demo 1";
	}

	@GetMapping("/{name}")
	public String welcome(@PathVariable String name) {
		return "Welcome to my first experiment for the demo " + name;
	}

}
