package io.zipcoder.crudapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
public class PersonController {
    @Autowired
    PersonRepository personRepository;

    @PostMapping("/peopele")
    public Person createPerson(@PathVariable Person p){
        return personRepository.save(p);
    }

    @GetMapping("/people{id}")
    public Person getPerson(@PathVariable int id){
        return personRepository.findOne(id);
    }

    @GetMapping("/people")
    public Iterable<Person> getPersonList(){
        return personRepository.findAll();
    }

    @PostMapping("/people/{id}")
    public Person updatePerson(@PathVariable int id, @RequestBody Person p){
        Person old = getPerson(id);
        old.setFirstName(p.getFirstName());
        old.setLastName(p.getLastName());
        return this.personRepository.save(old);
    }

    @DeleteMapping("/people/{id}")
    public void deletePerson(@PathVariable int id){
        personRepository.delete(id);
    }

}
