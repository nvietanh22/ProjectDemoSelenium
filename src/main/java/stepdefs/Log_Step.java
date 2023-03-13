package stepdefs;

import core.SeleniumBase;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.*;

public class Log_Step extends SeleniumBase {
    Common common = new Common(getDriver());
    HomePage homePage = new HomePage(getDriver());
    SetUpPage setUpPage = new SetUpPage(getDriver());
    WiseAIPage wiseAIPage = new WiseAIPage(getDriver());
    SetupWiseAIPage setupWiseAIPage = new SetupWiseAIPage(getDriver());
    LogWiseAIPage logWiseAIPage = new LogWiseAIPage(getDriver());
    @When("Wise Ai access with {string} {string} {string}")
    public void wiseAiAccessWith(String user, String pass, String ip) throws Exception {

        common.navative(user, pass, ip);
        homePage.clickSetUpIcon();
        setUpPage.clickOpenPlatformIcon();
        setUpPage.clickGoAppBtn();
        wiseAIPage.clickCloseGuide();
    }

    @When("Click Setup Wise AI")
    public void clickSetupWiseAI() {
        wiseAIPage.clickSetupBtn();
    }

    @Then("CLick Log Button")
    public void clickLogButton() {
        setupWiseAIPage.clickLogBtn();
    }

    @Then("Click to next page")
    public void clickToNextPage() throws InterruptedException {
        logWiseAIPage.clickNextPage();
    }

    @Then("Click System log Button")
    public void clickSystemLogButton() throws InterruptedException {
        logWiseAIPage.clickSystemLogBtn();
        Thread.sleep(2000);
    }

    @Then("Click to last page")
    public void clickToLastPage() {
        logWiseAIPage.clickLastPage();
    }

    @Then("Click to first page")
    public void clickToFirstPage() {
        logWiseAIPage.clickFirstPage();
    }

    @Then("Check {string} exist in the system log list")
    public void checkExistInTheLogList(String Type) throws Exception {
        logWiseAIPage.checkSystemLogType(Type);
    }

    @Then("Click Event Log Button")
    public void clickEventLogButton() {
        logWiseAIPage.clickEventLogBtn();
    }

    @Then("Check {string} exist in the event log list")
    public void checkExistInTheEventLogList(String Type) throws Exception {
        logWiseAIPage.checkEventLogType(Type);
    }

    @Then("Check data in log table")
    public void checkDataInLogTable() throws Exception {
        logWiseAIPage.checkDataInTable();
    }

    @Then("Log Page is displayed in the form below {string}")
    public void logPageIsDisplayedInTheFormBelow(String header) throws Exception {
        logWiseAIPage.checkHeaderTable(header);
    }
}
