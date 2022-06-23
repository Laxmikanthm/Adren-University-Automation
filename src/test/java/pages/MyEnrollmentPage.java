package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class MyEnrollmentPage extends BasePage {
    LoginPage lp = new LoginPage();


    public MyEnrollmentPage(){
        PageFactory.initElements(driver,this);
    }


    public void startbutton(String action) {
        driver.findElement(By.xpath("//input[@aria-label='"+action+"']")).click();

    }
    
    public void loginForEnrolment(String username,String password) throws InterruptedException {
        waitForElementToBeClickable(10, lp.Username);
        lp.Username.click();
        Thread.sleep(1000);
        lp.Username.sendKeys(username);
        waitForElementToBeClickable(10, lp.Password);
        lp.Password.click();
        lp.Password.sendKeys(password);
        waitForElementToBeClickable(10, lp.Log_in);
        lp.Log_in.click();
    }
    }

