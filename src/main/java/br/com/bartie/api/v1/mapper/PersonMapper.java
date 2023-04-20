package br.com.bartie.api.v1.mapper;

import java.util.List;

import br.com.bartie.api.v1.view.PersonDTO;
import br.com.bartie.app.serialization.DataMapper;
import br.com.bartie.data.model.Person;

// import java.util.List;

public class PersonMapper { // extends ModelMapper<Person, PersonDTO> {}

    private DataMapper<Person, PersonDTO> mapper = new DataMapper<Person, PersonDTO> ();

    public Person parse(PersonDTO source) {
        return mapper.parse(source, Person.class);
    }

    public List<Person> parse(List<PersonDTO> source) {
        return mapper.parse(source, Person.class);
	}

    public PersonDTO parseDTO(Person source)
    {
        return mapper.parseDTO(source, PersonDTO.class);
    }

    public List<PersonDTO> parseDTO(List<Person> source) {
        return mapper.parseDTO(source, PersonDTO.class);
	}

}

