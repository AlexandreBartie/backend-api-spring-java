package br.com.bartie.apiTest.integrationTest.controller;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
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
public class PersonControllerTest extends PersonControllerTestExtension{

	@BeforeAll
    public static void setup() {
        setupAll();
    }

	@Test
	@Order(1)
	public void CreatePerson() throws JsonMappingException, JsonProcessingException {

		mockPerson();

		input = defineRequest(TestConfig.ORIGIN_VALID);

		output = actionRequestByBody(200);

		checkRequest(true);

	}

	@Test
	@Order(2)
	public void FindPerson() throws JsonMappingException, JsonProcessingException {

		mockPersonId(15L);

		input = defineRequest(TestConfig.ORIGIN_VALID);

		output = actionRequestByParam("get", 200, person.getId());

		checkRequest();

	}

	@Test
	@Order(3)
	public void UpdatePerson() throws JsonMappingException, JsonProcessingException {

		mockPersonChanged(15L);

		input = defineRequest(TestConfig.ORIGIN_VALID);

		output = actionRequestByParam("put", 200, person.getId());

		checkRequest();

	}

	@Test
	@Order(4)
	public void CreatePerson_FailByInvalidOrigin() throws JsonMappingException, JsonProcessingException {

		mockPerson();

		input = defineRequest(TestConfig.ORIGIN_INVALID);

		output = actionRequestByBody(403);

		checkRequestFail();

	}

	@Test
	@Order(5)
	public void FindPerson_FailByInvalidOrigin() throws JsonMappingException, JsonProcessingException {

		mockPerson();

		input = defineRequest(TestConfig.ORIGIN_INVALID);

		output = actionRequestByBody(403);

		checkRequestFail();

	}


}

class PersonControllerTestExtension extends ModelIntegrationTest {

	protected static RequestSpecification input;

	protected static ObjectMapper mapper;

	protected static PersonView person;

	protected static String output;

    protected static void setupAll() {
        mapper = new ObjectMapper() ;
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

		person = new PersonView();
    }

	protected RequestSpecification defineRequest(String origin) {

		return new RequestSpecBuilder()
		.addHeader(TestConfig.HEADER_PARAM_ORIGIN, origin)
		.setBasePath("/person/v1")
		.setPort(TestConfig.SERVER_PORT)
		.addFilter(new RequestLoggingFilter(LogDetail.ALL))
		.addFilter(new ResponseLoggingFilter(LogDetail.ALL))
		.build();

	}

	protected String actionRequestByBody(Integer status) {

		var resp = given().spec(input)
			.contentType(TestConfig.CONTENT_TYPE_JSON)
			.body(person)
			.when()
				.request("post")
			.then()
				.statusCode(status)
			.extract()
				.body()
					.asString();


	return resp;

	}

	protected String actionRequestByParam(String action, Integer status, Long id) {

		var resp = given().spec(input)
			.contentType(TestConfig.CONTENT_TYPE_JSON)
			.pathParam("id", id)
			.when()
				.request(action, "{id}")	
			.then()
				.statusCode(status)
			.extract()
				.body()
					.asString();


	return resp;

	}


	protected void checkRequest()  throws JsonMappingException, JsonProcessingException  {
		checkRequest(false);
	}

	protected void checkRequest(Boolean add) throws JsonMappingException, JsonProcessingException {

		PersonView create = mapper.readValue(output, PersonView.class);

		assertNotNull(create);
	
		if (add)
			assertTrue(create.getId() > 0);
		else
			assertEquals(person.getId(), create.getId());

		assertEquals(person.getFirstName(), create.getFirstName());
		assertEquals(person.getLastName(), create.getLastName());
		assertEquals(person.getAddress(), create.getAddress());
		assertEquals(person.getGender(), create.getGender());

	}

	protected void checkRequestFail() throws JsonMappingException, JsonProcessingException {

		assertNotNull(output);
		assertEquals("Invalid CORS request", output);

	}


	protected void mockPerson() {
		person.setFirstName("David");
		person.setLastName("Silva");
		person.setAddress("Nova Cintra, Rio de Janeiro, RJ, Brazil");
		person.setGender("Male");
	}

	protected void mockPersonId(Long id) {
		person.setId(id);
		person.setFirstName("Edwin");
		person.setLastName("Mitchell");
		person.setAddress("Sarah Courts");
		person.setGender("Male");
	}

	protected void mockPersonChanged(Long id) {

		person.setId(id);
		person.setFirstName("FirstNameChanged");
		person.setLastName("LastNameChanged");
		person.setAddress("AddressChanged");
		person.setGender("Female");
	}

}