package framehandling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FrameHAndling1 {
	
	WebDriver driver; 
	

	
	@BeforeClass
	
	public void DriverSetUp () {
		System.out.println("ok coming");
		System.setProperty("webdriver.gecko.driver", "E:\\Sample Project\\SeleniumWeb\\Drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		//driver.manage().window().maximize();
		driver.get("http://www.dezlearn.com/testingpage/");
		
	}
	@Test
	
	public void FrameHandle() throws InterruptedException {
		WebElement ele = driver.findElement(By.name("register-iframe"));
		
		//driver.switchTo().frame("do-it-iframe");
		driver.switchTo().frame(ele);
		driver.findElement(By.xpath(".//*[@id='main']/section/div/form/label/input")).sendKeys("Chetan");
		driver.findElement(By.xpath(".//*[@id='main']/section/div/form/input")).click();
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("contact-iframe");
		driver.findElement(By.xpath(".//*[@id='ninja_forms_field_11']")).sendKeys("Chetan");
		//Thread.sleep(2000);
		Thread.sleep(2000);
		driver.close();
		
	}
		
	
	}


