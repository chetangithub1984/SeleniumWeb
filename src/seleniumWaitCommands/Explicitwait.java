package seleniumWaitCommands;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Explicitwait {
WebDriver driver; 
	
	@BeforeClass
	
	public void DriverSetUp () {
		
		System.setProperty("webdriver.gecko.driver", "E:\\Sample Project\\SeleniumWeb\\Drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
	   //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://toolsqa.com/automation-practice-switch-windows/");
		
	}
	@Test
	
	public void Explicitex() throws InterruptedException {
		/*WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='timingAlert']"))).click();*/
		
		WebDriverWait wait = new WebDriverWait(driver, 50);
	
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='timingAlert']"))).click();
		//driver.findElement(By.xpath(".//*[@id='timingAlert']")).click();
		Thread.sleep(10000);
		driver.switchTo().alert().accept();
		driver.close();
		
	}
		
}
