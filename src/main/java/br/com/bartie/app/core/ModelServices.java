package br.com.bartie.app.core;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;

import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

public class ModelServices<Repo> {

    private Logger logger;

    @Autowired
    protected Repo repository;

    public ModelServices(String name) {
        logger = Logger.getLogger(name);
    }

    public void log(String msg) {
        logger.info(msg);
    }

    public Link getLink(Object method) {

        return WebMvcLinkBuilder.linkTo(method).withSelfRel();
    }

}