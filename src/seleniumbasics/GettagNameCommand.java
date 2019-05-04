package seleniumbasics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GettagNameCommand {
	
WebDriver driver; 
	
	@BeforeClass
	
	public void DriverSetUp () {
		
		System.setProperty("webdriver.gecko.driver", "E:\\Sample Project\\SeleniumWeb\\Drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		//driver.manage().window().maximize();
		driver.get("https://www.google.co.in/");
	}
	@Test
	
	public void GetTagName() throws InterruptedException {
		
		WebElement FindFriends = driver.findElement(By.xpath(".//*[@id='lst-ib']"));
	/*	String tag = FindFriends.getTagName();
		String css = FindFriends.getCssValue("background-color");
		System.out.println(FindFriends.getSize());
		System.out.println(FindFriends.getLocation());*/
		//System.out.println(css);
		
		
		boolean b = FindFriends.isEnabled();
	
		String ok = FindFriends.getAttribute("readonly");
		System.out.println(b);
		System.out.println(ok);
		
		driver.close();
		
	}
		

}
