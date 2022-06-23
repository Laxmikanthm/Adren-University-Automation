package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SectionMethods extends BasePage {

    @FindBy(how = How.XPATH, using = "//input[@value='E']")
    WebElement External;


    public SectionMethods(){

        PageFactory.initElements(driver, this);
    }

    public void clickOnSectionButton(String btn) throws InterruptedException {
        List<WebElement> buttons = parentSectionElement.findElements(By.tagName("button"));
        System.out.println(buttons.size());
        for (WebElement button : buttons){
            if (button.getText().equalsIgnoreCase(btn)){
                Thread.sleep(8000);
                button.click();
                break;
            }
        }
    }

    public String getSectionTitle(){
        return parentSectionElement.findElement(By.tagName("h2")).getText();
    }

    public void enterSectionInput(String input, String value){
        parentSectionElement.findElement(By.xpath("")).sendKeys(value);
    }

    public void clickOnSectionLink(String linkName){
        List<WebElement> links = parentSectionElement.findElements(By.tagName("a"));
        for (WebElement singleLink: links) {
            if (singleLink.getText().equalsIgnoreCase(linkName)){
                singleLink.click();
                switchToWindow();
                break;
            }
        }
    }

    public void sectionRadioButton(String radio) {
//        if(radio.contains("Blended UK Campuses Portal Course")){
//
//        }
//        if(radio.equalsIgnoreCase("External")) {
//            External.click();
//        }else
        driver.findElement(By.xpath("//input[@value='"+radio+"']")).click();
    }

    public void enterSectionTextAreaValue(String value, String input) {
//        WebElement textArea = driver.findElement(By.xpath("//label[contains(text(),'" + input + "')]/parent::div"));
        List<WebElement> TA = parentSectionElement.findElements(By.tagName("textarea"));
        for(WebElement ta : TA){
            if(ta.getAttribute("title").equalsIgnoreCase(input)){
                ta.sendKeys(value);
                break;
            }
        }

    }
}
