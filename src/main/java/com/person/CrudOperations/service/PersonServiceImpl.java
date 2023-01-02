package com.person.CrudOperations.service;

import com.person.CrudOperations.exception.UserExistException;
import com.person.CrudOperations.exception.UserNotFoundException;
import com.person.CrudOperations.model.Person;
import com.person.CrudOperations.repository.PersonsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService{
    @Autowired
    private PersonsRepository repository;

    public Person savePerson(Person person) throws UserExistException {
        if(repository.existById(person.getId())){
            throw new UserExistException("User Already Exist with Id");
        }else {
            return repository.save(person);
        }

    }

    public List<Person> getPersons() {
        return repository.getAllPersons();
    }

    public Optional<Person> getPersonById(int id) throws UserExistException {
        if(repository.existById(id)){
            return Optional.ofNullable(repository.findById(id));
        }else{
            throw new UserNotFoundException("User Not Found");
        }
    }

    public String deletePerson(int id) {
        repository.delete(id);
        return "product removed !! " + id;
    }

    public Person updatePerson(Person person) {
        return repository.update(person);
    }
}
