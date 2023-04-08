package br.com.bartie.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bartie.exceptions.ResourceNotFoundException;
import br.com.bartie.models.Person;
import br.com.bartie.repositories.PersonDTO;

@Service
public class PersonServices {

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    private PersonDTO repository;
    
    public List<Person> getAll() {

        logger.info("Get all persons!");

        return repository.findAll();

    }

    public Person get(Long id) {

        logger.info("Get one person! >> " + id);

        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Notttttt"));

    }

    public Person add(Person person) {

        logger.info("Create one person! >> " + person.firstName);

        return repository.save(person);

    }

    public Person save(Person person) {

        logger.info("Save one person! >> " + person.firstName);

        return repository.save(person);

    }

    public void delete(Long id) {

        var person = get(id);

        if (person != null)
        {
            logger.info("Delete one person! >> " + id);

            repository.delete(person);
        }

    }

    // private Person mockPerson() {

    //     Person person = new Person();

    //     long index = 1; // counter.incrementAndGet();

    //     person.id = index;
    //     person.firstName = "FistName#" + index ;
    //     person.lastName = "LastName#" + index ;
    //     person.address = "Adress#" + index ;
    //     person.gender = "Gender#" + index ;

    //     return person;
    // }
    
}
