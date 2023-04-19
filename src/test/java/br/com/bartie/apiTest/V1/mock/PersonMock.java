package br.com.bartie.apiTest.V1.mock;

import br.com.bartie.app.core.ModelMock;

import br.com.bartie.api.v1.view.PersonDTO;
import br.com.bartie.data.model.Person;

public class PersonMock extends ModelMock<Person, PersonDTO> {

    public Person mockEntity(Long number) {
        Person person = new Person();
        person.setId(number.longValue());
        person.setFirstName("FirstName#" + number);
        person.setLastName("LastName#" + number);
        person.setAddress("Address#" + number);
        person.setGender(randomGender(number));
        return person;
    }

    public PersonDTO mockDTO(Long number) {
        PersonDTO person = new PersonDTO();
        person.setId(number.longValue());
        person.setFirstName("FirstName#" + number);
        person.setLastName("LastName#" + number);
        person.setAddress("Address#" + number);
        person.setGender(randomGender(number));
        return person;
    }

    public String randomGender(Long id)
        { return ((id % 2)==0) ? "Male" : "Female"; }

}
