package api.test;

import java.util.HashMap;

import org.testng.annotations.Test;

import api.endpoints.librabryEndpoints;
import api.payload.Library;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DDTests {

	String bookID;
	
	HashMap<String, String> data = new HashMap<String, String>();
	
	@Test(priority=1,dataProvider="Data", dataProviderClass = DataProviders.class)
	public void postSetUpData(String book_name, String book_isbn, String book_aisle, String book_author)
	{
		Library libraryPayload = new Library();
		libraryPayload.setName(book_name);
		libraryPayload.setIsbn(book_isbn);
		libraryPayload.setAisle(book_aisle);
		libraryPayload.setAuthor(book_author);
	
	}
	
	public void postAddBook()
	{
		Response response = librabryEndpoints.addBook(libraryPayload);
		response.then().log().all();
		
		bookID = response.jsonPath().get("ID").toString();
	}

	
	@Test(priority=2)
	public void postGetBook()
	{
		
		Response response = librabryEndpoints.getBook(bookID);
		response.then().log().all();
	}
	
	@Test(priority=3)
	public void postDeleteBook()
	{
		data.put("ID", bookID);
		Response response = librabryEndpoints.deleteBook(data);
		response.then().log().all();
	}
	
}
