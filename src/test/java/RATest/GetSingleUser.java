package RATest;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class GetSingleUser {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://reqres.in";
        given().log().all()
                .header("Content-Type", "application/json")
                .when().get("api/users/7")
                .then().log().all().assertThat().statusCode(200);
    }
}
