package br.com.bartie.apiTest.V1.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.bartie.app.exceptions.RequiredObjectIsNullException;
import br.com.bartie.api.v1.dto.BookDTO;
import br.com.bartie.api.v1.services.BookServices;
import br.com.bartie.apiTest.V1.check.BookTest;
import br.com.bartie.apiTest.V1.mock.BookMock;
import br.com.bartie.data.model.Book;
import br.com.bartie.data.repository.BookRepository;

@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
public class BookServicesTest {

    BookMock mock;

    BookTest checker = new BookTest();

    @InjectMocks
    private BookServices service;

    @Mock
    BookRepository repository;

    @BeforeEach
    public void setUp() {
        mock = new BookMock();
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void FindListBook() {

        // Arrange

        List<Book> input = mock.getList(25);

        when(repository.findAll()).thenReturn(input);

        // Act

        List<BookDTO> output = service.findAll();

        // Assert

        checker.checkList(output, 25);

    }

    @Test
    public void FindBook() {

        // Arrange

        Book input = mock.get(2L);

        when(repository.findById(input.getId())).thenReturn(Optional.of(input));

        // Act

        BookDTO output = service.find(input.getId());

        // Assert

        checker.checkService(output);

    }

    @Test
    public void CreateBook() {

        // Arrange

        Book input = mock.get(10L);

        when(repository.save(input)).thenReturn(input);

        // Act

        BookDTO output = service.create(input);

        // Assert

        checker.checkService(output);

    }

    @Test
    public void UpdateBook() {

        // Arrange

        Book input = mock.get(14L);

        when(repository.save(input)).thenReturn(input);

        // Act

        BookDTO output = service.update(input);

        // Assert

        checker.checkService(output);

    }

    @Test
    public void DeleteBook() {

        // Arrange

        Book input = mock.get(7L);

        when(repository.findById(input.getId())).thenReturn(Optional.of(input));

        // Act

        service.delete(input.getId());

    }

    @Test
    public void CreateBookIsNull() {

        // Arrange

        Book input = null;

        // Act

        Exception output = 
            assertThrows(RequiredObjectIsNullException.class, () -> 
                { service.create(input); } );

        // Assert

        checker.checkIsNullException(output);

    }

    @Test
    public void UpdatePersoIsNull() {

        // Arrange

        Book input = null;

        // Act

        Exception output = 
            assertThrows(RequiredObjectIsNullException.class, () -> 
                { service.update(input); } );

        // Assert

        checker.checkIsNullException(output);

    }

}


