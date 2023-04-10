package br.com.bartie.mapper;

import br.com.bartie.models.Person;
import br.com.bartie.data.PersonDTO;

import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class PersonMapper {

    public Person parseEntity(PersonDTO source) {
        Person newObject = new Person(); 
        BeanUtils.copyProperties(newObject, source);
        return newObject;
    }
    public PersonDTO parseDTO(Person source)
    {
        PersonDTO newObject = new PersonDTO(); 
        BeanUtils.copyProperties(newObject, source);
        return newObject;
    }

    public List<Person> parseListEntity(List<PersonDTO> source) {
		List<Person> list = new ArrayList<Person>();
		for (PersonDTO item : source) {
			list.add(parseEntity(item));
		}
		return list;
	}

    public List<PersonDTO> parseListDTO(List<Person> source) {
		List<PersonDTO> list = new ArrayList<PersonDTO>();
		for (Person item : source) {
			list.add(parseDTO(item));
		}
		return list;
	}

}
