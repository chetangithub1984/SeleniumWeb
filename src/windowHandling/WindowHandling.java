package windowHandling;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WindowHandling {
	WebDriver driver;

	@BeforeClass
	public void DriverSetUp() {

		System.setProperty("webdriver.gecko.driver",
				"E:\\Sample Project\\SeleniumWeb\\Drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		// driver.manage().window().maximize();
		driver.get("https://www.hdfcbank.com/");
	}

	@Test
	public void WindowHandlingex() throws InterruptedException {

		String ParentWindow = driver.getWindowHandle();
		System.out.println("Parent Window is  - " + ParentWindow);

		driver.findElement(By.id("loginsubmit")).click();
		Thread.sleep(2000);

		Set<String> windowset = driver.getWindowHandles();// / it will return
															// you set of
															// windows
		int a = windowset.size();
		System.out.println("total windows opened are - " + a);
		/*
		 * for (String set : windowset){ if
		 * (!set.equalsIgnoreCase(ParentWindow)){
		 * System.out.println("Child window is : - " + set);
		 * driver.switchTo().window(set); driver.close(); }
		 * 
		 * }
		 */

		Iterator<String> itr = windowset.iterator();
		while (itr.hasNext()) {
			String childwindow = itr.next();
			if (!childwindow.equalsIgnoreCase(ParentWindow)) {
				driver.switchTo().window(childwindow);
				driver.close();
			}
		}
		Thread.sleep(2000);
		driver.switchTo().window(ParentWindow);
		driver.close();

	}
	
	

}
