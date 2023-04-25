package br.com.bartie.apiTest.unitTest.V1.services;

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
import br.com.bartie.api.v1.dto.PersonDTO;
import br.com.bartie.api.v1.services.PersonServices;
import br.com.bartie.apiTest.unitTest.V1.check.PersonTest;
import br.com.bartie.apiTest.unitTest.V1.mock.PersonMock;
import br.com.bartie.data.model.Person;
import br.com.bartie.data.repository.PersonRepository;

@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
public class PersonServicesTest {

    PersonMock mock;

    PersonTest checker = new PersonTest();

    @InjectMocks
    private PersonServices service;

    @Mock
    PersonRepository repository;

    @BeforeEach
    public void setUp() {
        mock = new PersonMock();
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void FindListPerson() {

        // Arrange

        List<Person> input = mock.getList(25);

        when(repository.findAll()).thenReturn(input);

        // Act

        List<PersonDTO> output = service.findAll();

        // Assert

        checker.checkList(output, 25);

    }

    @Test
    public void FindPerson() {

        // Arrange

        Person input = mock.get(2L);

        when(repository.findById(input.getId())).thenReturn(Optional.of(input));

        // Act

        PersonDTO output = service.find(input.getId());

        // Assert

        checker.checkService(output);

    }

    @Test
    public void CreatePerson() {

        // Arrange

        Person input = mock.get(10L);

        when(repository.save(input)).thenReturn(input);

        // Act

        PersonDTO output = service.create(input);

        // Assert

        checker.checkService(output);

    }

    @Test
    public void UpdatePerson() {

        // Arrange

        Person input = mock.get(14L);

        when(repository.save(input)).thenReturn(input);

        // Act

        PersonDTO output = service.update(input);

        // Assert

        checker.checkService(output);

    }

    @Test
    public void DeletePerson() {

        // Arrange

        Person input = mock.get(7L);

        when(repository.findById(input.getId())).thenReturn(Optional.of(input));

        // Act

        service.delete(input.getId());

    }

    @Test
    public void CreatePersonIsNull() {

        // Arrange

        Person input = null;

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

        Person input = null;

        // Act

        Exception output = 
            assertThrows(RequiredObjectIsNullException.class, () -> 
                { service.update(input); } );

        // Assert

        checker.checkIsNullException(output);

    }

}


