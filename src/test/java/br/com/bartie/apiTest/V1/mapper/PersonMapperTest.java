package br.com.bartie.apiTest.V1.mapper;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.bartie.api.v1.mapper.PersonMapper;
import br.com.bartie.api.v1.view.PersonDTO;
import br.com.bartie.apiTest.V1.check.PersonAssert;
import br.com.bartie.apiTest.V1.mock.PersonMock;
import br.com.bartie.data.model.Person;

public class PersonMapperTest {

    PersonMock mock;
    PersonMapper mapper = new PersonMapper();

    @BeforeEach
    public void setUp() {
        mock = new PersonMock();
    }

    @Test
    public void parseEntityToVOTest() {

        // Arrange
        
        Person item = mock.get(0L);

        // Act

        PersonDTO output = mapper.parseDTO(item);

        // Assert

        PersonAssert.checkDTO(output);
    }

    @Test
    public void parseEntityListToVOListTest() {
        
        // Arrange

        List<Person> list = mock.getList();

        // Act

        List<PersonDTO> output = mapper.parseDTO(list);
        
        PersonDTO outputZero = output.get(0);
        PersonDTO outputSeven = output.get(7);
        PersonDTO outputTwelve = output.get(12);

        // Assert

        PersonAssert.checkDTO(outputZero);
        PersonAssert.checkDTO(outputSeven);
        PersonAssert.checkDTO(outputTwelve);

    }

    @Test
    public void parseVOToEntityTest() {

        // Arrange
        
        PersonDTO item = mock.getDTO(0L);

        // Act

        Person output = mapper.parse(item);

        // Assert

        PersonAssert.check(output);

    }

    @Test
    public void parserVOListToEntityListTest() {

        // Arrange

        List<PersonDTO> list = mock.getListDTO();

        // Act

        List<Person> output = mapper.parse(list);
        
        Person outputZero = output.get(0);
        Person outputSeven = output.get(7);
        Person outputTwelve = output.get(12);

        // Assert

        PersonAssert.check(outputZero);
        PersonAssert.check(outputSeven);
        PersonAssert.check(outputTwelve);
    }
}
