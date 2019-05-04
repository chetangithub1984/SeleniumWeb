package seleniumbasics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CopyOfGettagNameCommand {
	
WebDriver driver; 

	
	@BeforeClass
	
	public void DriverSetUp () {
		
		System.setProperty("webdriver.chrome.driver", "E:\\Sample Project\\SeleniumWeb\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.cleartrip.com/");
	}
	@Test
	
	public void GetTagName() throws InterruptedException {
		
		driver.findElement(By.id("FromTag")).sendKeys("DEL");
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//*[contains(text(),'Rio')]"))));
		driver.findElement(By.xpath(".//*[@id='FromTag']")).sendKeys(Keys.TAB);

		
	}
		

}
