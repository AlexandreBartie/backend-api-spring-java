package br.com.bartie.app.serialization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;

import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

public class ModelServices<Repo> {
    
    @Autowired   
    protected Repo repository;

    public Link getLink(Object method) {

        return WebMvcLinkBuilder.linkTo(method).withSelfRel();
    }

}