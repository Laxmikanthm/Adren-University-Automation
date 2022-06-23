package stepDefinitions;

import base.BasePage;
import base.CommonMethods;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
import pages.NewUser;
import utils.Data;

import java.io.IOException;
import java.util.List;

public class NewUserSteps extends BasePage {

    NewUser nu = new NewUser();
    CommonMethods cm = new CommonMethods();
    Data data = new Data();


    @When("user clicks on {string} button")
    public void userClicksOnButton(String btn) throws InterruptedException {
        cm.clickOnButton(btn);
    }

    @Then("user should enter {string} into {string} input field")
    public void userShouldEnterIntoInputField(String value, String input) throws InterruptedException, IOException, InvalidFormatException {
        String date = cm.getDate("HHmmSS");
        switch (input) {
            case "Email Address":
                value = data.getDataValue(input);
                System.out.println("Email:" + value);
                String newValue = value.replaceAll("@", date + "@");
                email = value = newValue;
                System.out.println("Email:" + email);
                break;
            case "Confirm Email Address":
                value = email;
                break;
            case "Date of Birth":
            case "Password":
            case "Confirm Password":
            case "Forename":
            case "Keyword":
            case "Telephone number 2":
            case "Address Line 4":
            case "Address Line 2":
            case "Module Code":
            case "Academic Year":
            case "Period Slot":
            case "Module Type":
            case "Level Code":
            case "Mark Scheme":
            case "Mark":
            case "Scheme Code":
            case "Institution":
            case "School Code":
            case "Qual Status":
            case "Decision":
            case "Subject*":
            case "Home address postcode":
            case "Home address 1":
            case "Home address 2":
            case "Mobile *":
            case "Mobile Telephone":
            case "Fax number":
            case "Alternate Email":
            case "Longitude":
            case "Latitude":
            case "Forename 1":
            case "Initials":
            case "Middle Name":
            case "Postcode":
            case "Known as":
            case "Address Line 1":
            case "City":	
            case "Telephone":
            case "Institution / School / College":
            case "Type of qualification":
            case "Select qualification":
            case "Select subject":
            case "Completed?":
            case "Completion date":
            case "Select grade":
            case "Is English your first language?":
            case "Employer name and address":
            case "Job title and main duties":
            case "Full time / Part time":
            case "Passport number":
            case "Date of issue":
            case "Date of expiry":
            case "Country of issue":
            case "Have you previously studied in the UK at degree level or higher?":
            case "Position":
            case "Institution / Company":
            case "Professional Email Address":
            case "Country":
            case "What is your likely source of funding":
            case "Percentage from this source":
            case "How did you find out about the course?":
            case "Surname *":
            case "Telephone 1":
            case " Middle Name ":
           
            	
           
            	
                value = data.getDataValue(input);
                break;
//            case "CCL Code":
//                cm.selectFromInput(input, data.getDataValue(input));
//                break;
            case "Surname":
                String surname = data.getDataValue(input) + date;
                value = surname;
                break;
            case "Previous Surname":
                value = data.getDataValue(input);
                break;
            case "Title":
                value = data.getDataValue("Title 1");
                break;
            case "Second Name":
                value = data.getDataValue(input);
                break;
            case "Third Name":
                value = data.getDataValue(input);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + input);
        }

