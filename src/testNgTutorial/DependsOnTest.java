package testNgTutorial;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependsOnTest {
	
	@Test 
	
	public void login() {
		System.out.println("login");
		Assert.assertTrue(false);
		
	
	}
	
	
	
	@Test(dependsOnMethods  = {"login"})
	
	public void FieldVerification () {
		System.out.println("FieldVerification performed");
	}
	
	@Test(dependsOnMethods= {"FieldVerification"})
	public void logout () {
		System.out.println("Logout");
	}

}
