package day_2;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

/*
Different ways to create POST request body
1) Post request body using HashMap
2) Post request body creation using Org.json library
3) Post request body creation using POJO class
4) Post request using external json file data
*/


public class waysToCreatePostRequestBody {
	
	String id;
	
	//1) Post request body using HashMap
	
	//@Test (priority = 1)
	void testPostUsingHashMap()
	{
		HashMap data = new HashMap();
		
		data.put("name", "aman");
		data.put("location", "indore");
		data.put("phone", "123456789");
		
		String courseArr[] = {"Python", "C++"};
		data.put("courses", courseArr);
		
		
		id = given()
			.contentType("application/json")
			.body(data)
		
		.when()
			.post("http://localhost:3000/students")
			.jsonPath().getString("id");
		System.out.println(id);
		
		//.then()
			//.statusCode(201)
			//.body("name", equalTo("yash"))
			//.body("location", equalTo("india"))
			//.body("phone", equalTo("123456"))
			//.body("courses[0]", equalTo("C"))
			//.body("courses[1]", equalTo("C++"))
			//.header("Content-Type", "application/json")
			//.log().all();
		
	}
	
	
	//2) Post request body creation using Org.json library
	
		//@Test (priority = 1)
		void testPostUsingJsonLibrary()
		{
			JSONObject data = new JSONObject();
			data.put("name", "Yash");
			data.put("location", "Bengalore");
			data.put("phone", "27473886");
			
			String coursesArr[] = {"C", "C++"};
			data.put("Courses", coursesArr);
			
			
			id = given()
				.contentType("application/json")
				.body(data)
			
			.when()
				.post("http://localhost:3000/students")
				.jsonPath().getString("id");
			System.out.println(id);
			
			//.then()
				//.statusCode(201)
				//.body("name", equalTo("yash"))
				//.body("location", equalTo("india"))
				//.body("phone", equalTo("123456"))
				//.body("courses[0]", equalTo("C"))
				//.body("courses[1]", equalTo("C++"))
				//.header("Content-Type", "application/json")
				//.log().all();
			
		}
		
		//3) Post request body creation using POJO class
		
			//@Test (priority = 1)
			void testPostUsingPOJOClass()
			{
				
				Pojo_PostRequest data = new Pojo_PostRequest();
				data.setName("Yash");
				data.setLocation("India");
				data.setPhone("98453732");
				
				String coursesArr[] = {"C", "C++"};
				data.setCourses(coursesArr);
				
				
				id = given()
					.contentType("application/json")
					.body(data)
				
				.when()
					.post("http://localhost:3000/students")
					.jsonPath().getString("id");
				System.out.println(id);
				
				//.then()
					//.statusCode(201)
					//.body("name", equalTo("yash"))
					//.body("location", equalTo("india"))
					//.body("phone", equalTo("123456"))
					//.body("courses[0]", equalTo("C"))
					//.body("courses[1]", equalTo("C++"))
					//.header("Content-Type", "application/json")
					//.log().all();
				
			}
			
			
			//4) Post request using external json file data
			
			@Test (priority = 1)
			void testPostUsingExternalJsonFile() throws FileNotFoundException
			{
				
				File f = new File(".\\body.json");
				FileReader fr = new FileReader(f);
				JSONTokener jt = new JSONTokener(fr);
				
				JSONObject data = new JSONObject(jt);
				
				
				id = given()
					.contentType("application/json")
					.body(data)
				
				.when()
					.post("http://localhost:3000/students")
					.jsonPath().getString("id");
				System.out.println(id);
				
				//.then()
					//.statusCode(201)
					//.body("name", equalTo("yash"))
					//.body("location", equalTo("india"))
					//.body("phone", equalTo("123456"))
					//.body("courses[0]", equalTo("C"))
					//.body("courses[1]", equalTo("C++"))
					//.header("Content-Type", "application/json")
					//.log().all();
				
			}


	
	@Test (priority = 2, dependsOnMethods = {"testPostUsingExternalJsonFile"})
	void testDelete()
	{
		given()
		
		.when()
			.delete("http://localhost:3000/students/"+id)
		
		.then()
			.statusCode(200)
			.log().all();
	}

}
