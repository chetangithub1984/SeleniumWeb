package testNgTutorial;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
	
	
	
	@DataProvider(name = "data1")
	
	public Object [ ] [ ] mtd () {
		
		return new Object [ ][ ] {{"UserName" , "Password"} ,{"UserName1" , "Password1"} };
	}
	

	
	@Test(dataProvider = "data1")
	
	public void DataProvidertest(String a , String b) {
		System.out.println(a  + "  " + b);
		
	}
}
