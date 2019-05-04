package testNgTutorial;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryClassTest {
	int count = 0;

	 @Test(retryAnalyzer = testNgTutorial.RetryClass.class)
	 public void Test1()
	 {
		 if (count<2) {
			 count++;
	 Assert.assertEquals(false, true);
	 
		 }
		 else {
			 System.out.println("entered in else");
			 Assert.assertEquals(true, true);
			 System.out.println("Now Test1 passed");
		 }
	 }
	 
	 @Test
	 public void Test2()
	 {
	 Assert.assertEquals(true, true);
	 }

}
