package dropdown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DropDown1 {
	
	WebDriver driver; 
	
	@BeforeClass
	
	public void DriverSetUp () {
		
		System.setProperty("webdriver.gecko.driver", "E:\\Sample Project\\SeleniumWeb\\Drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		//driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
	}
	@Test
	
	public void DropDownex() throws InterruptedException {
		
		WebElement month = driver.findElement(By.id("month"));
		//WebElement month = driver.findElement(By.xpath(".//*[@id='u_0_3']")); // will get unexpectedtagname exception
		Select oselect = new Select(month);
		//String FirstMonth = oselect.getFirstSelectedOption().getText();
		//System.out.println(FirstMonth);
		//List<WebElement> alloption = oselect.getAllSelectedOptions();
		oselect.selectByIndex(1);
		Thread.sleep(2000);
		oselect.selectByValue("4");
		Thread.sleep(2000);
		oselect.selectByVisibleText("Jun");
		Thread.sleep(2000);
	
		
		List<WebElement>  dropdownlist = oselect.getOptions();
		
		for (WebElement i :dropdownlist ) {
			System.out.println(i.getText());
		}
		
		
		//System.out.println(oselect.equals("Dec"));
		//System.out.println(alloption.get(0).getText());
		
		driver.close();
		
	}
		
	
	}


