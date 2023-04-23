package br.com.bartie.apiTest.V1.mapper;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.bartie.api.v1.mapper.PersonMapper;
import br.com.bartie.api.v1.view.PersonDTO;
import br.com.bartie.apiTest.V1.check.PersonTest;
import br.com.bartie.apiTest.V1.mock.PersonMock;
import br.com.bartie.data.model.Person;

public class PersonMapperTest {

    PersonMock mock;
    PersonMapper mapper = new PersonMapper();
    PersonTest checker = new PersonTest();

    @BeforeEach
    public void setUp() {
        mock = new PersonMock();
    }

    @Test
    public void parseEntityToDTO() {

        // Arrange
        
        Person item = mock.get(0L);

        // Act

        PersonDTO output = mapper.parseDTO(item);

        // Assert

        checker.checkDTO(output);
    }

    @Test
    public void parseEntityToDTOList() {
        
        // Arrange

        List<Person> list = mock.getList();

        // Act

        List<PersonDTO> output = mapper.parseDTO(list);
        
        PersonDTO outputZero = output.get(0);
        PersonDTO outputSeven = output.get(7);
        PersonDTO outputTwelve = output.get(12);

        // Assert

        checker.checkDTO(outputZero);
        checker.checkDTO(outputSeven);
        checker.checkDTO(outputTwelve);

    }

    @Test
    public void parseDTOtoEntity() {

        // Arrange
        
        PersonDTO item = mock.getDTO(0L);

        // Act

        Person output = mapper.parse(item);

        // Assert

        checker.check(output);

    }

    @Test
    public void parseDTOtoEntityList() {

        // Arrange

        List<PersonDTO> list = mock.getListDTO();

        // Act

        List<Person> output = mapper.parse(list);
        
        Person outputZero = output.get(0);
        Person outputSeven = output.get(7);
        Person outputTwelve = output.get(12);

        // Assert

        checker.check(outputZero);
        checker.check(outputSeven);
        checker.check(outputTwelve);
    }
}
