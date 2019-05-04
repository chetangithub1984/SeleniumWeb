package testNgTutorial;

import org.testng.annotations.Test;

public class TestNgPriorityTest {

@Test (priority = 2)
	
	public void Test1() {
		System.out.println("Test1");
	}


@Test(priority = 1)
	
	public void Test2() {
		System.out.println("Test2");
	}
@Test(priority = 3)

public void Test3() {
	System.out.println("Test3");
}
		
}
