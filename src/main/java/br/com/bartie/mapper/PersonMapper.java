package br.com.bartie.mapper;

import br.com.bartie.models.Person;
import br.com.bartie.core.Mapper;
import br.com.bartie.data.PersonDTO;

import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class PersonMapper {

    private Mapper mapper = new Mapper();

    public Person parseEntity(PersonDTO source) {
        return mapper.parse(source, Person.class);
    }
    public PersonDTO parseDTO(Person source)
    {
        return mapper.parse(source, PersonDTO.class);
    }

    public List<Person> parseListEntity(List<PersonDTO> source) {
        return mapper.parse(source, Person.class);
        // List<Person> list = new ArrayList<Person>();
		// for (PersonDTO item : source) {
		// 	list.add(parseEntity(item));
		// }
		// return list;
	}

    public List<PersonDTO> parseListDTO(List<Person> source) {
        return mapper.parse(source, PersonDTO.class);
        // List<PersonDTO> list = new ArrayList<PersonDTO>();
		// for (Person item : source) {
		// 	list.add(parseDTO(item));
		// }
		// return list;
	}

}
