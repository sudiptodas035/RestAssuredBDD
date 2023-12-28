package restassuredTests;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;
import common.ApplicationConstants;

/*
given()
  set cookies, add auth, add param, set headers info etc...
when()
  get, put, post, delete
then()
  validate status code, extract response, extract headers cookies & response body...
 */
public class Demo1_GET_Request {

	@Test(testName = "TC001getSingleUser", description = "Get single user", groups = "Regression", priority = 1)
	public void TC001getSingleUser() {
		try {
			String uri = ApplicationConstants.baseURI + ApplicationConstants.basePathSingleUserURI;
			Response response = given().when().get(uri).then().statusCode(200)
					.statusLine(ApplicationConstants.StatusLineOK).assertThat().body("data.id", equalTo(2))
					.header("Content-Type", ApplicationConstants.ContentType).log().all().extract().response();
		} catch (Exception ex) {
			System.out.println(ex.getMessage().toString());
		}
	}

	@Test(testName = "TC002getListUsers", description = "Get list of user(s)", groups = "Regression", priority = 1)
	public void TC002getListUser() {
		try {
			String uri = ApplicationConstants.baseURI + ApplicationConstants.basePathListUserURI;
			Response response = given().when().get(uri).then().statusCode(ApplicationConstants.StatusCodeOK)
					.statusLine(ApplicationConstants.StatusLineOK).assertThat()
					.body("data.id[0]", equalTo(7), "data.email[0]", equalTo("michael.lawson@reqres.in"),
							"data.first_name[0]", equalTo("Michael"), "data.last_name[0]", equalTo("Lawson"),
							"data.avatar[0]", equalTo("https://reqres.in/img/faces/7-image.jpg"), "data.id[1]",
							equalTo(8), "data.email[1]", equalTo("lindsay.ferguson@reqres.in"), "data.first_name[1]",
							equalTo("Lindsay"), "data.last_name[1]", equalTo("Ferguson"), "data.avatar[1]",
							equalTo("https://reqres.in/img/faces/8-image.jpg"), "data.id[2]", equalTo(9),
							"data.email[2]", equalTo("tobias.funke@reqres.in"), "data.first_name[2]", equalTo("Tobias"),
							"data.last_name[2]", equalTo("Funke"), "data.avatar[2]",
							equalTo("https://reqres.in/img/faces/9-image.jpg"), "data.id[3]", equalTo(10),
							"data.email[3]", equalTo("byron.fields@reqres.in"), "data.first_name[3]", equalTo("Byron"),
							"data.last_name[3]", equalTo("Fields"), "data.avatar[3]",
							equalTo("https://reqres.in/img/faces/10-image.jpg"), "data.id[4]", equalTo(11),
							"data.email[4]", equalTo("george.edwards@reqres.in"), "data.first_name[4]",
							equalTo("George"), "data.last_name[4]", equalTo("Edwards"), "data.avatar[4]",
							equalTo("https://reqres.in/img/faces/11-image.jpg"), "data.id[5]", equalTo(12),
							"data.email[5]", equalTo("rachel.howell@reqres.in"), "data.first_name[5]",
							equalTo("Rachel"), "data.last_name[5]", equalTo("Howell"), "data.avatar[5]",
							equalTo("https://reqres.in/img/faces/12-image.jpg"))
					.header("Content-Type", "application/json; charset=utf-8").log().all().extract().response();
		} catch (Exception ex) {
			System.out.println(ex.getMessage().toString());
		}

	}

	@Test(testName = "TC003getSingleUserNotFound", description = "Get Single User Not Found", groups = "Regression", priority = 1)
	public void TC003getSingleUserNotFound() {
		try {
			String uri = ApplicationConstants.baseURI + ApplicationConstants.basePathSingleUserNotFoundURI;
			given().when().get(uri).then().statusCode(ApplicationConstants.StatusCode404)
					.statusLine(ApplicationConstants.StatusLine404).assertThat().body("", null)
					.header("Content-Type", ApplicationConstants.ContentType).log().all().extract().response();
		} catch (Exception ex) {
			System.out.println(ex.getMessage().toString());
		}
	}

}
