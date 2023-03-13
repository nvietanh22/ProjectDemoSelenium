package pages;

import core.BasePage;
import core.SeleniumBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Set;

public class WiseAIPage extends BasePage {

    @FindBy(how = How.XPATH, using = "//*[contains(text(),\"Analytics\")]")
    @CacheLookup
    private WebElement AnalyticsBtn;

    @FindBy(how = How.XPATH, using = "//*[contains(text(),\"Setup\")]")
    @CacheLookup
    private WebElement SetupBtn;

    @FindBy(how = How.XPATH, using = "//*[contains(@class, \"close-btn\")]")
    @CacheLookup
    private WebElement closeBtn;

    public WiseAIPage(WebDriver driver) {
        super(driver);
    }


    public void clickCloseGuide(){
        wait.until(ExpectedConditions.visibilityOf(closeBtn));
        closeBtn.click();
    }

    public void clickSetupBtn(){
        wait.until(ExpectedConditions.visibilityOf(SetupBtn));
        SetupBtn.click();
    }
}
