package pages;

import core.BasePage;
import core.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class LogWiseAIPage extends BasePage {

    @FindBy(how = How.XPATH,using = "//*[@type =\"button\" and @class=\"page-number selected-number\"]")
    private WebElement currentPage;

    @FindBy(how = How.XPATH,using = "//button[@class=\"page-number last-page-number\" and not(contains(text(),'/'))]")
    @CacheLookup
    private WebElement lastPage;

    @FindBy(how = How.XPATH, using = "//*[@type=\"button\" and text() =\">>\"]")
    @CacheLookup
    private WebElement lastPageBtn;

    @FindBy(how = How.XPATH, using = "//*[@type=\"button\" and text() =\">\"]")
    @CacheLookup
    private WebElement nextPageBtn;

    @FindBy(how = How.XPATH, using = "//*[@type=\"button\" and text() =\"<\"]")
    @CacheLookup
    private WebElement previousPageBtn;

    @FindBy(how = How.XPATH, using = "//*[@type=\"button\" and text() =\"<<\"]")
    @CacheLookup
    private WebElement FirstPageBtn;

    @FindBy(how = How.XPATH, using = "//*[@class=\"button backup-button primary\"]")
    @CacheLookup
    private WebElement BackupBtn;

    @FindBy(how = How.ID, using = "lang_system_log-log-type-select")
    @CacheLookup
    private WebElement LogTypeSelection;

    @FindBy(how = How.XPATH, using = "//*[contains(text(),'System log')]")
    @CacheLookup
    private WebElement SystemLog_Btn;

    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Event log')]")
    @CacheLookup
    private WebElement EventLog_Btn;

    @FindBy(how = How.ID, using = "lang_system_log-log-type-select")
    @CacheLookup
    private WebElement Select_System_LogType;

    @FindBy(how = How.ID, using = "lang_event_log-log-type-select")
    @CacheLookup
    private WebElement Select_Event_LogType;

    @FindBy(how = How.XPATH, using = "//table[@class = 'table']")
    @CacheLookup
    private WebElement tableLog;
    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Backup')]")
    @CacheLookup
    private WebElement Backup_Btn;
    public void clickSystemLogBtn(){
        wait.until(ExpectedConditions.visibilityOf(SystemLog_Btn));
        SystemLog_Btn.click();
    }

    public void clickEventLogBtn(){
        wait.until(ExpectedConditions.visibilityOf(EventLog_Btn));
        EventLog_Btn.click();
    }

    public LogWiseAIPage(WebDriver driver) {
        super(driver);
    }

    public void clickNextPage() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(nextPageBtn));
        Thread.sleep(2000);
        int page = Integer.parseInt(currentPage.getAttribute("id"));
        if(nextPageBtn.isEnabled()){
            nextPageBtn.click();
            int current1 = Integer.parseInt(currentPage.getText());
            Assert.assertEquals(current1, page + 1, "Log doesn't move to next page!!!");
        }
    }

    public void clickLastPage(){
        wait.until(ExpectedConditions.visibilityOf(lastPageBtn));
        if (lastPageBtn.isEnabled()){
            lastPageBtn.click();
            int LastPage = Integer.parseInt(lastPage.getText());
            int currentpage = Integer.parseInt(currentPage.getText());
            Assert.assertEquals(currentpage, LastPage,"Log doesn't move to last page!!!");
        }
    }

    public void clickFirstPage(){
        wait.until(ExpectedConditions.visibilityOf(FirstPageBtn));
        if (FirstPageBtn.isEnabled()){
            FirstPageBtn.click();
            int currentpage = Integer.parseInt(currentPage.getText());
            Assert.assertEquals(currentpage, 1,"Log doesn't move to first page!!!");
        }
    }

    public void checkSystemLogType(String type) throws Exception {
        wait.until(ExpectedConditions.visibilityOf(Select_System_LogType));
        boolean check = false;
        Select dropdown = new Select(Select_System_LogType);
        List<WebElement> options = dropdown.getOptions();
        for (WebElement option: options) {
            if(type.equalsIgnoreCase(option.getAttribute("value"))){
                check = true;
                break;
            }
        }
        if (check==false) throw new Exception("Log type doesn't exist in the log list");
    }

    public void checkEventLogType(String type) throws Exception {
        wait.until(ExpectedConditions.visibilityOf(Select_Event_LogType));
        boolean check = false;
        Select dropdown = new Select(Select_Event_LogType);
        List<WebElement> options = dropdown.getOptions();
        for (WebElement option: options) {
            if(type.equalsIgnoreCase(option.getAttribute("value"))){
                check = true;
                break;
            }
        }
        if (check==false) throw new Exception("Log type doesn't exist in the log list");
    }

    public void checkDataInTable() throws Exception {
        wait.until(ExpectedConditions.visibilityOf(tableLog));
        List<Integer> listNumber = new ArrayList<Integer>();
        List<LocalDateTime> listDateTime = new ArrayList<LocalDateTime>();
        boolean check = false;
        WebElement tbdoy = tableLog.findElement(By.tagName("tbody"));
        List<WebElement> allRows = tbdoy.findElements(By.tagName("tr"));
        for (WebElement row : allRows) {
            List<WebElement> allCells = row.findElements(By.tagName("td"));
            listNumber.add(Integer.parseInt(allCells.get(0).getText()));
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime dateTime = LocalDateTime.parse(allCells.get(1).getText(), formatter);
            listDateTime.add(dateTime);
        }
        for (int i = 0; i < listNumber.size() - 1; i++) {
            check = false;
            if((listDateTime.get(i).isAfter(listDateTime.get(i+1))== true||listDateTime.get(i).isEqual(listDateTime.get(i+1))== true) && listNumber.get(i)<listNumber.get(i+1)){
                check = true;
            }
            else{
                break;
            }
        }
        if(check == false){
            throw new Exception("Data in table isn't arranged.");
        }
    }

    public void checkHeaderTable(String headerTable) throws Exception {
        wait.until(ExpectedConditions.visibilityOf(tableLog));
        boolean check = false;
        List<String> listHeader = new ArrayList<>();
        String[] headerList = headerTable.split(",");
        List<WebElement> headeElements = tableLog.findElements(By.xpath("./thead/tr//td"));
        for (WebElement headerElement : headeElements) {
            listHeader.add(headerElement.getText());
        }
        for (String header : listHeader) {
            check = false;
            for (String textHeader : headerList) {
                if(header.equalsIgnoreCase(textHeader)){
                    check = true;
                    break;
                }
            }
        }
        if(check == false) {
            throw new Exception("Header table log isn't displayed in the form below!!! ");
        }
    }

    public void clickBackupBtn(){
        wait.until(ExpectedConditions.visibilityOf(Backup_Btn));
        Backup_Btn.click();
    }

    public void selectLogType(String typeLog, String strLogType) throws Exception {
        if (typeLog.equalsIgnoreCase("system")){
            wait.until(ExpectedConditions.visibilityOf(Select_System_LogType));
            Select select = new Select(Select_System_LogType);
            select.selectByValue(strLogType);
        } else if (typeLog.equalsIgnoreCase("event")) {
            wait.until(ExpectedConditions.visibilityOf(Select_Event_LogType));
            Select select = new Select(Select_Event_LogType);
            select.selectByValue(strLogType);
        }else throw new Exception("Fail!!!");
    }

}
