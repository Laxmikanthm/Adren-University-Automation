package stepDefinitions;

import base.BasePage;
import base.CommonMethods;
import io.cucumber.java.en.Then;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;
import pages.HomePage;
import pages.OAOPage;
import pages.SectionMethods;
import utils.Data;

import java.io.IOException;

public class OAOpageSteps extends BasePage {
    OAOPage oao = new OAOPage();
    CommonMethods cm = new CommonMethods();
    HomePage hp = new HomePage();
    SectionMethods sm = new SectionMethods();
    Data data = new Data();

    @Then("user chooses Blended UK Campuses Portal Course Group")
    public void userChoosesBlendedUKCampusesPortalCourseGroup() {
        oao.selectPortalCourseGroup();
    }

    @Then("user selects {string} tab")
    public void userSelectsTab(String tab) {
        oao.UserSelectsTab(tab);
    }

//    @Then("user should enter {string} into {string} input field of search parameters")
//    public void userShouldEnterIntoInputFieldOfSearchParameters(String value, String input) {
//        oao.enterInput(value,input);
//    }

    @Then("user should enter {string} into Student Number input field")
    public void userShouldEnterIntoStudentNumberInputField(String value) throws IOException, InvalidFormatException {
        value = data.getDataValue("Applicant ID");
        oao.enterInput(value);
    }

    @Then("user selects the student record displayed in Results section")
    public void userSelectsTheStudentRecordDisplayedInResultsSection() {
        oao.selectStudentRecord();
    }

    @Then("user clicks on the {string} panel titles")
    public void userClicksOnThePanelTitles(String title) throws InterruptedException {
        panel = title;
        cm.getSectionElement(panel);
//        hp.loading();
        oao.selectPanelTitle(title);
    }

//    @Then("user clicks on Update Acceptance Status")
//    public void userClicksOnUpdateAcceptanceStatus() {
//        oao.UpdateStatus();
//    }

    @Then("user switches to default window")
    public void userSwitchesToDefaultWindow() throws InterruptedException {
        Thread.sleep(3000);
        driver.switchTo().window(parentWindow);
    }

    @Then("user closes the {string} Panel titles")
    public void userClosesThePanelTitles(String title) throws InterruptedException {
        oao.closePanelTitle(title);
    }

//    @Then("user updates the {String} in Personal Details section")
//    public void userUpdatesThePersonalDetails(String details) {
//        oao.updatePersonalDetails(details);
//    }

    @Then("user updates the {string} button in Personal Details section")
    public void userUpdatesTheButtonInPersonalDetailsSection(String details) throws InterruptedException {
        oao.updatePersonalDetails(details);
    }

    //    @Then("user should select {string} in {string} type")
//    public void userShouldSelectInType(String input, String value) throws InterruptedException {
//}
    @Then("user should select {string} as {string}")
    public void userShouldSelectAs(String input, String value) throws InterruptedException {
        cm.selectFromInput(input, value);
    }

    @Then("user selects {string} button")
    public void userselectsButton(String button) throws InterruptedException {
        sm.clickOnSectionButton(button);
//        if (panel != null) {
//            switch (panel) {
//                case "Student Module Application":
//                    oao.select_SMA_Add_Button(button);
//                    break;
//                case "Clearance Checks":
//                    oao.select_scc_Add_Button(button);
//                    break;
//            }
//        } else
//            oao.selectButton(button);
    }


    @Then("user {string} the details")
    public void userTheDetails(String op) throws InterruptedException {
        oao.basicOperations(op);
    }

    @Then("user clicks on {string}")
    public void userClicksOn(String action) {
        oao.performAction(action);
    }

    @Then("user selects {string} from combo box")
    public void userSelectsFromComboBox(String value) {
        oao.selectCheckbox(value);
    }

    @Then("user should click on Send to Reviewers button")
    public void userShouldClickOnSendToReviewersButton() {
        oao.reviewButton();
    }

//    @Then("user selects Add button")
//    public void userSelectsAddSCCButton() {
//        oao.addSCCButton();
//
//    }

    @Then("user selects Edit button")
    public void userSelectsEditButton() {
        oao.clickEditBtn();
    }

    @Then("user selects {string} radio button")
    public void userSelectsRadioButton(String radio) {
        sm.sectionRadioButton(radio);
    }

    @Then("user clicks on send email to applicant button")
    public void userClicksOnSendEmailToApplicantButton() {
        oao.clickEmailBtn();
    }

    @Then("user clicks on {string} Link")
    public void userClicksOnLink(String link) throws InterruptedException {
        cm.clickOnLink(link);
    }

    @Then("user should enter {string} into {string} section textarea field")
    public void userShouldEnterIntoSectionTextareaField(String value, String input) {
        sm.enterSectionTextAreaValue(value, input);
    }

//    @Then("user selects Save button")
//    public void userSelectsSaveButton() throws InterruptedException {
//        oao.selectButton();
//    }

    @Then("user waits for saving")
    public void userWaitsForSaving() {
        hp.saving();
    }

    @Then("user clicks on Send email to applicant link")
    public void userClicksOnLink() {
        oao.emailLink();
    }

    @Then("user selects Add button")
    public void userSelectsAddButton() {
        oao.addButton();
    }

    @Then("user Selects {string} button")
    public void userSelectsButton(String btn) throws InterruptedException {
        oao.selectButton(btn);
    }


    @Then("user should enter {string} into {string}")
    public void userShouldEnterInto(String value, String input) throws IOException, InvalidFormatException, InterruptedException {
        value = data.getDataValue("CCL Code");
        oao.enterCCLCode(value, input);
    }
}

