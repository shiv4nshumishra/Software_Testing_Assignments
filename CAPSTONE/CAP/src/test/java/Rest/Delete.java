package Rest;

import java.lang.System.Logger;
import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import static io.restassured.RestAssured.given;

public class Delete {

	private static final String BASE_URL = "http://localhost:9010";
	
	@Test
	 public void deleteProduct() {
	     
	     String productName = "NeoFlex Athletic Shoes";

	     
	     Response response = given()
	             .contentType(ContentType.JSON)
	             .when()
	             .delete("/Cart/" + productName)
	             .then()
	             .extract().response();

	     // Validate the status code and the message from the response
	     Assertions.assertEquals(200, response.statusCode());
	     Assertions.assertEquals("Product deleted successfully", response.jsonPath().getString("message"));
	 }
}
