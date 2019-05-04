package testNgTutorial;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNgAnnotations {
	


	@BeforeSuite
	
	public void beforeSuite() {
		System.out.println("Before Suit");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("beforeTest");
	}
	@BeforeClass
	
	public void beforeClass() {
		System.out.println("beforeClass");
	}
	
	@BeforeMethod
	
	public void beforeMethod() {
		System.out.println("Before Method");
	}
	
	@Test
	public void Test1() {
		System.out.println("Test1");
	}
	@Test 
	public void Test2 () {
	System.out.println("Test2");
}
	
   @AfterSuite
	
	public void afterSuite() {
		System.out.println("After Suit");
	}
	
	@AfterTest
	public void AfterTest() {
		System.out.println("After Test");
	}
	@AfterClass
	
	public void AfterClass() {
		System.out.println("afterClass");
	}
	
	@AfterMethod
	
	public void AfterMethodclass () {
		System.out.println("after method");
	}
	
}
