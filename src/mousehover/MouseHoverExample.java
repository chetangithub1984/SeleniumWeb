package mousehover;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MouseHoverExample {
	
	WebDriver driver; 
	
	@BeforeClass
	
	public void DriverSetUp () {
		
		System.setProperty("webdriver.gecko.driver", "E:\\Sample Project\\SeleniumWeb\\Drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.NANOSECONDS);
		//driver.manage().timeouts().pageLoadTimeout(500, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
	}
	@Test
	
	public void Mousehover() throws InterruptedException {
		
		WebElement category = driver.findElement(By.xpath(".//*[@id='nav-link-shopall']/span[2]"));
		Actions act = new Actions(driver);
		
		act.moveToElement(category).perform();
		Thread.sleep(4000);
        List<WebElement> dropdownlist = driver.findElements(By.xpath(".//*[@id='nav-flyout-shopAll']/div[2]//span/span"));
		for (WebElement ele : dropdownlist) {
			//System.out.println(ele.getText());
			System.out.println(ele.getAttribute("innerHTML"));
			
		}
		
		driver.close();
		
	}
		
	
	}


