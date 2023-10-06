package api.payload;
import org.apache.commons.lang3.RandomStringUtils;

public class Pojo_PostRequest {

		
		public static String name()
		{
			String name = "Learn Appium Automation with Java";
			return name;
		}
		
		public static String author()
		{
			String author = "John foe";
			return author;
		}
		
		public static String isbn()
		{
			
		String generatedString = RandomStringUtils.randomAlphanumeric(4);
		return(generatedString);
				
		}
		
		public static String aisle()
		{
			
		String generatedString = RandomStringUtils.randomNumeric(4);
		return(generatedString);
				
		}
		
	}
