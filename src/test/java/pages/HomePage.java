package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.BasePage;

public class HomePage extends BasePage {
    //	WebElements
    @FindBy(xpath = "//div[@id='sits_loading_dialog']")
    WebElement loading;
    @FindBy(xpath = "//div[@id='sits_saving_dialog']")
    WebElement Saving;



    // Constructor
    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public void loading() {
        waitUntilElementNotDisplayed(20, loading);
    }


    public void saving() {
        waitUntilElementNotDisplayed(20,Saving);
    }
}
