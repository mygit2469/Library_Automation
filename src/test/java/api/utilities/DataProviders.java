package api.utilities;
import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="Data")
	
	public String[][] getAllData() throws IOException
	{
		String path = System.getProperty("user.dir")+"//testData//Librarydata.xlsx";
		XLUtility xl = new XLUtility(path);
		
		int rownum=xl.getRowCount("Sheet1");
		int colcount=xl.getCellCount("Sheet1",1);
				
		
		String apidata[][]=new String [rownum-1][colcount];
		
		for(int i=1;i<rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				apidata[i-1][j]=xl.getCellData("Sheet1", i, j);
			}
		}
		
		return apidata;
	}

}
