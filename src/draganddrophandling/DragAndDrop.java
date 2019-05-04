package draganddrophandling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DragAndDrop {
	
	WebDriver driver; 
	
	@BeforeClass
	
	public void DriverSetUp () {
		
		System.setProperty("webdriver.gecko.driver", "E:\\Sample Project\\SeleniumWeb\\Drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		//driver.manage().window().maximize();
		driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
	}
	@Test
	
	public void DragDrop1() throws InterruptedException {
		


	WebElement source = driver.findElement(By.xpath(".//*[@id='box3']"));
	WebElement target = driver.findElement(By.xpath(".//*[@id='box103']"));
	Thread.sleep(2000);
			Actions action = new Actions(driver);
		//action.dragAndDrop(source, target).build().perform();
			//action.dragAndDrop(source, target).perform();
			
			
		//	action.clickAndHold(source).release(target).build().perform();
			action.clickAndHold(source).moveToElement(target).release().build().perform();
		Thread.sleep(2000);
		
		driver.close();
		
	}
		
	
	}


