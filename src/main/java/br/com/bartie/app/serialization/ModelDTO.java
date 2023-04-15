package br.com.bartie.app.serialization;

import java.io.Serializable;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

public class ModelDTO<DTO extends RepresentationModel<? extends DTO>> extends RepresentationModel<DTO> implements Serializable {    

    public Link getLink(Object method) {

        return WebMvcLinkBuilder.linkTo(method).withSelfRel();
    }

}
