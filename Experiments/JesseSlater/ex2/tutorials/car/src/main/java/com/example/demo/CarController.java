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

/**
 * Controller used to showcase Create and Read from a LIST
 *
 * @author Vivek Bengre
 */

@RestController
public class CarController {

    // Note that there is only ONE instance of PeopleController in 
    // Springboot system.
    HashMap<String, Car> carList = new  HashMap<>();

    //CRUDL (create/read/update/delete/list)
    // use POST, GET, PUT, DELETE, GET methods for CRUDL

    // THIS IS THE LIST OPERATION
    // gets all the people in the list and returns it in JSON format
    // This controller takes no input. 
    // Springboot automatically converts the list to JSON format 
    // in this case because of @ResponseBody
    // Note: To LIST, we use the GET method
    @GetMapping("/car")
    public @ResponseBody HashMap<String,Car> getAllPersons() {
        return carList;
    }

    // THIS IS THE CREATE OPERATION
    // springboot automatically converts JSON input into a person object and 
    // the method below enters it into the list.
    // It returns a string message in THIS example.
    // in this case because of @ResponseBody
    // Note: To CREATE we use POST method
    @PostMapping("/car")
    public @ResponseBody String createPerson(@RequestBody Car person) {
        System.out.println(person);
        carList.put(person.getModel(), person);
        return "New car "+ person.getModel() + " Saved";
    }
    
    @PostMapping("/person")
    public @ResponseBody String createPerson(@RequestBody String person) {
        System.out.println(person);
        return "New car "+ person + " Saved";
    }
    // THIS IS THE READ OPERATION
    // Springboot gets the PATHVARIABLE from the URL
    // We extract the person from the HashMap.
    // springboot automatically converts Person to JSON format when we return it
    // in this case because of @ResponseBody
    // Note: To READ we use GET method
    @GetMapping("/car/{firstName}")
    public @ResponseBody Car getPerson(@PathVariable String firstName) {
        Car p = carList.get(firstName);
        return p;
    }

    // THIS IS THE UPDATE OPERATION
    // We extract the person from the HashMap and modify it.
    // Springboot automatically converts the Person to JSON format
    // Springboot gets the PATHVARIABLE from the URL
    // Here we are returning what we sent to the method
    // in this case because of @ResponseBody
    // Note: To UPDATE we use PUT method
    @PutMapping("/car/{firstName}")
    public @ResponseBody Car updatePerson(@PathVariable String firstName, @RequestBody Car p) {
        carList.replace(firstName, p);
        return carList.get(firstName);
    }

    // THIS IS THE DELETE OPERATION
    // Springboot gets the PATHVARIABLE from the URL
    // We return the entire list -- converted to JSON
    // in this case because of @ResponseBody
    // Note: To DELETE we use delete method
    
    @DeleteMapping("/car/{firstName}")
    public @ResponseBody HashMap<String, Car> deletePerson(@PathVariable String firstName) {
        carList.remove(firstName);
        return carList;
    }
}