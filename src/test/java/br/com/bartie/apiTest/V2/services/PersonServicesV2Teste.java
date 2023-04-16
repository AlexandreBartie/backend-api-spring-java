package br.com.bartie.apiTest.V2.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.bartie.api.v2.view.PersonDTO;
import br.com.bartie.apiTest.V2.mock.PersonMock;
import br.com.bartie.app.exceptions.RequiredObjectIsNullException;
import br.com.bartie.api.v2.services.PersonServicesV2;
import br.com.bartie.data.repositories.PersonRepository;
import br.com.bartie.data.models.Person;

@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
public class PersonServicesV2Teste {

    PersonMock mock;

    @InjectMocks
    private PersonServicesV2 service;

    @Mock
    PersonRepository repository;

    @BeforeEach
    public void setUp() {
        mock = new PersonMock();
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void FindPerson() {

        // Arrange

        Person input = mock.get(2L);

        when(repository.findById(input.getId())).thenReturn(Optional.of(input));

        // Act

        PersonDTO output = service.find(input.getId());

        // Assert

        checkAsserts(input.getId(), output);

    }

    @Test
    public void CreatePerson() {

        // Arrange

        Person input = mock.get(10L);

        when(repository.save(input)).thenReturn(input);

        // Act

        PersonDTO output = service.create(input);

        // Assert

        checkAsserts(input.getId(), output);

    }

    @Test
    public void UpdatePerson() {

        // Arrange

        Person input = mock.get(14L);

        when(repository.save(input)).thenReturn(input);

        // Act

        PersonDTO output = service.update(input);

        // Assert

        checkAsserts(input.getId(), output);

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

        checkIsNullException(output);

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

        checkIsNullException(output);


    }

    private void checkAsserts(Long id, PersonDTO output)
    {

        assertNotNull(output);
        assertTrue(output.hasLinks());
        
        assertEquals(id, output.getId());
        assertEquals(String.format("First Name Test%s", id), output.getFirstName());
        assertEquals(String.format("Last Name Test%s", id), output.getLastName());
        assertEquals(String.format("Addres Test%s", id), output.getAddress());
        assertEquals("Male", output.getGender());
        assertEquals(String.format("</person/v2/%s>;rel=\"self\"", id), output.getApiLinks());

    }

    private void checkIsNullException(Exception output)
    {

        assertEquals("it is not allowed to persist a null object!", output.getMessage());    

    }
   
}


