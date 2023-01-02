package com.person.CrudOperations.controller;

import com.person.CrudOperations.model.Person;
import com.person.CrudOperations.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/persons")
public class PersonController {

    @Autowired
    private PersonService service;


    @PostMapping
    public Person addPerson(@RequestBody Person person) {
        return service.savePerson(person);
    }

    @GetMapping
    public List<Person> findAllPerson() {
        return service.getPersons();
    }

    @GetMapping("{id}")
    public Optional<Person> findPersonById(@PathVariable int id) {
        return service.getPersonById(id);
    }

    @PutMapping
    public Person updatePerson(@RequestBody Person person) {
        return service.updatePerson(person);
    }

    @DeleteMapping("{id}")
    public String deleteperson(@PathVariable int id) {
        return service.deletePerson(id);
    }
}