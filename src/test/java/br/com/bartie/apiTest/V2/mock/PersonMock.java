package br.com.bartie.apiTest.V2.mock;

import java.util.ArrayList;
import java.util.List;

import br.com.bartie.data.models.Person;
import br.com.bartie.api.v2.view.PersonDTO;

public class PersonMock {

    public Person get(Long id) {
        return mockEntity(id);
    }

    public PersonDTO getDTO(Long id) {
        return mockDTO(id);
    }

    public List<Person> getList() {
        return getList(15);
    }

    public List<Person> getList(int size) {
        List<Person> persons = new ArrayList<Person>();
        for (Long id = 0L; id < size; id++) {
            persons.add(mockEntity(id));
        }
        return persons;
    }

    public List<PersonDTO> getListDTO() {
        List<PersonDTO> persons = new ArrayList<>();
        for (Long id = 1L; id <= 14; id++) {
            persons.add(mockDTO(id));
        }
        return persons;
    }

    public Person mockEntity(Long number) {
        Person person = new Person();
        person.setId(number.longValue());
        person.setFirstName("First Name Test" + number);
        person.setLastName("Last Name Test" + number);
        person.setAddress("Addres Test" + number);
        person.setGender(randomGender(number));
        return person;
    }

    public PersonDTO mockDTO(Long number) {
        PersonDTO person = new PersonDTO();
        person.setId(number.longValue());
        person.setFirstName("First Name Test" + number);
        person.setLastName("Last Name Test" + number);
        person.setAddress("Addres Test" + number);
        person.setGender(randomGender(number));
        return person;
    }

    public String randomGender(Long id)
        { return ((id % 2)==0) ? "Male" : "Female"; }

}
