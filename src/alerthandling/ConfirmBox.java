package alerthandling;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ConfirmBox {
	
	WebDriver driver; 
	
@Test
	
	public void ConfirmBox1() throws InterruptedException {
		
    //driver.switchTo().frame("iframeResult");
		driver.switchTo().frame("iframeResult");
	
	Thread.sleep(2000);
	driver.findElement(By.xpath("html/body/button")).click();
	Thread.sleep(2000);
		Alert oalert = driver.switchTo().alert();

		oalert.accept();
		//oalert.dismiss();
		Thread.sleep(2000);
		driver.close();
		
	
		
	}
	
	@BeforeClass
	
	public void DriverSetUp () {
		
		System.setProperty("webdriver.gecko.driver", "E:\\Sample Project\\SeleniumWeb\\Drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		//driver.manage().window().maximize();
	
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
	}
	
		
	
	}


