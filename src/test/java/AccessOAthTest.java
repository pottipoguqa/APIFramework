import org.junit.Assert;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class AccessOAthTest extends OAuh2TestExample {
	@Test
	public void testOAuthRequest() {
		
		Response response=RestAssured.given()
		.auth().oauth2(generateToken())
		.when().get("https://localhost/8080/coreid")
		.then().extract().response();
		System.out.println("Response :"+response.asString());
		int statuscode=response.getStatusCode();
		Assert.assertEquals(200, statuscode);
	}

}
