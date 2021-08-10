package RATest;

import RATest.bodies.UpdateBody;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class UpdateUser {

    @Test
    public void updateUser()
    {
        RestAssured.baseURI = "https://reqres.in";
        given().log().all()
            .body(UpdateBody.updateUser())
            .header("Content-Type", "application/json")
        .when().put("api/users/2")
        .then().log().all().assertThat().statusCode(200);
    }
}
