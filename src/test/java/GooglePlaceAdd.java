import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import files.PayLoad;

public class GooglePlaceAdd {

	public static void main(String[] args) {
		RestAssured.baseURI="https://rahulshettyacademy.com";
		
		String response=given()
		.queryParam("key", "qaclick123")
		.header("Content-Type","application/json")
		.body(PayLoad.addPlace())
		.when().post("/maps/api/place/add/json")
		.then().assertThat().statusCode(200)
		.log().all()
		.body("scope", equalTo("APP")).extract().response().asString();
		 System.out.println(response);
	}

}
