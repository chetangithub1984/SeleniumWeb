package seleniumWaitCommands;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.base.Function;

public class FluentwaitEx1 {
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
		 WebElement Colour = driver.findElement(By.xpath(".//*[@id='colorVar']"));
		FluentWait<WebElement> wait = new FluentWait<WebElement>(Colour);
		wait.withTimeout(100, TimeUnit.SECONDS);
		wait.pollingEvery(250, TimeUnit.MILLISECONDS);
		wait.ignoring(NoSuchElementException.class);
		
		Function<WebElement, Boolean> func = new Function<WebElement, Boolean>() {
		@Override
		public Boolean apply(WebElement arg0) {
		String colour = Colour.getAttribute("style");
		System.out.println(colour);
			if (colour.equals("color: red;")) {
				return true;
			}
			return false;
		}
		};
		
		wait.until(func);
		driver.close();
		
	}
		
}
