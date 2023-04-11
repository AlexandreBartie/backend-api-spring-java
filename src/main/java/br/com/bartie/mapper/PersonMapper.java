package br.com.bartie.mapper;

import br.com.bartie.models.Person;
import br.com.bartie.core.Mapper;
import br.com.bartie.data.PersonDTO;

import java.util.List;

public class PersonMapper {

    public static Person parse(PersonDTO source) {
        return Mapper.parse(source, Person.class);
    }
    public static PersonDTO parseDTO(Person source)
    {
        return Mapper.parse(source, PersonDTO.class);
    }

    public static List<Person> parse(List<PersonDTO> source) {
        return Mapper.parse(source, Person.class);
	}

    public static List<PersonDTO> parseDTO(List<Person> source) {
        return Mapper.parse(source, PersonDTO.class);
	}

}
