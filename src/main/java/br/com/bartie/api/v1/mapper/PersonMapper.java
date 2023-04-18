package br.com.bartie.api.v1.mapper;

import br.com.bartie.api.v1.view.PersonDTO;
import br.com.bartie.app.serialization.DataMapper;
import br.com.bartie.data.model.Person;

import java.util.List;

public class PersonMapper {

    public static Person parse(PersonDTO source) {
        return DataMapper.parse(source, Person.class);
    }

    public static List<Person> parse(List<PersonDTO> source) {
        return DataMapper.parse(source, Person.class);
	}

    public static PersonDTO parseDTO(Person source)
    {
        return DataMapper.parse(source, PersonDTO.class);
    }

    public static List<PersonDTO> parseDTO(List<Person> source) {
        return DataMapper.parse(source, PersonDTO.class);
	}

}
