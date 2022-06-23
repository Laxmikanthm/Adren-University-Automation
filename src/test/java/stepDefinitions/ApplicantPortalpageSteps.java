package stepDefinitions;

import base.BasePage;
import base.CommonMethods;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import pages.ApplicantPortalPage;
import pages.LoginPage;
import utils.Data;

import java.io.IOException;

public class ApplicantPortalpageSteps extends BasePage {
    ApplicantPortalPage app = new ApplicantPortalPage();
    CommonMethods cm = new CommonMethods();
    LoginPage lp = new LoginPage();
    Data data = new Data();

    @When("user enters the login details of the applicant")
    public void user_enters_the_login_details_of_the_applicant() throws IOException, InvalidFormatException {
        String username = data.getDataValue("Applicant ID");
        String password = data.getDataValue("Password");
        app.loginAsApplicant(username, password);
    }

    @Then("user uploads the required documents")
    public void userUploadsTheRequiredDocuments() throws InterruptedException {
        app.upload();
    }

    @Then("user should select {string} as {string} in Dropdown")
    public void userShouldSelectAsInDropdown(String dropdown, String value) throws InterruptedException, IOException, InvalidFormatException {
        switch (dropdown) {
            case "Your father":
            case "Your mother":
            case "Country of birth":
            case "Your spouse":
            case "Nationality":	
            case " Date you moved to this address* ":
                value = data.getDataValue(dropdown);
                break;            
            default:
                throw new IllegalStateException("Unexpected value: " + dropdown);
        }
        cm.selectDropDownFromList(dropdown, value);
    }
    
    @Then("user should select {string} as {string} 2 in Dropdown")
    public void userShouldSelectAsInDropdown2(String dropdown, String value) throws InterruptedException, IOException, InvalidFormatException
    {
    	cm.selectDropDownFromList2(dropdown, value);    	
    	
    }

    @Then("user enters {string} into  Date you moved to this address*  field")
    public void userEntersIntoDateYouMovedToThisAddressField(String value) throws IOException, InvalidFormatException {
        value=data.getDataValue(" Date you moved to this address* ");
        app.enterAddressDateMonthYear(value);
    }

    @Then("user enters {string} into  Residence start date field")
    public void userEntersIntoResidenceStartDateField(String value) throws IOException, InvalidFormatException {
        value=data.getDataValue(" Residence start date");
        app.enterResDateMonthYear(value);
    }

    @Then("user ticks {string} check box")
    public void userTicksTheCheckBox(String value) throws InterruptedException {
        app.checkbox(value);
    }

    @Then("user logout of the portal")
    public void userLogoutOfThePortal() {
        lp.logout();
    }

//    @Then("user changes the password")
//    public void userChangesThePassword(String input,String value) {
//        cm.enterPasswordValue(input,value);
//    }

    @Then("user changes the {string} as {string}")
    public void userChangesTheAs(String input, String value) throws InterruptedException, IOException, InvalidFormatException {
    	//String date = cm.getDate("HHmmSS");
    	value = data.getDataValue("New password");
        cm.enterInputValue(input, value);
    }


}
