package day_3;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Iterator;
import java.util.Map;

public class CookiesDemo {
	
	//@Test (priority = 1)
	void testCookies()
	{
		given()
		
		.when()
			.get("https://www.google.com/")
			
		
		.then()
			.cookie("AEC", "AVYB7cpy2KQYR9LFVucoJHbCAbF0XkhZydywf0FZ54asDNXjylXASYq5P1k")
			.log().all();
	}
	
	
	@Test (priority =2)
	void getCookiesInfo()
	{
		Response res = given()
		
		.when()
			.get("https://www.google.com/");
		
		
		// get Single Cookie Info
//		String cookie_value = res.getCookie("AEC");
//		System.out.println("Value of Cookie is====>"+cookie_value);
		
		// get all Cookies Info
		Map<String, String> cookies_value = res.getCookies();
		System.out.println(cookies_value.keySet());
		
		for(String k:cookies_value.keySet())
		{
			String cookie_value = res.getCookie(k);
			System.out.println(k+"      "+cookie_value);
		}
		
		// INSTEAD OF WRITING THIS LOGIC WE CAN SIMPLY WRITE .log().cookies() IN .then() METHOD
		
		
	}

}
