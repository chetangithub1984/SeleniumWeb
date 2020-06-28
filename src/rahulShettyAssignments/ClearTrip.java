package rahulShettyAssignments;

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


public class ClearTrip {

    WebDriver driver;
    WebDriverWait wait;

    @Test

    public void staticDropDownTest() throws InterruptedException {

        new WebDriverWait(driver, Duration.ofSeconds(60)).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        WebElement adults = driver.findElement(By.id("Adults"));
        Select oselect = new Select(adults);
        oselect.selectByValue("3");
        WebElement childrens = driver.findElement(By.id("Childrens"));
        oselect = new Select(childrens);
        oselect.selectByValue("2");
        driver.findElement(By.id("DepartDate")).click();
        driver.findElement(By.xpath("//*[@class='ui-state-default ui-state-highlight ui-state-active ']")).click();
        driver.findElement(By.id("MoreOptionsLink")).click();
        driver.findElement(By.id("AirlineAutocomplete")).sendKeys("Indigo");
        driver.findElement(By.id("SearchBtn")).click();
        String errorMessage = driver.findElement(By.id("homeErrorMessage")).getText();
        System.out.println(errorMessage);




    }

    @BeforeClass

    public void DriverSetUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get("https://www.cleartrip.com/");
    }

    @AfterClass

    public void tearDown() {
        driver.quit();
    }


}


