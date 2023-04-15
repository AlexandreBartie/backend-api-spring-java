package br.com.bartie.api.v2.controllers;

import br.com.bartie.api.v2.services.PersonServicesV2;
import br.com.bartie.api.v2.view.PersonDTO;

import br.com.bartie.app.serialization.MediaType;
import br.com.bartie.app.serialization.RestFullApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/person/v2")
public class PersonControllerV2 extends RestFullApi {

    @Autowired
    private PersonServicesV2 service;

    @GetMapping(value = "/{id}", 
        produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML })
    public PersonDTO get(@PathVariable(value = "id") Long id) {
        return addLink(service.get(id));
    }

    @PostMapping(
        consumes = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML }, 
        produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML })
    public PersonDTO add(@RequestBody PersonDTO person) {
        return addLink(service.create(person));
    }

    @PutMapping(
        consumes = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML }, 
        produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML })
    public PersonDTO save(@RequestBody PersonDTO person) {
        return addLink(service.update(person));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(
        produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML })
    public List<PersonDTO> getAll() {
        var list =  service.getAll();

        list.stream().forEach(item -> addLink(item));
   
        return list;
    }

    private PersonDTO addLink(PersonDTO item) { 
        Link link = getLink(WebMvcLinkBuilder.methodOn(PersonControllerV2.class).get(item.getId())); 

        return item.add(link);
    }

}


