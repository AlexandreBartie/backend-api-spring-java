package br.com.bartie.apiTest.V1.mock;

import br.com.bartie.app.core.ModelMock;

import br.com.bartie.api.v1.view.PersonDTO;
import br.com.bartie.apiTest.V1.data.PersonData;
import br.com.bartie.data.model.Person;

public class PersonMock extends ModelMock<Person, PersonDTO> {

    public PersonMock()
    {
        super("person");
    }

    public Person mockEntity(Long number) {
        Person person = new Person();
        person.setId(number);
        person.setFirstName(PersonData.getFirstName(number));
        person.setLastName(PersonData.getLastName(number));
        person.setAddress(PersonData.getAddress(number));
        person.setGender(PersonData.getGender(number));
        return person;
    }

    public PersonDTO mockDTO(Long number) {
        PersonDTO person = new PersonDTO();
        person.setId(number);
        person.setFirstName(PersonData.getFirstName(number));
        person.setLastName(PersonData.getLastName(number));
        person.setAddress(PersonData.getAddress(number));
        person.setGender(PersonData.getGender(number));
        return person;
    }

}
