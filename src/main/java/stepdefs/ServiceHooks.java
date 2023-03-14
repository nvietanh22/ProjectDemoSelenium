package stepdefs;

import core.SeleniumBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ServiceHooks {
    SeleniumBase seleniumBase = new SeleniumBase();

    @Before
    public void initializeTest(){
        seleniumBase.createDriver();
    }

    @After
    public void afterHookFunction(Scenario scenario){
        if (scenario.isFailed()){
            scenario.attach(((TakesScreenshot)SeleniumBase.driver).getScreenshotAs(OutputType.BYTES),
                    "image/png","image");
        }
        seleniumBase.tearDown();
    }

    //VA dang comment hướng dẫn
}
