package br.com.bartie.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bartie.data.models.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {}
