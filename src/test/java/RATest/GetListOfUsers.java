package RATest;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetListOfUsers {

	@Test
	public void getListOfUsers()
	{
		int id;

		RestAssured.baseURI = "https://reqres.in";
		String resp = given().log().all()
				.queryParam("page", "2")
				.header("Content-Type", "application/json")
				.when().get("api/users")
				.then().log().all().assertThat().statusCode(200)
				.extract().response().asString();

		JsonPath jp = new JsonPath(resp);

//-------------------------------------------------
		int numberUsers = jp.getInt("data.size()");
		System.out.println("Number of users: " + numberUsers);

		int perPage = Integer.parseInt(jp.getString("per_page"));
		//int perPage = jp.getInt("perPage"); doesn't work
		System.out.println("Per_page: " + perPage);

		Assertions.assertEquals(numberUsers, perPage);

//-------------------------------------------------
// how to extract aii the names of users

		System.out.println("First name: " + jp.getString("data[0].first_name"));

		for (int i = 0; i< numberUsers; i++)
		{
			String firstName = jp.getString("data[" + i + "].first_name");
			System.out.println("Name" + i + ": "+ firstName);

			if (firstName.equalsIgnoreCase(("George")))
			{
				id = Integer.parseInt(jp.getString("data[" + i + "].id"));
				System.out.println(firstName + "'s id is: " + id);
				Assertions.assertEquals(id, 11 );
				break;
			}

		}

//-------------------------------------------------

}
}


