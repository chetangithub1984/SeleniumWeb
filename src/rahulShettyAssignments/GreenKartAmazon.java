package rahulShettyAssignments;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class GreenKartAmazon {

    WebDriver driver;
    WebDriverWait wait;
    ArrayList<String> list = new ArrayList();

    @Test

    public void staticDropDownTest() throws InterruptedException {
        list.add("Brocolli");
        list.add("Cucumber");
        list.add("Apple");

        int listCounter = 0;
        new WebDriverWait(driver, Duration.ofSeconds(60)).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));

        List<WebElement> producatnameList = driver.findElements(By.xpath("//*[@class='product-name']"));
        List<WebElement> addTocartButtons = driver.findElements(By.xpath("//*[@class='product-action']/button"));
        label1:
        for ( String product : list) {
               for ( int i = 0 ; i < producatnameList.size(); i ++) {
                   if(producatnameList.get(i).getText().contains(product)){
                       listCounter++;
                       driver.findElement(By.xpath("(//*[@class='product-action'])[" + (i+1) + "]")).click();
                       if(listCounter==list.size()) {
                           break label1;
                       }
                   }
               }

            }

    }

    @BeforeClass

    public void DriverSetUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
    }

    @AfterClass

    public void tearDown() {
        //    driver.quit();
    }


}


