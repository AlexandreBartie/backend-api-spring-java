package br.com.bartie.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.bartie.data.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {}



