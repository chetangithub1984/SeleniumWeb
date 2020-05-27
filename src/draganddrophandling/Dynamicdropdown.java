package draganddrophandling;

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
import sun.awt.windows.ThemeReader;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class Dynamicdropdown {

    WebDriver driver;
    WebDriverWait wait;

    @Test

    public void dynamicDropDownTest() throws InterruptedException {

        new WebDriverWait(driver, Duration.ofSeconds(60)).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.xpath(".//a[@value='GOI']")).click();
        Thread.sleep(1000);
        //driver.findElement(By.xpath("(.//a[@value='BOM'])[2]")).click();
        driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_destinationStation1_CTXT']//following::a[@value='BOM']")).click();
        Thread.sleep(3000);


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


