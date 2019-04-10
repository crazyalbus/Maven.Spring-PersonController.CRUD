package io.zipcoder.crudapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonController {

    private PersonService service;

    @Autowired
    public PersonController(PersonService service) {
        this.service = service;
    }

    @PutMapping(value = "/people")
    public ResponseEntity<Person> createPerson(@RequestBody Person person){
        return new ResponseEntity<>(service.create(person), HttpStatus.CREATED);
    }

    @GetMapping(value = "/people")
    public ResponseEntity<Iterable<Person>> index() {
        return new ResponseEntity<>(service.index(), HttpStatus.OK);
    }

    @GetMapping(value = "/people/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable Long id){
        return new ResponseEntity<>(service.show(id), HttpStatus.OK);
    }

    @PutMapping(value = "/people/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable Long id, @RequestBody Person person){
        return new ResponseEntity<>(service.update(id, person), HttpStatus.OK);
    }

    @DeleteMapping(value = "/people/{id}")
    public ResponseEntity<Boolean> deletePerson(@PathVariable Long id){
        return new ResponseEntity<>(service.delete(id), HttpStatus.NO_CONTENT);
    }
}