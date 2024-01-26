package Rest;

import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAll {
	@SuppressWarnings("unused")
	private static final String BASE_URL = "http://localhost:9010/home";

	@Test
	public void getAllProducts() {
	Response response = RestAssured.get("/home");
	System.out.println("Status code: " + response.statusCode());
	System.out.println("Response body: " + response.body().asString());
	//List<String> productNames = response.jsonPath().getList("findAll {home -> home == 'shoes'}.name");
	}
}
