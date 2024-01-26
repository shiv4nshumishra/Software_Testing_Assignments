package Rest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Post {

	@SuppressWarnings("unused")
	private static final String BASE_URL = "http://localhost:9010/home";	
	@SuppressWarnings({ "static-access", "null" })
	@Test
	public void addProduct() {
	RestAssured product = null;
	
	product.put("name", "NeoFlex Athletic Shoes");
	product.put("price", 4500);

	Response response = RestAssured.given()
	 .contentType(ContentType.JSON)
	 .body(product.toString())
	 .post("/Cart");

	System.out.println("Status code: " + response.statusCode());
	System.out.println("Response body: " + response.body().asString());
	}
	
}
