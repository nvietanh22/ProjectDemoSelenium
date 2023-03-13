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

public class SetupWiseAIPage extends BasePage {

    @FindBy(how = How.XPATH, using = "//*[contains(text(),\"Common setup\")]")
    @CacheLookup
    private WebElement CommonSetupBtn;

    @FindBy(how = How.XPATH, using = "//*[contains(text(),\"Log\")]")
    @CacheLookup
    private WebElement LogBtn;

    @FindBy(how = How.XPATH, using = "//*[contains(@class,\"menuButton activeMenu\")]")
    @CacheLookup
    private WebElement BackUpAndRestoreBtn;

    public SetupWiseAIPage(WebDriver driver) {
        super(driver);
    }


    public void clickLogBtn(){
        wait.until(ExpectedConditions.visibilityOf(LogBtn));
        LogBtn.click();
    }

}
