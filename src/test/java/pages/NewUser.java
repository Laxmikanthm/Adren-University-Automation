package pages;

import base.BasePage;
import base.CommonMethods;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class NewUser extends BasePage {
    CommonMethods cm = new CommonMethods();
    HomePage hp = new HomePage();

    //    locators
    @FindBy(xpath = "//select[@title='Date Qualification 1 Completed Day']")
    WebElement Date;

    @FindBy(xpath = "//select[@title='Date Qualification 1 Completed Month']")
    WebElement Month;

    @FindBy(xpath = "//select[@title='Date Qualification 1 Completed Year']")
    WebElement Year;

    @FindBy(xpath = "//fieldset[@id= 'OA_QUAL_1']")
    WebElement qualification_field;

    @FindBy(xpath = "//select[@title='Date of issue Day']")
    WebElement DateOfIssue;

    @FindBy(xpath = "//select[@title='Date of issue Month']")
    WebElement MonthOfissue;

    @FindBy(xpath = "//select[@title='Date of issue Year']")
    WebElement YearOfissue;

    @FindBy(xpath = "//select[@title='Date of expiry Day']")
    WebElement DateOfexpiry;

    @FindBy(xpath = "//select[@title='Date of expiry Month']")
    WebElement MonthOfexpiry;

    @FindBy(xpath = "//select[@title='Date of expiry Year']")
    WebElement YearOfexpiry;


    // constructor
    public NewUser() {
        PageFactory.initElements(driver, this);
    }


    public void selectCourse(String Course) throws InterruptedException {
//        boolean selected = false;
        cm.clickOnButton("Search Now");
        hp.loading();
        Thread.sleep(3000);
        List<WebElement> courses = driver.findElements(By.tagName("li"));
        for (WebElement course : courses) {
            if (course.getText().contains(Course)) {
                course.findElement(By.tagName("a")).click();
//                selected = true;
                break;
            }
        }
//        if(!selected){
//            Assert.fail("nothing selected");
//        }
    }

    public void clickOnLookup() {
        WebElement Lookup = driver.findElement(By.xpath("//span[@id='home-lookup']/a"));
        waitForElementToBePresent(5, Lookup);
        Lookup.click();
        hp.loading();
    }

    public void enterCompletionDateMonthYear(String input, String value) {
        System.out.println("value:" + value);
        String[] cellValues = value.split("/");
        String date = cellValues[0];
        String month = cellValues[1];
        String year = cellValues[2];
        Select selectdate = new Select(Date);
        selectdate.selectByVisibleText(date);
        Select selectmonth = new Select(Month);
        selectmonth.selectByVisibleText(month);
        Select selectyear = new Select(Year);
        selectyear.selectByVisibleText(year);

    }

    public void waitForQualification() {

        waitForElementToBePresent(30, qualification_field);
    }

    public void enterDateOfissue(String input, String value) {
        String[] cellValues = value.split("/");
        String date = cellValues[0];
        String month = cellValues[1];
        String year = cellValues[2];
        Select selectdate = new Select(DateOfIssue);
        selectdate.selectByVisibleText(date);
        Select selectmonth = new Select(MonthOfissue);
        selectmonth.selectByVisibleText(month);
        Select selectyear = new Select(YearOfissue);
        selectyear.selectByVisibleText(year);
    }
    public void enterDateOfexpiry(String input, String value) {

        String [] cellValues = value.split("/");
        String date = cellValues[0];
        String month = cellValues[1];
        String year = cellValues[2];
        Select selectdate = new Select(DateOfexpiry);
        selectdate.selectByVisibleText(date);
        Select selectmonth = new Select(MonthOfexpiry);
        selectmonth.selectByVisibleText(month);
        Select selectyear = new Select(YearOfexpiry);
        selectyear.selectByVisibleText(year);


    }
}
