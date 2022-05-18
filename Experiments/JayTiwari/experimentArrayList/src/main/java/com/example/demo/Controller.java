package com.example.demo;

import java.util.ArrayList;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	ArrayList<softdrinks> softdrinksGang = new ArrayList<>();

	@GetMapping("/softdrinks")
	public @ResponseBody ArrayList<softdrinks> getAllPersons() {
		return softdrinksGang;
	}

	@PostMapping("/softdrinks")
	public @ResponseBody String createsoftdrinks(@RequestBody softdrinks softdrinks) {
		System.out.println(softdrinks);
		softdrinksGang.add(softdrinks);
		return "New softdrinks " + softdrinks.getname() + " saved";
	}

}
