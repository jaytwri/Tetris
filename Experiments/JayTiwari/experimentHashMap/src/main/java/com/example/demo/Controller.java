package com.example.demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;

@RestController
public class Controller {

	HashMap<String, Gamer> gamerGang = new HashMap<>();

	@GetMapping("/gamers")
	public @ResponseBody HashMap<String, Gamer> getAllPersons() {
		return gamerGang;
	}

	@PostMapping("/gamers")
	public @ResponseBody String createGamer(@RequestBody Gamer gamer) {
		System.out.println(gamer);
		gamerGang.put(gamer.getFirstName(), gamer);
		return "New gamer " + gamer.getFirstName() + " Saved";
	}

	@GetMapping("/gamers/{firstName}")
	public @ResponseBody Gamer getGamer(@PathVariable String firstName) {
		Gamer g = gamerGang.get(firstName);
		return g;
	}

	@PutMapping("/gamers/{firstName}")
	public @ResponseBody Gamer updateGamer(@PathVariable String firstName, @RequestBody Gamer g) {
		gamerGang.replace(firstName, g);
		return gamerGang.get(firstName);
	}

	@DeleteMapping("/gamers/{firstName}")
	public @ResponseBody HashMap<String, Gamer> deleteGamer(@PathVariable String firstName) {
		gamerGang.remove(firstName);
		return gamerGang;
	}

}
