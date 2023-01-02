package com.person.CrudOperations.repository;

import com.person.CrudOperations.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PersonsRepository {
    private List<Person> list = new ArrayList<Person>();

    public List<Person> getAllPersons() {
        return list;
    }

    public Person findById(int id){
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == (id)) {
                return (list.get(i));
            }
        }
        return null;
    }

    public Boolean existById(int id){
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == (id)) {
                return true;
            }
        }
        return false;
    }

    public Person save(Person p) {
        Person person = new Person();
        person.setId(p.getId());
        person.setName(p.getName());
        person.setAge(p.getAge());
        list.add(person);
        return person;
    }

    public String delete(Integer id) {
        list.removeIf(x -> x.getId() == (id));
        return null;
    }

    public Person update(Person person) {
        int idx = 0;
        int id = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == (person.getId())) {
                id = person.getId();
                idx = i;
                break;
            }
        }

        Person modi = new Person();
        modi.setId(id);
        modi.setName(person.getName());
        modi.setAge(person.getAge());
        list.set(idx, person);
        return modi;
    }
}
