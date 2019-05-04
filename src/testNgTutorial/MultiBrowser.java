package testNgTutorial;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MultiBrowser {
	
WebDriver driver; 
	
    @Parameters("browser")
	@BeforeClass
	
	public void DriverSetUp (String browser) {
		
    	if(browser.equalsIgnoreCase("firefox")) {
    		
    		
    		System.setProperty("webdriver.gecko.driver", "E:\\Sample Project\\SeleniumWeb\\Drivers\\geckodriver.exe");
    		driver = new FirefoxDriver();
    		
    		 
    		  // If browser is IE, then do this	  
    		 
    		  }else if (browser.equalsIgnoreCase("chrome")) { 
    		 
    			  System.setProperty("webdriver.chrome.driver", "E:\\Sample Project\\SeleniumWeb\\Drivers\\chromedriver.exe");
    		   
    		 
    		   driver = new ChromeDriver();
    		 
    		  } 
    	driver.get("https://www.toolsqa.com/selenium-webdriver/testng-multi-browser-cross-browser/"); 
	}
	@Test
	
	public void DragDrop1() throws InterruptedException {
		
	System.out.println("Ok all the best");
		
		driver.close();
	}

}
