package mousehover;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
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
		
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.NANOSECONDS);
		//driver.manage().timeouts().pageLoadTimeout(500, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
	}
	@Test
	
	public void Mousehover() throws InterruptedException {
		Thread.sleep(3000);
		WebElement category = driver.findElement(By.xpath("//*[@class='nav-line-2 ']"));
		Actions act = new Actions(driver);
		
		act.moveToElement(category).build().perform();
		Thread.sleep(4000);
        List<WebElement> dropdownlist = driver.findElements(By.xpath("//*[@class='nav-link nav-item']"));
		for (WebElement ele : dropdownlist) {
			System.out.println(ele.getText());
			//System.out.println(ele.getAttribute("innerHTML"));
			
		}
		
		driver.close();
		
	}
		
	
	}


