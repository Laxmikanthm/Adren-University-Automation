package stepDefinitions;

import base.BasePage;
import base.CommonMethods;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import pages.LoginPage;

public class LoginPageSteps extends BasePage {

    LoginPage lp = new LoginPage();
    CommonMethods cm = new CommonMethods();

    @Given("user login to portal as new applicant")
    public void user_login_to_portal_as_new_applicant() {
//	    lp.login();
    }

    @When("user enters the login details")
    public void userEntersTheLoginDetails() {
        lp.login();
    }

    @Then("user chooses the app")
    public void userChoosesTheApp() {
////		WebElement Winlog;
//		cm.scrollToView(lp.Winlog);
//		lp.chooseApp();
    }

    @Then("user navigates to mailinator to get the reference number")
    public void userNavigatesToMailinatorToGetTheReferenceNumber() throws InterruptedException {
        lp.navigateToMailinator();
    }

    @Then("user scrolls to the {string}")
    public void userScrollsToThe(String element) {
        lp.scrollToElement(element);

    }

}
