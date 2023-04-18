package br.com.bartie.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bartie.data.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {}
