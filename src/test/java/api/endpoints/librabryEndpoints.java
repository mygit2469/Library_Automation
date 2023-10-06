package api.endpoints;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import api.payload.Library;
import api.test.DDTests;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class librabryEndpoints {
	
	public static Response addBook(Library libraryPayload)
	{
		Response response = given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(libraryPayload)
		.when()
			.post(Routes.addPost_url);
		return response;
	}
	
	
	public static Response getBook(String bookID)
	{
		Response response = given()
								.pathParam("mypath", "GetBook.php")
								.queryParam("ID", bookID)
		.when()
			.get(Routes.get_url);
		return response;
	}
	
	public static Response deleteBook(HashMap<String, String> data)
	{
		Response response = given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(data)
		.when()
			.post(Routes.deletePost_url);
		return response;
	}

}
