package api.endpoints;

//AddBook
//https://rahulshettyacademy.com/Library/Addbook.php
//	
//GetBook
//https://rahulshettyacademy.com/Library/GetBook.php?ID=bcd227
//
//DeleteBook
//https://rahulshettyacademy.com/Library/DeleteBook.php
	
public class Routes {
	
	public static String base_url="https://rahulshettyacademy.com/Library/";
		
	
	//Book Module
	
	public static String addPost_url = base_url+"Addbook.php";
	public static String get_url = base_url+"{mypath}";
	public static String deletePost_url= base_url+"DeleteBook.php";
	
	

}
