import static io.restassured.RestAssured.given;

public class OAthTest {
   public static void main(String[]args){

       given().queryParam("code","")
                       .queryParam("","");


given().queryParam("acces_token","")
        .when()
        .get("https://rahulshettyacademy.com/getCourse.php");
    }
}
