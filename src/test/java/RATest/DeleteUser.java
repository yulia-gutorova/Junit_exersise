package RATest;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class DeleteUser {

    //public static void main(String[] args)
    @Test
    public void deleteUser()
    {

        RestAssured.baseURI = "https://reqres.in";
        String resp = given().log().all()
                .header("Content-Type", "application/json")
                .when().delete("api/users/2")
                .then().log().all().assertThat().statusCode(204)
                .extract().response().asString();
        System.out.println("Response is: " + resp);
        JsonPath jp = new JsonPath(resp);

        Assertions.assertTrue(resp.isEmpty());
    }

}
