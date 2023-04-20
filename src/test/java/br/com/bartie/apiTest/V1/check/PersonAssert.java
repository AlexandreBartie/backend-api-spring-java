package br.com.bartie.apiTest.V1.check;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import br.com.bartie.data.model.Person;
import br.com.bartie.api.v1.view.PersonDTO;
import br.com.bartie.apiTest.V1.data.PersonData;


public class PersonAssert {

    public static void check(Person person)
    {

        Long id = person.getId();

        assertNotNull(person);
        
        assertEquals(id, person.getId());
        assertEquals(PersonData.getFirstName(id), person.getFirstName());
        assertEquals(PersonData.getLastName(id), person.getLastName());
        assertEquals(PersonData.getAddress(id), person.getAddress());
        assertEquals(PersonData.getGender(id), person.getGender());

    }

    public static void checkDTO(PersonDTO person)
    {

        Long id = person.getId();
     
        assertEquals(id, person.getId());
        assertEquals(PersonData.getFirstName(id), person.getFirstName());
        assertEquals(PersonData.getLastName(id), person.getLastName());
        assertEquals(PersonData.getAddress(id), person.getAddress());
        assertEquals(PersonData.getGender(id), person.getGender());

    }

    public static void checkService(PersonDTO person)
    {

        Long id = person.getId();

        checkDTO(person);

        assertTrue(person.hasLinks(),"Link HATEOAS not found!");
        assertEquals(String.format("</person/v1/%s>;rel=\"self\"", id), person.getApiLinks());

    }

    public static void checkList(List<PersonDTO> list, int size)    
    {

        assertNotNull(list);
        assertEquals(size, list.size());

        list.stream().forEach(item -> checkService(item));

    }

    public static void checkIsNullException(Exception output)
    {
        assertEquals("it is not allowed to persist a null object!", output.getMessage());    
    }

   
}
