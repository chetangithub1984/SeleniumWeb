package singletonBrowserFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;
import java.util.Map;

public class BrowserFactory {

    private static BrowserFactory instance = null;
    ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();

    private BrowserFactory() {

    }

    public static BrowserFactory getInstance() {
        if (instance == null) {
            instance = new BrowserFactory();
        }
        return instance;
    }

    public final void setDriver(String browser) throws Exception {

        DesiredCapabilities caps = new DesiredCapabilities();

        switch (browser) {

            case "chrome":
                ChromeOptions chOptions = new ChromeOptions();
                Map<String, Object> chromePrefs = new HashMap<String, Object>();
                chromePrefs.put("credentials_enable_service", false);
                chOptions.setExperimentalOption("prefs", chromePrefs);
                chOptions.addArguments("--disable-plugins", "--disable-extensions",
                        "--disable-popup-blocking");
                caps.setCapability(ChromeOptions.CAPABILITY, chOptions);
                caps.setCapability("applicationCacheEnabled", false);
                System.setProperty("webdriver.chrome.driver",
                        System.getProperty("user.dir") + "/Drivers/chromedriver.exe");
                webDriver.set(new ChromeDriver());
        }
    }

    public WebDriver getDriver() {
        return webDriver.get();
    }

}
