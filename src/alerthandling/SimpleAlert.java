package alerthandling;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SimpleAlert {
	
	WebDriver driver; 
	
	@BeforeClass
	
	public void DriverSetUp () {
		
		String driverloc = System.getProperty("user.dir");
		System.out.println(driverloc);
		
		System.setProperty("webdriver.gecko.driver", "E:\\Sample Project\\SeleniumWeb\\Drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		//driver.manage().window().maximize();
		driver.get("https://www.ksrtc.in/oprs-web/");
	}
	@Test
	
	public void SimpleAlert1() throws InterruptedException {
		
		driver.findElement(By.xpath(".//*[@id='searchBtn']")).click();
		
		Alert oalert = driver.switchTo().alert();
		Thread.sleep(2000);
		oalert.accept();
		Thread.sleep(2000);
		driver.close();

		
	}
		
	
	}


