package br.com.bartie.apiTest.integrationTest.controller;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.bartie.api.v1.view.PersonView;
import br.com.bartie.apiTest.core.ModelIntegrationTest;
import br.com.bartie.config.TestConfig;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@TestMethodOrder(OrderAnnotation.class)
public class PersonControllerTest extends ModelIntegrationTest{

	private static RequestSpecification action;

	private static ObjectMapper mapper;

	private static PersonView person;

	@BeforeAll
    public static void setup() {
        mapper = new ObjectMapper() ;
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

		person = new PersonView();
    }

	@Test
	@Order(1)
	public void CreatePerson() throws JsonMappingException, JsonProcessingException {
		mockPerson();

		action = new RequestSpecBuilder()
			.addHeader(TestConfig.HEADER_PARAM_ORIGIN, TestConfig.ORIGIN_VALID)
			.setBasePath("/person/v1")
			.setPort(TestConfig.SERVER_PORT)
			.addFilter(new RequestLoggingFilter(LogDetail.ALL))
			.addFilter(new ResponseLoggingFilter(LogDetail.ALL))
			.build();

		var content =
			given().spec(action)
				.contentType(TestConfig.CONTENT_TYPE_JSON)
				.body(person)
				.when()
					.post()
				.then()
					.statusCode(200)
				.extract()
					.body()
						.asString();

		PersonView create = mapper.readValue(content, PersonView.class);

		assertNotNull(create);

		assertTrue(create.getId() > 0);
		assertEquals("David", create.getFirstName());
		assertEquals("Silva", create.getLastName());
		assertEquals("Nova Cintra, Rio de Janeiro, RJ, Brazil", create.getAddress());
		assertNotNull(create.getBirthday());
		assertEquals("Male", create.getGender());


	}

	private void mockPerson() {
		person.setFirstName("David");
		person.setLastName("Silva");
		person.setAddress("Nova Cintra, Rio de Janeiro, RJ, Brazil");
		person.setGender("Male");
	}

}