package br.com.bartie.api.v2.services;

import java.util.logging.Logger;
import java.util.List;

import org.springframework.stereotype.Service;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import br.com.bartie.data.repositories.PersonRepository;
import br.com.bartie.api.v2.controllers.PersonControllerV2;
import br.com.bartie.api.v2.mapper.PersonMapper;
import br.com.bartie.api.v2.view.PersonDTO;
import br.com.bartie.data.models.Person;
import br.com.bartie.app.exceptions.RequiredObjectIsNullException;
import br.com.bartie.app.exceptions.ResourceNotFoundException;
import br.com.bartie.app.serialization.ModelServices;


@Service
public class PersonServicesV2 extends ModelServices<PersonRepository> {

    
    private Logger logger = Logger.getLogger(PersonServicesV2.class.getName());

    
    public List<PersonDTO> getAll() {

        logger.info("Get all persons!");

        var list = PersonMapper.parseDTO(repository.findAll());

        list.stream().forEach(item -> addLink(item));
   
        return list;

    }

    public PersonDTO find(Long id) {
        
        Person item = repository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("No record found!"));

        logger.info("Get one person! >> " + item.getFullName());

        return addLink(PersonMapper.parseDTO(item));

    }

    public PersonDTO create(Person person) {

        if (person == null) throw new RequiredObjectIsNullException();

        logger.info("Create one person! >> " + person.getFullName());

        return addLink(PersonMapper.parseDTO(repository.save(person)));

    }

    public PersonDTO create(PersonDTO person) {

        return create(PersonMapper.parse(person));
    }

    public PersonDTO update(PersonDTO person) {
        
        return update(PersonMapper.parse(person));
    }

    public PersonDTO update(Person person) {
        
        if (person == null) throw new RequiredObjectIsNullException();

        logger.info("Update one person! >> " + person.getFullName());

        return addLink(PersonMapper.parseDTO(repository.save(person)));

    }

    public void delete(PersonDTO person) {

        Person item = PersonMapper.parse(person);

        logger.info("Update one person! >> " + item.getFullName());

        repository.delete(item);

    }

    public void delete(Long id) {

        PersonDTO item = find(id);

        if (item != null)
        {
            delete(item);
        }

    }

        private PersonDTO addLink(PersonDTO item) { 
        Link link = getLink(WebMvcLinkBuilder.methodOn(PersonControllerV2.class).get(item.getId())); 

        return item.add(link);
    }
   
}
