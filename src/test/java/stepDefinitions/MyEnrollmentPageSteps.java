package stepDefinitions;

import base.BasePage;
import base.CommonMethods;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import pages.MyEnrollmentPage;
import utils.Data;

import java.io.IOException;

public class MyEnrollmentPageSteps extends BasePage {
    MyEnrollmentPage mep = new MyEnrollmentPage();
    CommonMethods cm = new CommonMethods();
    Data data = new Data();

    @Then("user clicks on {string} action button")
    public void userClicksOnActionButton(String action) {
        mep.startbutton(action);
    }
    

    @Then("user should enter {string} into {string} enrollment field")
    public void userShouldEnterIntoParentalField(String input, String value) throws InterruptedException, IOException, InvalidFormatException {
        switch (input) {
            case " What is your Parental Occupation?* ":
            case "Name of Last Institution Attended":
            case "Last School Attended":
                value = data.getDataValue(input);
                break;
        }
        cm.selectFromInput(input, value);
    }

    @When("user enters the login details of the applicant for Enrolment")
    public void userEntersTheLoginDetailsOfTheApplicantForEnrolment() throws InterruptedException, IOException, InvalidFormatException {
        String username = data.getDataValue("Applicant ID");
        String password = data.getDataValue("New password");
        mep.loginForEnrolment(username, password);
    }
}
