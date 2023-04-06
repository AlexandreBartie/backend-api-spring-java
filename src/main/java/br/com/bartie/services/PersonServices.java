package br.com.bartie.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.bartie.models.Person;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public List<Person> getAll() {

        logger.info("Get all persons!");

        List<Person> persons = new ArrayList<>();

        for (long index = 0; index < 8; index++) {
            persons.add(mockPerson());
        }

        return persons;

    }

    public Person get(String id) {

        logger.info("Get one person! >> " + id);

        return mockPerson();

    }

    public Person add(Person person) {

        logger.info("Create one person! >> " + person.firstName);

        return person;

    }

    public Person save(Person person) {

        logger.info("Save one person! >> " + person.firstName);

        return person;

    }

    public void delete(String id) {

        logger.info("Delete one person! >> " + id);

    }

    private Person mockPerson() {

        Person person = new Person();

        long index = counter.incrementAndGet();

        person.id = index;
        person.firstName = "FistName#" + index ;
        person.lastName = "LastName#" + index ;
        person.address = "Adress#" + index ;
        person.gender = "Gender#" + index ;

        return person;
    }
    
}
