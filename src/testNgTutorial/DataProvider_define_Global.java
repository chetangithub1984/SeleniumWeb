package testNgTutorial;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider_define_Global {
	

	@Test(dataProviderClass = DataProviderTest.class,dataProvider = "data1")
	
	public void DataProvidertest(String a , String b) {
		System.out.println(a  + "  " + b);
		
	}
}
