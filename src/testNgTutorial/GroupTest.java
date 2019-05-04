package testNgTutorial;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

public class GroupTest {
	
	@Test (groups = {"Sanity" , "Functional"})
	public void Test1 () {
		System.out.println("Sanity " + " Functional");
	}

	@Test (groups = {"Functional", "Regression"})
	public void Test2 () {
		System.out.println("Functional " + " Regression");
	}
	
	@Test (groups = {"Regression"})
	public void Test3 () {
		System.out.println("Regression");
	}
	@Test()
	
	public void withoutgr() {
		System.out.println("without group");
	}
}
