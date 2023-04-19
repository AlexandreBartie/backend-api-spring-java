package br.com.bartie.app.core;

import java.util.ArrayList;
import java.util.List;

public abstract class ModelMock<T, DTO> {
      
        public T get(Long id) {
            return mockEntity(id);
        }
    
        public DTO getDTO(Long id) {
            return mockDTO(id);
        }
    
        public List<T> getList() {
            return getList(15);
        }
    
        public List<T> getList(int size) {
            List<T> persons = new ArrayList<T>();
            for (Long id = 1L; id <= size; id++) {
                persons.add(mockEntity(id));
            }
            return persons;
        }
    
        public List<DTO> getListDTO() {
            return getListDTO(15);
        }
    
        public List<DTO> getListDTO(int size) {
            List<DTO> persons = new ArrayList<>();
            for (Long id = 1L; id <= size; id++) {
                persons.add(mockDTO(id));
            }
            return persons;
        }
    
        public abstract T mockEntity(Long number);
         {
            // Person person = new Person();
            // person.setId(number.longValue());
            // person.setFirstName("First Name Test" + number);
            // person.setLastName("Last Name Test" + number);
            // person.setAddress("Address Test" + number);
            // person.setGender(randomGender(number));
            // return person;
        }
    
        public abstract DTO mockDTO(Long number);
            // PersonDTO person = new PersonDTO();
            // person.setId(number.longValue());
            // person.setFirstName("First Name Test" + number);
            // person.setLastName("Last Name Test" + number);
            // person.setAddress("Addres Test" + number);
            // person.setGender(randomGender(number));
            // return person;
        
    
        // public String randomGender(Long id)
        //     { return ((id % 2)==0) ? "Male" : "Female"; }
    
    }
