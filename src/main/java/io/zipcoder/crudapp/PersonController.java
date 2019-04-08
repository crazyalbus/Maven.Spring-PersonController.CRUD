package io.zipcoder.crudapp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    @PutMapping(value = "/people")
    public ResponseEntity<Person> createPerson(@RequestBody Person person){
        return new ResponseEntity<>(service.create(person), HttpStatus.CREATED);
    }

    @GetMapping(value = "/people")
    public ResponseEntity<List<Person>> index() {
        return new ResponseEntity<>(service.index(), HttpStatus.OK);
    }

    @GetMapping(value = "/people/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable Long id){
        return new ResponseEntity<>(service.show(id), HttpStatus.OK);
    }

    @PutMapping(value = "/people/{id}")
    public ResponseEntity<Person> updatePerson(@RequestBody Person person){
        return new ResponseEntity<>(service.update(person), HttpStatus.OK);
    }

    @DeleteMapping(value = "/people/{id}")
    public ResponseEntity<Boolean> deletePerson(Long id){
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }
}