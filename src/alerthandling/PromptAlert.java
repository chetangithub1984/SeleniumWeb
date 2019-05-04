package alerthandling;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PromptAlert {
	
	WebDriver driver; 
	
	@BeforeClass
	
	public void DriverSetUp () {
		
		System.setProperty("webdriver.gecko.driver", "E:\\Sample Project\\SeleniumWeb\\Drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		//driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
	}
	@Test
	
	public void PromptAlert1() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, 40);
	driver.switchTo().frame("iframeResult");
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/button")));
	driver.findElement(By.xpath("html/body/button")).click();
	wait.until(ExpectedConditions.alertIsPresent());
		Alert oalert = driver.switchTo().alert();
		
		oalert.sendKeys("Chetan");
		Thread.sleep(2000);
		oalert.accept();

		Thread.sleep(2000);
		driver.close();
		
	}
		
	
	}


