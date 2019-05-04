package radiobuttonAndCheckBox;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RadioButtonAndCheckBox {
	WebDriver driver;

	@BeforeClass
	public void DriverSetUp() {

		System.setProperty("webdriver.gecko.driver",
				"E:\\Sample Project\\SeleniumWeb\\Drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		// driver.manage().window().maximize();
		driver.get("https://www.coolfields.co.uk/2011/04/accessible-forms-checkboxes-and-radio-buttons/");
	}

	@Test
	public void RadioButtonex() throws InterruptedException {

		/*
		 * // clicking on "Pepperoni" checkbox
		 * driver.findElement(By.xpath(".//*[@id='pizza1']")).click();
		 * Thread.sleep(3000); // clicking on "Anchovy" checkbox
		 * driver.findElement(By.xpath(".//*[@id='pizza2']")).click();
		 * 
		 * // clicking on "16-25" radio button Thread.sleep(3000);
		 * driver.findElement(By.xpath(".//*[@id='age2']")).click();
		 * Thread.sleep(3000); driver.close();
		 */

		List<WebElement> mylist = driver.findElements(By
				.xpath(".//*[@type = 'checkbox']"));
		System.out.println(mylist.size());

		for (WebElement ele : mylist) {

			ele.click();

		}
		
		List<WebElement> radiolist = driver.findElements(By.xpath(".//*[@type = 'radio']"));
		
		for ( WebElement el : radiolist) {
			el.click();
		}
		
		driver.navigate().to("https://google.co.in");
		driver.navigate().back();
	}

}
