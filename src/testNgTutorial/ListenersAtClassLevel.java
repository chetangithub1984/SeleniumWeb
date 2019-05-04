package testNgTutorial;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(testNgTutorial.TestNGListeners.class)
@Test
public class ListenersAtClassLevel {
	
	public void mtd () {
		System.out.println("Listeners called at class level");
	}

}
