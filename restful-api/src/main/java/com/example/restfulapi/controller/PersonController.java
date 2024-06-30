package com.example.restfulapi.controller;

import com.example.restfulapi.model.Person;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    private final List<Person> people = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong();

    @GetMapping
    public List<Person> getAllPeople() {
        return people;
    }

    @PostMapping
    public Person createPerson(@RequestBody Person person) {
        person.setId(counter.incrementAndGet());
        people.add(person);
        return person;
    }

    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable("id") Long id) {
        return people.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @PutMapping("/{id}")
    public Person updatePerson(@PathVariable("id") Long id, @RequestBody Person updatedPerson) {
        Person person = getPersonById(id);
        if (person != null) {
            person.setFirstName(updatedPerson.getFirstName());
            person.setLastName(updatedPerson.getLastName());
        }
        return person;
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable("id") Long id) {
        people.removeIf(person -> person.getId().equals(id));
    }
}