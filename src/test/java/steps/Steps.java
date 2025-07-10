package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class Steps {
    private static final String email="";
    private static final String password="";
    private static final String BASE_URL="https://thinking-tester-contact-list.herokuapp.com";
    private static  String token;
    private static Response response;
    private static String jsonString;


    @Given("I am an authorized user")
    public void i_am_an_authorized_user() {
        RestAssured.baseURI=BASE_URL;
        RequestSpecification request=RestAssured.given();
        request.header("Content-Type","application/json");
        response=request.body("{\n" +
                "    \"email\":\"abc1237@gmail.com\",\n" +
                "    \"password\":\"Password@1237\"\n" +
                "}").post("/users/login");
        String jsonString=response.asString();
        token= JsonPath.from(jsonString).get("token");
        System.out.println(token);

    }
    @Given("A list of contacts are available")
    public void a_list_of_contacts_are_available() {
     RestAssured.baseURI=BASE_URL;
     RequestSpecification request=RestAssured.given();
     response=request
             .header("Authorization","Bearer " +token)
             .when()
             .get("/contacts");
     jsonString=response.asString();
     JsonPath obj=new JsonPath(jsonString);
     List<String> contacts=obj.getList("_id");

        Assert.assertTrue(contacts.size()>0);
        for(int i=0;i<contacts.size();i++){
            String contactId=contacts.get(i);
            System.out.println(contactId);
        }

    }
    @When("I add contact into contactList")
    public void i_add_contact_into_contact_list() {
        RestAssured.baseURI=BASE_URL;
        RequestSpecification request=RestAssured.given();
        request.header("Content-Type","application/json")
                .header("Authorization","Bearer "+token)
                .body("{\n" +
                        "    \"firstName\": \"JohnAdam\",\n" +
                        "    \"lastName\": \"Doelal\",\n" +
                        "    \"birthdate\": \"1970-01-01\",\n" +
                        "    \"email\": \"jdoe@fake.com\",\n" +
                        "    \"phone\": \"8005555555\",\n" +
                        "    \"street1\": \"1 Main St.\",\n" +
                        "    \"street2\": \"Apartment A\",\n" +
                        "    \"city\": \"Anytown\",\n" +
                        "    \"stateProvince\": \"KS\",\n" +
                        "    \"postalCode\": \"12345\",\n" +
                        "    \"country\": \"USA\"\n" +
                        "}").when().post("/contacts").then().assertThat().statusCode(201);

    }
    @Then("Verify the contact is added")
    public void verify_the_contact_is_added() {

    }
}
