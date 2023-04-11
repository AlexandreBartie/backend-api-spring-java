package br.com.bartie.mapper;

import br.com.bartie.models.Person;
import br.com.bartie.core.Mapper;
import br.com.bartie.data.PersonDTO;

import java.util.List;

public class PersonMapper {

    private Mapper mapper = new Mapper();

    public Person parse(PersonDTO source) {
        return mapper.parse(source, Person.class);
    }
    public PersonDTO parseDTO(Person source)
    {
        return mapper.parse(source, PersonDTO.class);
    }

    public List<Person> parse(List<PersonDTO> source) {
        return mapper.parse(source, Person.class);
	}

    public List<PersonDTO> parseDTO(List<Person> source) {
        return mapper.parse(source, PersonDTO.class);
	}

}
