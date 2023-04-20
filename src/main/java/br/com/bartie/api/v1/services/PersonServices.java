package br.com.bartie.api.v1.services;

import java.util.List;

import java.util.logging.Logger;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import br.com.bartie.data.model.Person;
import br.com.bartie.data.repository.PersonRepository;
import br.com.bartie.api.v1.controllers.PersonController;
import br.com.bartie.api.v1.mapper.PersonMapper;
import br.com.bartie.api.v1.view.PersonDTO;
import br.com.bartie.app.core.ModelService;
import br.com.bartie.app.exceptions.RequiredObjectIsNullException;
import br.com.bartie.app.exceptions.ResourceNotFoundException;

@Service
public class PersonServices extends ModelService {
 
    private Logger logger;

    private PersonMapper mapper = new PersonMapper();

    @Autowired
    protected PersonRepository repository;

    public PersonServices() {
        logger = Logger.getLogger(PersonServices.class.getName());
    }

    public void log(String msg) {
        logger.info(msg);
    }

    public List<PersonDTO> findAll() {

        log("Get all persons!");

        var list = mapper.parseDTO(repository.findAll());

        list.stream().forEach(item -> addLink(item));
  
        return list;

    }

    public PersonDTO find(Long id) {
        
        Person item = repository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("No record found!"));

        log("Get one person! >> " + item.getFullName());

        return addLink(mapper.parseDTO(item));

    }

    public PersonDTO create(Person person) {

        if (person == null) throw new RequiredObjectIsNullException();

        log("Create one person! >> " + person.getFullName());

        return addLink(mapper.parseDTO(repository.save(person)));

    }

    public PersonDTO create(PersonDTO person) {

        return create(mapper.parse(person));
    }

    public PersonDTO update(PersonDTO person) {
        
        return update(mapper.parse(person));
    }

    public PersonDTO update(Person person) {
        
        if (person == null) throw new RequiredObjectIsNullException();

        log("Update one person! >> " + person.getFullName());

        return addLink(mapper.parseDTO(repository.save(person)));

    }

    public void delete(PersonDTO person) {

        Person item = mapper.parse(person);

        log("Update one person! >> " + item.getFullName());

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
            
        Link link = getLink(WebMvcLinkBuilder.methodOn(PersonController.class).find(item.getId())); 

        return item.add(link);
    }
   
}
