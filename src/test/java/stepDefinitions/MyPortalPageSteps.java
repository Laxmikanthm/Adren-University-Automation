package stepDefinitions;

import base.BasePage;
import base.CommonMethods;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import pages.MyEnrollmentPage;
import pages.MyPortalPage;
import utils.Data;

import java.io.IOException;
import java.util.List;

public class MyPortalPageSteps extends BasePage {
    MyEnrollmentPage mep = new MyEnrollmentPage();
    MyPortalPage mpp = new MyPortalPage();
    CommonMethods cm = new CommonMethods();
    HomePageSteps hps= new HomePageSteps();
    Data data = new Data();

    @When("user enters the login details of the applicant for My Portal")
    public void userEntersTheLoginDetailsOfTheApplicantForMyPortal() throws InterruptedException, IOException, InvalidFormatException {
        String username= data.getDataValue("Applicant ID");
        String password = data.getDataValue("New password");
        mep.loginForEnrolment(username,password);
    }

    @Then("user clicks on {string} link")
    public void userClicksOnLink(String link) throws InterruptedException {
        mpp.click_on_link(link);
    }

    @Then("user updates following details in {string} Details")
    public void userUpdatesFollowingDetailsInStDetails(int index, String link, DataTable dataTable) throws InterruptedException, IOException, InvalidFormatException {
        List<String> dataList = dataTable.asList();
        for (String input : dataList) {
            switch (input) {
                case "Initials":
                    cm.selectFromInput(input, data.getDataValue(input));
                    break;
                case"Relationship *":
                    hps.userShouldSelectAsFromOptionsInTheDropdown(input,data.getDataValue(input));
                    break;
            }
        }
                mpp.updateEmergencyContact(index, link, dataTable);
    }

    @Then("user clicks on following links to verify and closes the tabs")
    public void userClicksOnFollowingLinksToVerifyAndClosesTheTabs(DataTable table) throws InterruptedException {
        mpp.verifyLinks(table);
    }

    @Then("user navigates to mailinator to check for the mail")
    public void userNavigatesToMailinatorToCheckForTheMail() throws InterruptedException {
//        mpp.checkEmail();

    }
}
