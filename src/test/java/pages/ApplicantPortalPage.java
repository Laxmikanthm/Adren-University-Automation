package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ApplicantPortalPage extends BasePage {
    LoginPage lp = new LoginPage();

    //    Locators
    @FindBy(xpath = "//select[@id='SPLITDATE_Y.TTQ.MENSYS.4']")
    WebElement Add_Year;
    @FindBy(xpath = "//select[@id='SPLITDATE_D.TTQ.MENSYS.4']")
    WebElement Add_Date;
    @FindBy(xpath = "//select[@id='SPLITDATE_M.TTQ.MENSYS.4']")
    WebElement Add_Month;
    @FindBy(xpath = "//select[@id='SPLITDATE_Y.TTQ.MENSYS.8']")
    WebElement Res_Year;
    @FindBy(xpath = "//select[@id='SPLITDATE_M.TTQ.MENSYS.8']")
    WebElement Res_Month;
    @FindBy(xpath = "//select[@id='SPLITDATE_D.TTQ.MENSYS.8']")
    WebElement Res_Date;


    //    constructor
    public ApplicantPortalPage() {
        PageFactory.initElements(driver, this);
    }

    public void loginAsApplicant(String username, String password) {
        waitForElementToBeClickable(10, lp.Username);
        lp.Username.click();
        lp.Username.sendKeys(username);
        waitForElementToBeClickable(10, lp.Password);
        lp.Password.click();
        lp.Password.sendKeys(password);
        waitForElementToBeClickable(10, lp.Log_in);
        lp.Log_in.click();
    }

//    21100435 Applicant@test
//    TestPassword90 21100618
//    21100798 testpassword@890
//    Selenium@56789


    public void enterAddressDateMonthYear(String value) {
        String[] cellValues = value.split(" ");
        String date = cellValues[0];
        String month = cellValues[1];
        String year = cellValues[2];
        Select selectdate = new Select(Add_Date);
        selectdate.selectByVisibleText(date);
        Select selectmonth = new Select(Add_Month);
        selectmonth.selectByVisibleText(month);
        Select selectyear = new Select(Add_Year);
        selectyear.selectByVisibleText(year);
    }

    public void enterResDateMonthYear(String value) {
        String[] cellValues = value.split(" ");
        String date = cellValues[0];
        String month = cellValues[1];
        String year = cellValues[2];
        Select selectdate = new Select(Res_Date);
        selectdate.selectByVisibleText(date);
        Select selectmonth = new Select(Res_Month);
        selectmonth.selectByVisibleText(month);
        Select selectyear = new Select(Res_Year);
        selectyear.selectByVisibleText(year);
    }

    public void checkbox(String value) throws InterruptedException {
        try {
            driver.findElement(By.xpath("//label[contains(text(), '" + value + "')]/input[@type='checkbox']")).click();
        } catch (Exception e) {
            driver.findElement(By.xpath("//input[@type='checkbox']")).click();
        }
    }

        public void upload() throws InterruptedException {
            driver.findElement(By.xpath("//a[contains(text(),'Browse My Computer')]")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//input[@type='file']")).sendKeys(System.getProperty("user.dir") + "\\src\\test\\resources\\Files\\block.PNG");
        }
    }

