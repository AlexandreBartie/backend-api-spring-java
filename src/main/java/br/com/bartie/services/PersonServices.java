package br.com.bartie.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bartie.models.Person;
import br.com.bartie.repositories.PersonRepository;
import br.com.bartie.exceptions.ResourceNotFoundException;



@Service
public class PersonServices {

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    private PersonRepository repository;
    
    public List<Person> getAll() {

        logger.info("Get all persons!");

        return repository.findAll();

    }

    public Person get(Long id) {
        
        Person item = repository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("No record found!"));

        logger.info("Get one person! >> " + item.fullName());

        return item;

    }

    public Person add(Person person) {

        logger.info("Create one person! >> " + person.fullName());

        return repository.save(person);

    }

    public Person save(Person person) {

        return repository.save(person);

    }

    public void delete(Person person) {

        logger.info("Delete one person! >> " + person.fullName());

        repository.delete(person);

    }

    public void delete(Long id) {

        Person item = get(id);

        if (item != null)
        {
            delete(item);
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
