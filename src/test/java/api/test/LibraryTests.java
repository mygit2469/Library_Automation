package api.test;

import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import api.endpoints.librabryEndpoints;
import api.payload.Library;
import api.payload.Pojo_PostRequest;
import io.restassured.response.Response;

public class LibraryTests {
	public Response response;
	String bookID;
	
	Pojo_PostRequest pojo;
	Library libraryPayload;
	HashMap<String, String> data = new HashMap<String, String>();
	public Logger logger;
	
	@BeforeTest
	public void setupData()
	{
		pojo = new Pojo_PostRequest();
		libraryPayload = new Library();
		
		libraryPayload.setName(pojo.name());
		libraryPayload.setIsbn(pojo.isbn());
		libraryPayload.setAisle(pojo.aisle());
		libraryPayload.setAuthor(pojo.author());
		
		//Logs
		
		logger=LogManager.getLogger(this.getClass());
		
	}
	
	@Test(priority=1)
	public void postAddBookTest()
	{
		logger.info("**************Adding Book***************************");
		Response response =librabryEndpoints.addBook(libraryPayload);
		response.then().log().all();
		
		bookID = response.jsonPath().get("ID").toString();
		System.out.println(">>>>>>>>" +bookID);
		
		logger.info("**************Added Book Information***************************");
	}
	
	@Test(priority=2)
	public void postGetBook()
	{
		logger.info("**************Get Book Details***************************");
		Response response = librabryEndpoints.getBook(bookID);
		response.then().log().all();
		logger.info("**************We Got Book Details***************************");
	}
	
	@Test(priority=3)
	public void postDeleteBook()
	{
		logger.info("**************Book Delete***************************");
		data.put("ID", bookID);
		Response response = librabryEndpoints.deleteBook(data);
		response.then().log().all();
		logger.info("**************Book is Deleted***************************");
	}

}
