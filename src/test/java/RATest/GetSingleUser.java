package RATest;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class GetSingleUser {

    //public static void main(String[] args)
    @Test
    public void getSingleUser()
    {

        RestAssured.baseURI = "https://reqres.in";
        String resp =
            given().log().all()
            .when().get("api/users/7")
            .then().log().all().assertThat().statusCode(200)
                .extract().response().asString();

        System.out.println("Response: " + resp);
        JsonPath jp = new JsonPath(resp);
        System.out.println("Json response: " + jp);
        String id = jp.getString("data.id");
        System.out.println("Jp id: " + id);

        Assertions.assertEquals(jp.getString("data.id"), "7");
    }
}
