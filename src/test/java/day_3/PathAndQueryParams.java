package day_3;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class PathAndQueryParams {
	
	@Test
	void testQueryAndPathParams()
	{
		
		given()
			.pathParam("myPath", "users")    // path parameter
			.queryParam("page", 2)         // Query Parameter
			.queryParam("id", 5)           // Query Parameter
		
		.when()
			.get("https://reqres.in/api/{myPath}")
		
		.then()
			.statusCode(200)
			.log().all();
		
	}

}
