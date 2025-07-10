import static io.restassured.RestAssured.given;

import org.junit.Test;

import io.restassured.path.json.JsonPath;

public class OAuh2TestExample {
	
	String token;
	String acesstoken;
	JsonPath jsonpath;
	
	public String generateToken() {
		
		token=given()
				.auth().preemptive().basic("username", "password")
				.contentType("application/x-www-form-urlencoded")
				.formParam("grant_type", "client_credentials")
				.when().post("https://example.com/accesstoken").asString();
		        
		        System.out.println("Token: "+token);
		        jsonpath=new JsonPath(token);
		        acesstoken=jsonpath.getString("access_token");
		        System.out.println("Acees Token: "+acesstoken);
		        return acesstoken;
		        
	}
	

}
