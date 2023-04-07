package br.com.bartie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bartie.models.Person;

public interface PersonDTO extends JpaRepository<Person, Long> {}
