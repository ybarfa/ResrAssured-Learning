package day_4;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class ParsingJSONResponseData {
	
	@Test
	void testJsonResponse()
	{
		
		// Approach_1
		
		given()
			.contentType("ContentType.Json")
		
		.when()
			.get("http://localhost:3000/store")
		
		.then()
			.statusCode(200)
			.header("Content-Type", "application/json")
			.body("books[3].title", equalTo("To Kill a Mockingbird")); 
	}

}
