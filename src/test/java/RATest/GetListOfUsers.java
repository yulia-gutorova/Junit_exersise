package RATest;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetListOfUsers {

	public static void main(String[] args) {

		RestAssured.baseURI = "https://reqres.in";
		given().log().all()
				.queryParam("page", "2")
				.header("Content-Type", "application/json")
				.when().get("api/users")
				.then().log().all().assertThat().statusCode(200);
	}

}


