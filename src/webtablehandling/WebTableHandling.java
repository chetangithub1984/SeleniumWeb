package webtablehandling;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WebTableHandling {
	
	WebDriver driver; 
	
	@BeforeClass
	
	public void DriverSetUp () {
		
		System.setProperty("webdriver.gecko.driver", "E:\\Sample Project\\SeleniumWeb\\Drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get("http://toolsqa.com/automation-practice-table/");
	}
	@Test
	
	public void WebTable() throws InterruptedException {
		

		
	List totalrow =	driver.findElements(By.xpath(".//*[@id='content']/table/tbody/tr"));
	int totalrowcount = totalrow.size();
	System.out.println("total row count of the table is : - " + totalrowcount);
	
	List totalcoloumn = driver.findElements(By.xpath(".//*[@id='content']/table/tbody/tr[1]/td"));
	int totalcoloumncount = totalcoloumn.size();
	System.out.println("total coloumn count of the table is : - " + totalcoloumncount);
	
	
	
	
	
	for (int i = 1 ; i <=totalrowcount ; i ++) {
		for ( int j = 1 ; j <= totalcoloumncount ; j ++) {
		//	System.out.print("value of i = " + i + "value of j = " + j);
			System.out.print("  " + driver.findElement(By.xpath(".//*[@id='content']/table/tbody/tr["+i +"]/td["+j+"]")).getText());
		}
		System.out.println();
	}
	
		
		driver.close();
		
	}
		
	
	}


