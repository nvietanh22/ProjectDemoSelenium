package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class SeleniumBase {
    public static WebDriver driver;
    public static String projectPath = System.getProperty("user.dir");
    DesiredCapabilities capabilities;


    public void createDriver(){
        String pathDownload = projectPath + "\\download";
        String driverChrome = projectPath + "\\driver\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverChrome);

        capabilities = new DesiredCapabilities();
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("download.default_directory", pathDownload);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public static WebDriver getDriver() {
        return driver;
    }

    public void tearDown(){driver.close();}
}
