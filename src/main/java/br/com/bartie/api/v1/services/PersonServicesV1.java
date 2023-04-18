package br.com.bartie.api.v1.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bartie.api.v1.mapper.PersonMapper;
import br.com.bartie.api.v1.view.PersonDTO;
import br.com.bartie.app.exceptions.ResourceNotFoundException;
import br.com.bartie.data.model.Person;
import br.com.bartie.data.repository.PersonRepository;
@Service
public class PersonServicesV1 {

    private Logger logger = Logger.getLogger(PersonServicesV1.class.getName());

    @Autowired   
    private PersonRepository repository;
    
    public List<PersonDTO> getAll() {

        logger.info("Get all persons!");

        return PersonMapper.parseDTO(repository.findAll());

    }

    public PersonDTO get(Long id) {
        
        Person item = repository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("No record found!"));

        logger.info("Get one person! >> " + item.getFirstName());

        return PersonMapper.parseDTO(item);

    }

    public PersonDTO create(PersonDTO person) {

        Person item = PersonMapper.parse(person);

        logger.info("Create one person! >> " + item.getFirstName());

        return PersonMapper.parseDTO(repository.save(item));

    }

    public PersonDTO update(PersonDTO person) {

        Person item = PersonMapper.parse(person);

        logger.info("Update one person! >> " + item.getFirstName());

        return PersonMapper.parseDTO(repository.save(item));

    }

    public void delete(PersonDTO person) {

        Person item = PersonMapper.parse(person);

        logger.info("Update one person! >> " + item.getFirstName());

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
