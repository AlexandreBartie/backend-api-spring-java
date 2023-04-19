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

import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.bartie.api.v1.services.PersonServices;
import br.com.bartie.api.v1.view.PersonDTO;
import br.com.bartie.apiTest.V1.mock.PersonMock;
import br.com.bartie.app.exceptions.RequiredObjectIsNullException;
import br.com.bartie.data.model.Person;
import br.com.bartie.data.repository.PersonRepository;

@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
public class PersonServicesTeste {

    PersonMock mock;

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

        checkList(output, 25);

    }

    @Test
    public void FindPerson() {

        // Arrange

        Person input = mock.get(2L);

        when(repository.findById(input.getId())).thenReturn(Optional.of(input));

        // Act

        PersonDTO output = service.find(input.getId());

        // Assert

        checkPerson(output, input.getId());

    }

    @Test
    public void CreatePerson() {

        // Arrange

        Person input = mock.get(10L);

        when(repository.save(input)).thenReturn(input);

        // Act

        PersonDTO output = service.create(input);

        // Assert

        checkPerson(output, input.getId());

    }

    @Test
    public void UpdatePerson() {

        // Arrange

        Person input = mock.get(14L);

        when(repository.save(input)).thenReturn(input);

        // Act

        PersonDTO output = service.update(input);

        // Assert

        checkPerson(output, input.getId());

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

    private void checkPerson(PersonDTO person)
    { checkPerson(person, person.getId()); }

    private void checkPerson(PersonDTO person, Long id)
    {

        assertNotNull(person);
        assertTrue(person.hasLinks(),"Link HATEOAS not found!");
        
        assertEquals(id, person.getId());
        assertEquals(String.format("First Name Test%s", id), person.getFirstName());
        assertEquals(String.format("Last Name Test%s", id), person.getLastName());
        assertEquals(String.format("Address Test%s", id), person.getAddress());
        assertEquals(mock.randomGender(id), person.getGender());
        assertEquals(String.format("</person/v2/%s>;rel=\"self\"", id), person.getApiLinks());

    }

    private void checkList(List<PersonDTO> list, int size)
    {

        assertNotNull(list);
        assertEquals(size, list.size());

        list.stream().forEach(item -> checkPerson(item));

    }

    private void checkIsNullException(Exception output)
    {

        assertEquals("it is not allowed to persist a null object!", output.getMessage());    

    }
   
}


