package stepDefinitions;

import base.BasePage;
import base.CommonMethods;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import pages.HomePage;
import utils.Data;

import java.io.IOException;

public class HomePageSteps extends BasePage {
    HomePage hp = new HomePage();
    CommonMethods cm = new CommonMethods();
    Data data = new Data();


    @Then("user should select {string} as {string} from Dropdown")
    public void userShouldSelectAsFromDropdown(String dropdown, String value) throws InterruptedException, IOException, InvalidFormatException {
        switch (dropdown) {
            case "Source":
                value = data.getDataValue(dropdown);
                break;
            case "Applicant Acceptance Status*":
                value = data.getDataValue(dropdown);
                break;
            case " Do you wish to accept or decline this offer?* ":            
                value = data.getDataValue(dropdown);
                break;
            case " Country of birth* ": 
            	value = data.getDataValue(dropdown);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + dropdown);
        }
        cm.SelectValueFromDropdown(dropdown, value);

    }

    @Then("user waits till Loading box disappears")
    public void userWaitsTillLoadingBoxDisappears() {

        hp.loading();
    }

    @When("user clicks on refresh")
    public void userClicksOnRefresh() throws InterruptedException {
        cm.refresh();
    }

    @Then("user should select {string} as {string} from options in the Dropdown")
    public void userShouldSelectAsFromOptionsInTheDropdown(String dropdown, String value) throws InterruptedException, IOException, InvalidFormatException {
        switch (dropdown) {
            case " Applicant Acceptance Status* ":
            case "Special Educational Needs?":
            case "Is your gender identity the same gender you were originally assigned at birth?*":
            case "What is your religion/belief?*":
            case "What is your sexual orientation?*":
            case "Have you been in care on or after your 16th birthday?*":
            case "Are you a Carer?*":
            case "Do any of your parents have any higher education qualifications, such as a degree, diploma or certificate of education?*":
            case "What is your Ethnic origin?*":
            case "Year Left Last Insitution":
            case "Year Left Last School":
            case "Term time accommodation":
            case "Relationship *":
            case "Payment options":
            case " Preferred Gender ":
            case " Choose Letter Type* ":
            case " Country of birth* ":	
            case " Your spouse's nationality* ":
            case " Payment options ":	
            case "Relationship":	
            
            	
//                System.out.println("App:+" );
                value = data.getDataValue(dropdown);
                break;
            case "Title":
                String OAOtitle = data.getDataValue("OAOTitle");
                value = OAOtitle;
                break;
            case "Reason for residence":
                value = data.getDataValue(dropdown);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + dropdown);
        }

        cm.selectValueContainsFromDropDown(dropdown, value);
    }

    @Then("user waits till loading completes")
    public void userWaitsTillLoadingCompletes() {
        hp.loading();
    }


}
