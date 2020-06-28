package dropdown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class Staticdropdown {

    WebDriver driver;
    WebDriverWait wait;

    @Test

    public void staticDropDownTest() throws InterruptedException {

        new WebDriverWait(driver, Duration.ofSeconds(60)).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        driver.findElement(By.xpath("//*[contains(text(),'PASSENGERS')]/following-sibling::div[1]")).click();
        WebElement passangers = driver.findElement(By.id("ctl00_mainContent_ddl_Adult"));
        Select oselect = new Select(passangers);
        oselect.selectByIndex(3);
        Thread.sleep(2000);


    }

    @BeforeClass

    public void DriverSetUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get("http://spicejet.com/");
    }

    @AfterClass

    public void tearDown() {
        driver.quit();
    }


}


