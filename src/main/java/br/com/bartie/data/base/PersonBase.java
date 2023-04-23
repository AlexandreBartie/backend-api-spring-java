package br.com.bartie.data.base;

import br.com.bartie.app.core.ModelBase;
import br.com.bartie.data.model.Person;
import br.com.bartie.data.repository.PersonRepository;

public class PersonBase extends ModelBase<Person, PersonRepository> {

    public PersonBase() {
        super(PersonRepository.class);
    }
    
}
