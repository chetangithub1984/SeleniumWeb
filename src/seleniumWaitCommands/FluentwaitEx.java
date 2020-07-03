package seleniumWaitCommands;

import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FluentwaitEx {
WebDriver driver; 
	
	@BeforeClass
	
	public void DriverSetUp () {
		
		System.setProperty("webdriver.gecko.driver", "E:\\Sample Project\\SeleniumWeb\\Drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
	   driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.get("http://toolsqa.com/automation-practice-switch-windows/");
		
	}
	@Test
	
	public void Fluentex() throws InterruptedException {
		 WebElement Buzz = driver.findElement(By.xpath(".//*[@id='clock']"));
		FluentWait<WebElement> wait = new FluentWait<WebElement>(Buzz);
		//wait.withTimeout(100,TimeUnit.SECONDS);
		//wait.withTimeout(100, TimeUnit.SECONDS);
		//wait.pollingEvery(1, TimeUnit.SECONDS);
		wait.ignoring(NoSuchElementException.class);
		

		
		Function<WebElement, Boolean> func = new Function<WebElement, Boolean>() {
		@Override
		public Boolean apply(WebElement arg0) {
		String buzz = Buzz.getText();
		System.out.println(buzz);
			if (buzz.equals("Buzz Buzz")) {
				return true;
			}
			return false;
		
		}
		};
	
		
		

		
		wait.until(func);
		driver.close();
		
		
	}
	

		
}
