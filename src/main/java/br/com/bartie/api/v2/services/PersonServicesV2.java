package br.com.bartie.api.v2.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bartie.data.repositories.PersonRepository;
import br.com.bartie.api.v2.mapper.PersonMapper;
import br.com.bartie.api.v2.view.PersonDTO;
import br.com.bartie.data.models.Person;

import br.com.bartie.app.exceptions.ResourceNotFoundException;

@Service
public class PersonServicesV2 {

    private Logger logger = Logger.getLogger(PersonServicesV2.class.getName());

    @Autowired   
    private PersonRepository repository;
    
    public List<PersonDTO> getAll() {

        logger.info("Get all persons!");

        return PersonMapper.parseDTO(repository.findAll());

    }

    public PersonDTO get(Long id) {
        
        Person item = repository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("No record found!"));

        logger.info("Get one person! >> " + item.getFullName());

        return PersonMapper.parseDTO(item);

    }

    public PersonDTO create(PersonDTO person) {

        Person item = PersonMapper.parse(person);

        logger.info("Create one person! >> " + item.getFullName());

        return PersonMapper.parseDTO(repository.save(item));

    }

    public PersonDTO update(PersonDTO person) {

        Person item = PersonMapper.parse(person);

        logger.info("Update one person! >> " + item.getFullName());

        return PersonMapper.parseDTO(repository.save(item));

    }

    public void delete(PersonDTO person) {

        Person item = PersonMapper.parse(person);

        logger.info("Update one person! >> " + item.getFullName());

        repository.delete(item);

    }

    public void delete(Long id) {

        PersonDTO item = get(id);

        if (item != null)
        {
            delete(item);
        }

    }
    
}
