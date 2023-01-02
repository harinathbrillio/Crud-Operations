package com.person.CrudOperations.service;

import com.person.CrudOperations.model.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {

    Person savePerson(Person person);
    List<Person> getPersons();
    Optional<Person> getPersonById(int id);
    String deletePerson(int id);
    Person updatePerson(Person person);

}
