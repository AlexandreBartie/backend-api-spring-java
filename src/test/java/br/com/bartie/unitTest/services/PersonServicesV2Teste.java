package br.com.bartie.unitTest.services;

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

import br.com.bartie.api.v2.services.PersonServicesV2;
import br.com.bartie.data.models.Person;
import br.com.bartie.data.repositories.PersonRepository;
import br.com.bartie.unitTest.PersonMock;

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
    public void get() {

        Long id = 0L;

        Person input = mock.get(id);

        when(repository.findById(id)).thenReturn(Optional.of(input));

        var output = service.get(id);

        assertNotNull(output);
        assertTrue(!output.getLinks().isEmpty());

        assertEquals(Long.valueOf(0L), output.getId());
        assertEquals("First Name Test0", output.getFirstName());
        assertEquals("Last Name Test0", output.getLastName());
        assertEquals("Addres Test0", output.getAddress());
        assertEquals("Male", output.getGender());

        String link_expect = "</person/v2/0>;rel=\"self\"";

        String link_result = output.getLinks().toString();

        assertEquals(link_expect, link_result);

    }
    
}


