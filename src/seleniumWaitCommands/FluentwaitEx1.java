package seleniumWaitCommands;

import com.google.common.base.Function;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class FluentwaitEx1 {
    WebDriver driver;

    @BeforeClass

    public void DriverSetUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

    }

    @Test

    public void Fluentex() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id='start']/button")).click();
        WebElement helloWorld = driver.findElement(By.xpath("//*[@id='finish']/h4"));
        FluentWait<WebElement> wait = new FluentWait<WebElement>(helloWorld);
        wait.withTimeout(Duration.ofSeconds(100));
        wait.pollingEvery(Duration.ofSeconds(5));
        wait.ignoring(NoSuchElementException.class);

        Function<WebElement, Boolean> func = new Function<WebElement, Boolean>() {
            @Override
            public Boolean apply(WebElement arg0) {
                String text = helloWorld.getText();
                System.out.println(text);
				return text.equals("Hello World!");
			}
        };

        wait.until(func);
        driver.close();

    }

}
