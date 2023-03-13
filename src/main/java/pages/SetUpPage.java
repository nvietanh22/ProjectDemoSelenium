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

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;

public class SetUpPage extends BasePage {

    @FindBy(how = How.XPATH,using = "//span[contains(text(),'Open platform')]")
    @CacheLookup
    private WebElement OpenPlatformDropdown;

    @FindBy(how = How.XPATH, using = "//a[contains(text(), \"Open platform\")]")
    @CacheLookup
    private WebElement OPenPLatformIcon;

    @FindBy(how = How.XPATH, using = "//*[contains(text(), \"Uninstall\")]")
    @CacheLookup
    private WebElement UninstallBtn;

    @FindBy(how = How.XPATH, using = "//button[contains(text(), \"Install\")]")
    @CacheLookup
    private WebElement InstallBtn;

    public SetUpPage(WebDriver driver) {
        super(driver);
    }


    public void clickOpenPlatformIcon(){
        wait.until(ExpectedConditions.visibilityOf(OpenPlatformDropdown));
        OpenPlatformDropdown.click();
        wait.until(ExpectedConditions.visibilityOf(OPenPLatformIcon));
        OPenPLatformIcon.click();
    }

    @FindBy(how = How.XPATH, using = "//span[contains(@class, \"btn btn-primary cm-btn-dark\")]")
    @CacheLookup
    private WebElement chooseFileBtn;

    @FindBy(how = How.XPATH, using = "//*[contains(@class, \"form-control ng-pristine ng-untouched ng-valid ng-empty\")]")
    @CacheLookup
    private WebElement inputText;

    @FindBy(how = How.XPATH,using = "//*[contains(@class, \"form-horizontal ng-pristine ng-valid ng-scope\")]")
    @CacheLookup
    private WebElement dialogConfirm;

    @FindBy(how = How.XPATH, using = "//*[text() = \"OK\" and @class =\"btn cm-btn-point ng-binding\" ]/ancestor::form[contains(@class, \"form-horizontal ng-pristine ng-valid ng-scope\")]")
    @CacheLookup
    private WebElement OKInstallBtn;

    @FindBy(how = How.XPATH, using = "//*[text() = \"OK\" and @class =\"btn cm-btn-point ng-binding\" ]/ancestor::form[contains(@class, \"form-horizontal ng-pristine ng-valid ng-scope\")]")
    @CacheLookup
    private WebElement AcceptBtn;

    @FindBy(how = How.XPATH, using = "//*[contains(text(),\"Go App\")]")
    @CacheLookup
    private WebElement GoAppBtn;



    public void InstallApp() throws IOException, AWTException, InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(chooseFileBtn));
        chooseFileBtn.click();

        // creating object of Robot class

        // copying File path to Clipboard
        String currentPath = null;
        try {
            currentPath = new java.io.File(".").getCanonicalPath();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String filePath = currentPath + "\\WiseParkingGuidance.cap";
        StringSelection s = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);

        Robot r = new Robot();
        //pressing enter
        r.keyPress(KeyEvent.VK_ENTER);
        //releasing enter
        r.keyRelease(KeyEvent.VK_ENTER);
        //pressing ctrl+v
        r.keyPress(KeyEvent.VK_CONTROL);
        r.keyPress(KeyEvent.VK_V);
        //releasing ctrl+v
        r.keyRelease(KeyEvent.VK_CONTROL);
        r.keyRelease(KeyEvent.VK_V);
        //pressing enter
        r.keyPress(KeyEvent.VK_ENTER);
        //releasing enter
        r.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(5000);


        Thread.sleep(10000);
        wait.until(ExpectedConditions.visibilityOf(InstallBtn));
        InstallBtn.click();
        wait.until(ExpectedConditions.visibilityOf(dialogConfirm));
        OKInstallBtn.click();
        wait.until(ExpectedConditions.visibilityOf(AcceptBtn));
        AcceptBtn.click();
        driver.navigate().refresh();
    }
    public void clickGoAppBtn() throws Exception {
        wait.until(ExpectedConditions.visibilityOf(GoAppBtn));
        if(GoAppBtn.isEnabled()){
            GoAppBtn.click();
            Thread.sleep(5000);
            ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs2.get(0));
            driver.close();
            driver.switchTo().window(tabs2.get(1));
        }
        else throw new Exception("App isn't installed!!!");
    }
}
