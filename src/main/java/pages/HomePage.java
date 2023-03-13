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

public class HomePage extends BasePage {

    @FindBy(how = How.XPATH, using = "//*[contains(@class, \"tui-wn5-top-setup\")]")
    @CacheLookup
    private WebElement setUPIcon;

    public HomePage(WebDriver driver) {
        super(driver);
    }


    public void clickSetUpIcon(){
        wait.until(ExpectedConditions.visibilityOf(setUPIcon));
        setUPIcon.click();
    }
}
