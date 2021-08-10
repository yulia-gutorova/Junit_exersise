package RATest;

import RATest.bodies.PostBody;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;

public class PostUser {

    @Test
    public void postUser()
    {

        RestAssured.baseURI = "https://reqres.in";
        given().log().all()
                .body(PostBody.addUser())
                .header("Content-Type", "application/json")
                .when().post("api/users")
                .then().log().all().assertThat().statusCode(201)
                    .body("name", equalTo("Uggla"))
                    .body("job", equalTo("Gut"))
                    .header("Content-Length", "78");
    }
}
