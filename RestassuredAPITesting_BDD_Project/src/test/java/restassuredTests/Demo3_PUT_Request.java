package restassuredTests;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Utils.Restutils;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

public class Demo3_PUT_Request {

	public static HashMap map=new HashMap();
	
	String name=Restutils.empName();
	String job=Restutils.empJob();
	int empID=2;
	
	@BeforeClass
	public void putData()
	{
		map.put("name", name);
		map.put("job", job);
		
		RestAssured.baseURI="https://reqres.in";
		RestAssured.basePath="/api/users/"+empID;
		
	}
	
	@Test
	public void testPUT()
	{
		Response response=
		given()
		.contentType("application/json")
		.body(map)
		.when()
		.put()
		.then()
		.statusCode(200)
		.log().all().extract().response();
		
	}
}
