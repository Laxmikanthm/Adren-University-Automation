package stepDefinitions;

import base.BasePage;
import base.CommonMethods;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.AgentPage;
import pages.NewUser;
import utils.Data;

import java.io.IOException;

public class AgentpageSteps extends BasePage {
    AgentPage ap = new AgentPage();
    CommonMethods cm = new CommonMethods();
    NewUserSteps nus = new NewUserSteps();
    HomePageSteps hps = new HomePageSteps();
    Data data= new Data();

    @Then("user clicks on {string} menuItem")
    public void userClicksOnMenuItem(String menu) {
        ap.UserSelectsTopMenuTab(menu);
    }

    @Then("user should see the title")
    public void userShouldSeeTheTitle() {
        ap.waitForTitles();
    }

    @When("user clicks on {string} tab")
    public void userClicksOnTab(String section) {
        ap.clickOnsection(section);
    }

    @Then("user should enter {string} into {string} field")
    public void userShouldEnterIntoField(String value, String input) throws InterruptedException {
        String date = cm.getDate("HHmm");
        if (input.equalsIgnoreCase("Agency code*")) {
            value = code = value + date;
        }
        cm.enterInputValue(input, value);
    }


    @Then("user should enter Agent DOB as {string}")
    public void userShouldEnterAgentDOBAs(String value) {
        ap.agentDOB(value);
    }

    @Then("user should enter {string} into {string} input")
    public void userShouldEnterIntoInput(String value, String input) throws IOException, InvalidFormatException {
        switch (input){
            case"Name":
                value=data.getDataValue(input);
                break;
        }
        ap.enterInput(value, input);
    }

    @Then("user clicks on {string} Button")
    public void userClicksOnButton(String Btn) {
        ap.clicksOnButton(Btn);

    }

    @Then("user clicks on {string} tile")
    public void userClicksOnTile(String tile) throws InterruptedException {
        ap.clickOnTile(tile);
    }

    @When("user clicks on select button")
    public void userClicksOnSelectButton() {
        ap.clickOnSelectBtn();
    }

    @And("User enters the following data in Agent creation portal")
    public void userEntersTheFollowingDataInAgentCreationPortal(DataTable dataTable) throws InterruptedException, IOException, InvalidFormatException {
        ap.UserSelectsTopMenuTab("Admissions Staff Template Page");
        ap.waitForTitles();
        ap.clickOnsection("Edit Agency Details");
        ap.waitForTitles();
        ap.clicksOnButton("Add New Agency");
        userShouldEnterIntoField(dataTable.cell(0, 0), dataTable.cell(0, 1));
        nus.userShouldEnterIntoInputField(dataTable.cell(1, 0), dataTable.cell(1, 1));
        nus.userShouldEnterIntoInputField(dataTable.cell(2, 0), dataTable.cell(2, 1));
        cm.clickOnButton("Next");
        cm.clickOnButton("Exit");
        ap.clickOnsection("Edit Agent Contact Details");
        ap.waitForTitles();
        cm.clickOnButton("Add");
        userShouldEnterIntoInput(dataTable.cell(3, 0), dataTable.cell(3, 1));
        Thread.sleep(1000);
        String agencyCode = dataTable.cell(4, 0);
        if (agencyCode.equalsIgnoreCase("Agency code*"))
            agencyCode = code;
        userShouldEnterIntoField(dataTable.cell(4, 1), agencyCode);
//        hps.userShouldSelectAsFromOptionsInTheDropdown(dataTable.cell(4,0),dataTable.cell(4,1));
        Thread.sleep(1000);
        nus.userShouldEnterIntoInputField(dataTable.cell(5, 0), dataTable.cell(5, 1));
        Thread.sleep(1000);
        ap.agentDOB("26 10 1986");
        Thread.sleep(1000);
        hps.userShouldSelectAsFromDropdown(dataTable.cell(6, 1), dataTable.cell(6, 0));
        Thread.sleep(1000);
        cm.SelectValueFromDropdown(dataTable.cell(7, 1), dataTable.cell(7, 0));
        Thread.sleep(1000);
        nus.userShouldEnterIntoInputField(dataTable.cell(8, 0), dataTable.cell(8, 1));
        Thread.sleep(1000);
        nus.userShouldEnterIntoInputField(dataTable.cell(9, 0), dataTable.cell(9, 1));
        Thread.sleep(1000);
        nus.userShouldEnterIntoInputField(dataTable.cell(10, 0), dataTable.cell(10, 1));
        Thread.sleep(1000);
        cm.clickOnButton("Store");
        ap.UserSelectsTopMenuTab("Admissions Staff Template Page");
        ap.clickOnsection("Log in as an Agent");
        ap.waitForTitles();
        cm.SelectValueFromDropdown(dataTable.cell(11, 0), dataTable.cell(11, 1));
        cm.clickOnButton("Next");
        cm.SelectValueFromDropdown(dataTable.cell(12, 0), dataTable.cell(12, 1));
        cm.clickOnButton("Next");
        ap.clicksOnButton("Log into Agent Portal as agent");
        Thread.sleep(1000);
        ap.clickOnTile("Submit a New Application");
        nus.userShouldEnterIntoInputField(dataTable.cell(13, 0), dataTable.cell(13, 1));
        Thread.sleep(1000);
        cm.SelectValueFromDropdown(dataTable.cell(14, 0), dataTable.cell(14, 1));
        cm.SelectValueFromDropdown(dataTable.cell(15, 0), dataTable.cell(15, 1));
        cm.clickOnButton("Continue");
        Thread.sleep(1000);
        ap.clickOnSelectBtn();
        Thread.sleep(1000);
        cm.SelectValueFromDropdown(dataTable.cell(16, 0), dataTable.cell(16, 1));
        cm.clickOnButton("Continue");
        Thread.sleep(1000);
        ap.clicksOnButton("Continue");
    }
}

