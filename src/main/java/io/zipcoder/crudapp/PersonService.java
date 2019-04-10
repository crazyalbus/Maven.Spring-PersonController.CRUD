package io.zipcoder.crudapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private PersonRepository repository;

    @Autowired
    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public Iterable<Person> index() {
        return repository.findAll();
    }

    public Person show(Long id) {
        return repository.findOne(id);
    }

    public Person create(Person baker) {
        return repository.save(baker);
    }

    public Person update(Long id, Person newPersonData) {
        Person originalPerson = repository.findOne(id);
        originalPerson.setFirstName(newPersonData.getFirstName());
        originalPerson.setLastName(newPersonData.getLastName());
        return repository.save(originalPerson);
    }

    public Boolean delete(Long id) {
        repository.delete(id);
        return true;
    }

}
