package restassuredTests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ModelClasses.*;
import Utils.Restutils;
import common.ApplicationConstants;
import io.restassured.RestAssured;
import io.restassured.response.Response;

/*
given()
  set cookies, add auth, add param, set headers info etc...
when()
  get, put, post, delete
then()
  validate status code, extract response, extract headers cookies & response body...
 */

public class Demo2_POST_Request {

	public static HashMap stringParts = new HashMap();
	public static HashMap map = new HashMap();
	public static Demo2_POST_Model model;
	public static Demo2POSTModelSuccessfulRegister model1;

	@BeforeClass
	public void postdata() {

	}

	@Test(testName = "TC001PostSingleUser", description = "Post single user", groups = "Regression", priority = 1)
	public void TC001PostSingleUser() {
		try {
			RestAssured.baseURI = ApplicationConstants.baseURI;
			RestAssured.basePath = ApplicationConstants.basePathSingleUserURI;
			model = new Demo2_POST_Model();
			model.setname(Restutils.empName());
			model.setjob(Restutils.empJob());
			Response response = given().contentType(ApplicationConstants.ContentType).body(model)

					.when().post()

					.then().statusCode(201).and().body("name", equalTo(model.getname())).and()
					.body("job", equalTo(model.getjob())).header("Content-Type", ApplicationConstants.ContentType).log()
					.all().extract().response();
			JSONParser parser = new JSONParser();
			JSONObject json = (JSONObject) parser.parse(response.getBody().asString());
			System.out.println(json.get("id"));
			System.out.println(json);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Test(testName = "TC002PostRegisterSuccessful", description = "Post register successful", groups = "Regression", priority = 1)
	public void TC002PostRegisterSuccessful() {
		try {
			RestAssured.baseURI = ApplicationConstants.baseURI;
			RestAssured.basePath = ApplicationConstants.basePathPostRegisterSuccessfulURI;
			String uri=RestAssured.baseURI+RestAssured.basePath;
			model1 = new Demo2POSTModelSuccessfulRegister();
			model1.setEmail(Restutils.email());
			model1.setPassword(Restutils.password());
			Response response = given().contentType(ApplicationConstants.ContentType).body(model1).when().post().then()
					.statusCode(ApplicationConstants.StatusCodeOK).and().body("id", equalTo(4)).and()
					.body("token", equalTo("QpwL5tke4Pnpja7X4"))
					.header("Content-Type", ApplicationConstants.ContentType).log().all().extract().response();
			JSONParser parser = new JSONParser();
			JSONObject json = (JSONObject) parser.parse(response.getBody().asString());
			System.out.println(json.get("id"));
			System.out.println(json);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
