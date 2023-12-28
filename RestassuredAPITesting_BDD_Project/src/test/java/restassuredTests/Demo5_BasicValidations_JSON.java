package restassuredTests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;


/* 
 * Test Status Code
 * Log Response
 * Verifying single content in the response body
 * Verifying multiple contents in the response body
 * Setting parameters & headers
 */

public class Demo5_BasicValidations_JSON {

	 //Test Status Code
	@Test(priority=1)
	public void testStatusCode()
	{
	
		/*Response response=*/
		given()
		.when()
		.get("https://reqres.in/api/users/2")
		.then()
		.statusCode(200);
		/*.log().all().extract().response();
		
		*/
	}
	
	//Log Response
	@Test(priority=2)
	public void testLogging()
	{
	Response response=
			given()
			.when()
			.get("https://reqres.in/api/users/2")
			.then()
			.statusCode(200)
			.log().all().extract().response();
	
	        String responsebody=response.body().asString();
	        System.out.println(responsebody);
	}

	//Verifying single content in the response body
		@Test(priority=3)
		public void testSingleContent()
		{
				given()
				.when()
				.get("https://reqres.in/api/users/2")
				.then()
				.statusCode(200)
				.body("data.id", equalTo(2))
				.log().all().extract().response();
		}

	//Verifying single content in the response body
		@Test(priority=4)
		public void testmultipleContent()
		{
			given()
			 .when()
				.get("https://reqres.in/api/users?page=2")
					.then()
					 .statusCode(200)
					  .body("data.id", hasItems(7,8,9,10,11,12))
						.log().all().extract().response();
		}
		
	//Setting parameters & headers
		@Test(priority=5)
		public void testParamsAndHeaders()
		{
			given()
			.params("MyName", "pavan")
			.headers("MyHeader", "Indian")
			 .when()
				.get("https://reqres.in/api/users?page=2")
					.then()
					 .statusCode(200)
					  .body("data.id", hasItems(7,8,9,10,11,12))
						.log().all();
		}
}
