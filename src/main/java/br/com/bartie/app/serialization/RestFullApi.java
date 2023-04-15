package br.com.bartie.app.serialization;

import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.hateoas.Link;

public class RestFullApi {
    
    public Link getLink(Object method) {

        return WebMvcLinkBuilder.linkTo(method).withSelfRel();
    }

}