package RATest;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class UpdateUser {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://reqres.in";
        given().log().all()
                .body( "{\n" +
                        "    \"name\": \"Julia\",\n" +
                        "    \"job\": \"Super\"\n" +
                        "}")
                .header("Content-Type", "application/json")
                .when().put("api/users/2")
                .then().log().all().assertThat().statusCode(200);
    }
}