        cm.enterInputValue(input, value);
    }

    @Then("User enters the following details to create new user")
    public void userEntersTheFollowingDetailsToCreateNewUser(DataTable dataTable) throws InterruptedException, IOException, InvalidFormatException {
        String date = cm.getDate("HHmmSS");
        List<String> dataList = dataTable.asList();
        for (String input : dataList) {
            switch (input) {
                case "Title":
                case "Gender":
                    cm.SelectValueFromDropdown(input, data.getDataValue(input));
                    break;
                case "Date of Birth":
                case "Confirm Password":
                case "Password":
                case "Confirm Email Address":
                case "Email Address":
                    userShouldEnterIntoInputField(data.getDataValue(input), input);
                    break;
                case "Surname":
                    System.out.println("Surname: " + data.getDataValue(input));
                    userShouldEnterIntoInputField(data.getDataValue(input) + date, input);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + input);
            }
            Thread.sleep(1000);
        }

    }

    @Then("user should see {string} page")
    public void userShouldSeePage(String title) {
        String actual_title = cm.getPageTitle((title));
        Assert.assertEquals(title, actual_title);
    }


    @Then("user selects {string} course")
    public void userSelectsCourse(String Course) throws InterruptedException, IOException, InvalidFormatException {
        Course = data.getDataValue("CRS");
        nu.selectCourse(Course);
    }

    @And("User enters the following data in personal Details menuItem")
    public void userEntersTheFollowingDataInPersonalDetails(DataTable dataTable) throws InterruptedException, IOException, InvalidFormatException {
        String date = cm.getDate("HHmmSS");
        List<String> dataList = dataTable.asList();
        String forenameValue = null;
        for (String input : dataList) {
            switch (input) {
                case "Forename":
                    forenameValue = data.getDataValue(input) + date;
                    userShouldEnterIntoInputField(forenameValue, input);
                    break;
                case "Known as":
                    userShouldEnterIntoInputField(forenameValue + data.getDataValue(input), input);
                    break;
                case "Country of birth":
                case "Legal nationality":
                case "Do you have any criminal convictions?":
                    cm.selectValueContainsFromDropDown(input, data.getDataValue(input));
                    break;
                case "Country of residence":
                    cm.SelectValueFromDropdown(input, data.getDataValue(input));
                    break;

                default:
                    throw new IllegalStateException("Unexpected value: " + input);
            }
        }
        cm.clickOnButton("Save and continue");

    }

    @And("User enters the following data in Contact Details menuItem")
    public void userEntersTheFollowingDataInContactDetails(DataTable dataTable) throws InterruptedException, IOException, InvalidFormatException {
        Thread.sleep(5000);
        List<String> dataList = dataTable.asList();
        for (String input : dataList) {
            switch (input) {
                case "Country":
                    System.out.println("Country: " + data.getDataValue(input));
                    cm.selectValueContainsFromDropDown(input, data.getDataValue(input));
                    break;
                case "Postcode":
                case "Telephone":
                case "City":
                case "Address Line 1":
                    userShouldEnterIntoInputField(data.getDataValue(input), input);
                    break;
                case "Do you want to add a correspondence address?":
                    cm.SelectValueFromDropdown(input, data.getDataValue(input));
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + input);
            }
        }
        cm.clickOnButton("Save and continue");

    }


    @And("User enters the following data in Experience menuItem")
    public void userEntersTheFollowingDataInExperienceDetails(DataTable dataTable) throws InterruptedException, IOException, InvalidFormatException {
        List<String> dataList = dataTable.asList();
        for (String input : dataList) {
            switch (input) {
                case "Employer name and address":
                case "Job title and main duties":
                    userShouldEnterIntoTextareaField(data.getDataValue(input), input);
                    break;
                case "Full time / Part time":
                    cm.SelectValueFromDropdown(input, data.getDataValue(input));
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + input);
            }
        }
        cm.clickOnButton("Save and continue");
        Thread.sleep(3000);
    }

    @Then("user should enter {string} into {string} textarea field")
    public void userShouldEnterIntoTextareaField(String value, String input) throws IOException, InvalidFormatException {
        switch (input) {
            case "Additional information":
            case " Message text* ":
                value = data.getDataValue(input);
                break;
        }
        cm.enterTextAreaValue(value, input);
    }

    @And("User enters the following data in Qualifications menuItem")
    public void userEntersTheFollowingDataInQualificationDetails(DataTable dataTable) throws Exception {
        nu.waitForQualification();
        Thread.sleep(3000);
        List<String> dataList = dataTable.asList();
        for (String input : dataList) {
            switch (input) {
                case "Institution / School / College":
                    cm.selectFromInput(input, data.getDataValue(input));
                    break;
                case "Type of qualification":
                case "Is English your first language?":
                case "Select grade":
                case "Select subject":
                    Thread.sleep(1000);
                    cm.SelectValueFromDropdown(input, data.getDataValue(input));
                    break;
                case "Select qualification":
                    Thread.sleep(1000);
                    cm.selectValueContainsFromDropDown(input, data.getDataValue(input));
                    break;
                case "Completed?":
                    Thread.sleep(1000);
                    cm.clickOnCompletedDropdown();
                    break;
                case "Completion date":
                    Thread.sleep(1000);
                    nu.enterCompletionDateMonthYear(input, data.getDataValue(input));
                    break;
            }
        }
        cm.uploadFile("OA_DOCCERT1-FILEUPLOAD-1");
        nu.waitForQualification();
        cm.clickOnButton("Save and continue");
    }

    @And("User enters the following data in Personal Statement menuItem")
    public void userEntersTheFollowingDataInPersonalStatementDetails(DataTable dataTable) throws InterruptedException, IOException, InvalidFormatException {
        List<String> dataList = dataTable.asList();
        for (String input : dataList) {
            switch (input) {
                case "Do you have a personal statement to upload?":
                    System.out.println("personal statement : " + data.getDataValue(input));
                    cm.SelectValueFromDropdown(input, data.getDataValue(input));
                    break;
                case "Please type your personal statement in the box":
                    userShouldEnterIntoTextareaField(data.getDataValue(input), input);
                    break;
            }
        }
        cm.clickOnButton("Save and continue");
    }

    @When("user uploads {string} in {string} menuItem")
    public void userUploadsInMenuItem() {
//        cm.uploadFile();
    }


    @Then("user waits till the page loads")
    public void userWaitsTillThePageLoads() {
        cm.waitTillPageLoads();
    }

    @And("User enters the following data in Passport and Visa menuItem")
    public void userEntersTheFollowingDataInPassportAndVisaMenuItem(DataTable dataTable) throws InterruptedException, IOException, InvalidFormatException {
        List<String> dataList = dataTable.asList();
        for (String input : dataList) {
            switch (input) {
                case "Do you require a visa to study your course?":
                case "Have you previously studied in the UK at degree level or higher?":
                    cm.SelectValueFromDropdown(input, data.getDataValue(input));
                    break;
                case "Passport number":
                    userShouldEnterIntoInputField(data.getDataValue(input), input);
                    break;
                case "Date of issue":
                    nu.enterDateOfissue(input, data.getDataValue(input));
                    break;
                case "Date of expiry":
                    nu.enterDateOfexpiry(input, data.getDataValue(input));
                    break;
                case "Country of issue":
                    cm.selectValueContainsFromDropDown(input, data.getDataValue(input));
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + input);
            }
        }
        cm.uploadPassportFile();
        Thread.sleep(3000);
        cm.clickOnButton("Save and continue");
    }

    @And("User enters the following data in Referees menuItem")
    public void userEntersTheFollowingDataInRefereesMenuItem(DataTable dataTable) throws InterruptedException, IOException, InvalidFormatException {
        String date = cm.getDate("HHmmSS");
        List<String> dataList = dataTable.asList();
        for (String input : dataList) {
            switch (input) {
                case "Type of reference":
                    cm.SelectValueFromDropdown(input, data.getDataValue(input));
                    break;
                case "Title":
                    String value = data.getDataValue("Title 1");
                    cm.selectValueContainsFromDropDown(input, value);
                    break;
                case "Forename":
                    userShouldEnterIntoInputField(data.getDataValue(input) + date, input);
                    break;
                case "Professional Email Address":
                case "Institution / Company":
                case "Position":
                    userShouldEnterIntoInputField(data.getDataValue(input), input);
                    break;
                case "Surname":
                    String refSurname = data.getDataValue("Surname 1") + date;
                    userShouldEnterIntoInputField(refSurname, input);
                    break;
                case "Country":
                    String refCountry = data.getDataValue("Country 1");
                    cm.selectValueContainsFromDropDown(input, refCountry);
                    break;

                default:
                    throw new IllegalStateException("Unexpected value: " + input);
            }
        }
        cm.clickOnButton("Save and continue");
    }


    @And("User enters the following data in Funding menuItem")
    public void userEntersTheFollowingDataInFundingMenuItem(DataTable dataTable) throws InterruptedException, IOException, InvalidFormatException {
        Thread.sleep(1000);
        List<String> dataList = dataTable.asList();
        for (String input : dataList) {
            switch (input) {
                case "What is your likely source of funding?":
                    cm.selectValueContainsFromDropDown(input, data.getDataValue(input));
                    break;
                case "Percentage from this source":
                    userShouldEnterIntoInputField(data.getDataValue(input), input);
                    break;
            }
        }
        cm.clickOnButton("Save and continue");
    }

    @And("User enters the following data in Submission menuItem")
    public void userEntersTheFollowingDataInSubmissionMenuItem(DataTable dataTable) throws Exception {
        List<String> dataList = dataTable.asList();
        for (String input : dataList) {
            switch (input) {
                case "How did you find out about the course?":
                    cm.SelectValueFromDropdown(input, data.getDataValue(input));
                    break;
                case "Please specify":
                    userShouldEnterIntoInputField(data.getDataValue(input), input);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + input);
            }
        }
        cm.clickOncheckbox();
        cm.clickOnPreview();
        cm.clickOnButton("Back to form");
        cm.clickOnsubmitbtn();
        cm.clickOnLink("Review Application");
    }

    @When("user navigates to new user login page")
    public void userNavigatesToNewUserLoginPage() {
//        nu.LoginAsNewUser();
    }

    @Given("user creates new user for {int}")
    public void userCreatesNewUserForApplicant(int applicant) {
        System.out.println(applicant);

    }

    @Given("user reads data from excel file for given sheet name {string} for given row {int}")
    public void userReadsDataFromExcelFileForGivenRowRowNumber(String sheetName, int rowNumber) {
        DataRowNumber = rowNumber;
        SheetName = sheetName;
    }

    @And("user reads {string} header value from excel")
    public void userReadsHeaderValueFromExcel(String header) throws IOException, InvalidFormatException {
        String value = data.getDataValue(header);
        System.out.println(value);
    }

    @And("user reads all headers from excel")
    public void userReadsAllHeadersFromExcel() throws IOException, InvalidFormatException {
        List<String> headers = data.getAllHeaders();
        for (String header : headers) {
            System.out.println(header);
        }
    }


}
