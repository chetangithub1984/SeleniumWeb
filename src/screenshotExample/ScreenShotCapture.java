package screenshotExample;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ScreenShotCapture {
WebDriver driver; 
	
	@BeforeClass
	
	public void DriverSetUp () {
		
		System.setProperty("webdriver.gecko.driver", "E:\\Sample Project\\SeleniumWeb\\Drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		//driver.manage().window().maximize();
		driver.get("https://www.coolfields.co.uk/2011/04/accessible-forms-checkboxes-and-radio-buttons/");

	}
	@Test
	
	public void ScreenCapture() throws InterruptedException, IOException {
		
		// clicking on "Pepperoni" checkbox
		driver.findElement(By.xpath(".//*[@id='pizza1']")).click();
		Thread.sleep(3000);
		// clicking on "Anchovy" checkbox
		driver.findElement(By.xpath(".//*[@id='pizza2']")).click();
		File SrcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destFile = new File ("E:\\Sample Project\\SeleniumWeb\\ScreenShot\\" + "name1" +  ".png" );
				FileUtils.copyFile(SrcFile, destFile);
				
	}
		
}
