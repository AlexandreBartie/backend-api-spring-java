package br.com.bartie.api.v1.mapper;

import br.com.bartie.api.v1.view.PersonDTO;
import br.com.bartie.app.core.Mapper;
import br.com.bartie.data.models.Person;

import java.util.List;

public class PersonMapper {

    public static Person parse(PersonDTO source) {
        return Mapper.parse(source, Person.class);
    }

    public static List<Person> parse(List<PersonDTO> source) {
        return Mapper.parse(source, Person.class);
	}

    public static PersonDTO parseDTO(Person source)
    {
        return Mapper.parse(source, PersonDTO.class);
    }

    public static List<PersonDTO> parseDTO(List<Person> source) {
        return Mapper.parse(source, PersonDTO.class);
	}

}
