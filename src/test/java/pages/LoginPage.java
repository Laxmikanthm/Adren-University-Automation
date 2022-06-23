package pages;

import base.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;
import org.openqa.selenium.support.ui.Select;

public class LoginPage extends BasePage {

    CommonMethods cm = new CommonMethods();

    //	locators
    @FindBy(xpath = "//input[@id='NEW_USER']")
    WebElement new_User;
    @FindBy(xpath = "//input[@id='signupEmail']")
    WebElement Email;
//    @FindBy(xpath = "//input[@id='signupPassword']")
    @FindBy(xpath = "//input[@name='PASSWORD.DUMMY.MENSYS.1']")
    WebElement Password;
//    @FindBy(xpath = "//button[@id='signupSubmit']")
    @FindBy(xpath = "//input[@value='Log in']")
    WebElement Log_in;
    @FindBy(xpath = "//img[@alt='Test Winlog']")
    WebElement Winlog;
    @FindBy(xpath = "//input[@name='MUA_CODE.DUMMY.MENSYS.1']")
    WebElement Username;
    @FindBy(xpath = "//p[contains(text(), 'Reference:')]")
    WebElement Reference_Number;



    //	Constructor
    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public void login() {
        waitForElementToBeClickable(10, Username);
        Username.click();
        Username.sendKeys("SMEK1");
        waitForElementToBeClickable(10,Password);
        Password.click();
        Password.sendKeys("Soumi961!!");
        waitForElementToBeClickable(10,Log_in);
        Log_in.click();
    }

//    public void chooseApp(){
//        waitForElementToBeClickable(50,Winlog);
//        Winlog.click();
//    }
    public void logout() {
        driver.findElement(By.xpath("//div[@class='sv-header-text sv-hidden-xs']/a")).click();
    }


    public void navigateToMailinator() throws InterruptedException {
        System.out.println("Email:"+ email);
        WebDriver newWindow = driver.switchTo().newWindow(WindowType.WINDOW);
        newWindow.get("https://www.mailinator.com/v4/public/inboxes.jsp");
        Thread.sleep(2000);
        WebElement inputbox= driver.findElement(By.xpath("//input[@id='inbox_field']"));
        waitForElementToBeClickable(10,inputbox);
        inputbox.click();
        inputbox.sendKeys(email);
        driver.findElement(By.xpath("//button[@class='primary-btn']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//table[@class='table-striped jambo_table']/tbody/tr/td[contains(text(),'Submission Confirmation')]")).click();
        driver.switchTo().frame("html_msg_body");
        waitForElementToBePresent(10, Reference_Number);
        String refNumber = Reference_Number.getText();
        String[] refArray = refNumber.split(" ");
        referenceNumber = refArray[1];
        System.out.println(referenceNumber);
    }

    public void scrollToElement(String element) {
        WebElement ele = null;
        if(element.equalsIgnoreCase("Logout"))
            ele = Log_in;

        cm.scrollToTopOfPage(ele);
    }
}

