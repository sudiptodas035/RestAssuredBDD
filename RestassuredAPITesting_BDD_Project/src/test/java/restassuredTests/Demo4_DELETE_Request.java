package restassuredTests;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Demo4_DELETE_Request {

int empID=2;
	
	@BeforeClass
	public void putData()
	{
		
		RestAssured.baseURI="https://reqres.in";
		RestAssured.basePath="/api/users/"+empID;
		
	}
	
	@Test
	public void testDELETE()
	{
		Response response=
		given()
		.contentType("application/json")
		.when()
		.put()
		.then()
		.statusCode(200)
		.log().all().extract().response();
		
		String jsonAsString=response.asString();
		String responseBody=response.body().asString();
		System.out.println(responseBody);
		Assert.assertEquals(jsonAsString.contains("updatedAt"),true);
	}
}
