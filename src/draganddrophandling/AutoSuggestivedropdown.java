package draganddrophandling;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class AutoSuggestivedropdown {

    WebDriver driver;
    WebDriverWait wait;

    @Test

    public void dynamicDropDownTest() throws InterruptedException {

        new WebDriverWait(driver, Duration.ofSeconds(60)).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        driver.findElement(By.xpath("//input[@id='fromCity']")).click();
        driver.findElement(By.xpath("//input[@placeholder='From']")).clear();
        driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("mumb");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys(Keys.ENTER);
        Thread.sleep(2000);




    }

    @BeforeClass

    public void DriverSetUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get("https://www.makemytrip.com/");
    }

    @AfterClass

    public void tearDown() {
        driver.quit();
    }


}


