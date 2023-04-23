package br.com.bartie.apiTest.V1.check;

import static org.junit.jupiter.api.Assertions.*;

import br.com.bartie.apiTest.core.ModelUnitTest;

import br.com.bartie.apiTest.V1.data.PersonData;
import br.com.bartie.apiTest.V1.mock.PersonMock;

import br.com.bartie.data.model.Person;
import br.com.bartie.api.v1.view.PersonDTO;

public class PersonTest extends ModelUnitTest<Person, PersonDTO> {
 
    public PersonTest()
    { super(new PersonMock());}

    public void check(Person person)
    {

        Long id = person.getId();

        assertNotNull(person);
        
        assertEquals(id, person.getId());
        assertEquals(PersonData.getFirstName(id), person.getFirstName());
        assertEquals(PersonData.getLastName(id), person.getLastName());
        assertEquals(PersonData.getAddress(id), person.getAddress());
        assertEquals(PersonData.getGender(id), person.getGender());

    }

    public void checkDTO(PersonDTO person)
    {

        Long id = person.getId();
     
        assertEquals(id, person.getId());
        assertEquals(PersonData.getFirstName(id), person.getFirstName());
        assertEquals(PersonData.getLastName(id), person.getLastName());
        assertEquals(PersonData.getAddress(id), person.getAddress());
        assertEquals(PersonData.getGender(id), person.getGender());

    }


}
