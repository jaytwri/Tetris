package _sc_3.Tetris;

import io.restassured.response.Response;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

@RunWith(SpringRunner.class)
public class TetrisApplicationTests {

	//change input values while testing
	@Test
	public void createUser() {
		Response response = given()
				.header("Content-Type", "application/json")
				.header("Accept", "application/json")
				.body("{\n" +
						"    \"username\" : \"Callum\",\n" +
						"    \"password\" : \"1000\"\n" +
						"}")
				.when()
				.post("http://coms-309-037.class.las.iastate.edu:8080/user")
				.then()
				.extract().response();

		Assertions.assertEquals(200, response.statusCode());
	}

	@Test
	public void getUsers(){
		Response response = given()
				.header("Content-Type","application/json" )
				.header("Accept","application/json" )
				.when()
				.get("http://coms-309-037.class.las.iastate.edu:8080/user")
				.then()
				.extract().response();

		Assertions.assertEquals(200, response.statusCode());
	}

	@Test
	public void getUser() {
		Response response = given()
				.header("Content-Type","application/json" )
				.header("Accept","application/json" )
				.when()
				.get("http://coms-309-037.class.las.iastate.edu:8080/user/Jay")
				.then()
				.extract().response();

		Assertions.assertEquals(200, response.statusCode());
		Assertions.assertEquals("{\"username\":\"Jay\"}", response.getBody().asString());
	}

	@Test
	public void deleteUser() {
		Response response = given()
				.header("Content-Type","application/json" )
				.header("Accept","application/json" )
				.when()
				.delete("http://coms-309-037.class.las.iastate.edu:8080/user/6")
				.then()
				.extract().response();

		Assertions.assertEquals(200, response.statusCode());
	}
	@Test
	public void adminGetAllUsers() {
		Response response = given()
				.header("Content-Type","application/json" )
				.header("Accept","application/json" )
				.when()
				.get("http://coms-309-037.class.las.iastate.edu:8080/admin/root/user")
				.then()
				.extract().response();

		Assertions.assertEquals(200, response.statusCode());
	}

	@Test
	public void postSettings(){
		Response response = given()
			.header("Content-Type","application/json" )
			.header("Accept","application/json" )
			.body("{\n" +
					"    \"boardColour\" : \"green\",\n" +
					"    \"speedOfBlocks\" : \"6\"\n" +
					"}")
			.when()
			.post("http://coms-309-037.class.las.iastate.edu:8080/settings/6")
			.then()
			.extract().response();
		Assertions.assertEquals(200, response.statusCode());
//		try {
//			JSONObject returnObj = new JSONObject(returnString);
//			Assertions.assertEquals("{\"speedOfBlocks\":6,\"boardColour\":\"green\",\"userId\":2}", returnObj.toString());
//		} catch (JSONException e) {
//			e.printStackTrace();
//		}
	}
	@Test
	public void getSettings(){
		Response response = given()
				.header("Content-Type","application/json" )
				.header("Accept","application/json" )
				.get("http://coms-309-037.class.las.iastate.edu:8080/settings/12");
		Assertions.assertEquals(200, response.statusCode());
	}






}
