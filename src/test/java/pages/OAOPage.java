package pages;

import base.BasePage;
import base.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Objects;

public class OAOPage extends BasePage {
    AgentPage ap = new AgentPage();
    CommonMethods cm = new CommonMethods();


    //    Locators
    @FindBy(how = How.XPATH, using = "//input[@value='PCG_BLUK']")
    WebElement Course;
    @FindBy(how = How.XPATH, using = "//input[@value='Send to Reviewers']")
    WebElement review_Button;
    @FindBy(how = How.XPATH, using = "//li[@role='tab']")
    List<WebElement> Tabs;
    @FindBy(how = How.XPATH, using = "//button[@name='SMADD']")
    WebElement Add_SMA_Button;
    @FindBy(how = How.XPATH, using = "//button[@name='SMAGEN']")
    WebElement Generate_SMA_Button;
    @FindBy(how = How.XPATH, using = "//button[@name='ADDSCC']")
    WebElement Add_SCC_Button;
    @FindBy(how = How.XPATH, using = "//button[@name='SCCGEN']")
    WebElement Generate_SCC_Button;


    //    constructor
    public OAOPage() {
        PageFactory.initElements(driver, this);
    }

    public void selectPortalCourseGroup() {
        waitForElementToBeClickable(20,Course);
        Course.click();
    }

    public void UserSelectsTab(String tab) {

        for (WebElement SingleTab : Tabs) {
            if (SingleTab.getText().contains(tab)) {
                System.out.println(SingleTab.getText());
                SingleTab.findElement(By.tagName("a")).click();
                break;
            }
        }
    }

    public void enterInput(String value) {
        WebElement Input = driver.findElement(By.xpath("//input[@name='STUNUM.DUM1.SRS.1']"));
//        WebElement SN= Input.findElement(By.tagName("input"));
        Input.click();
        Input.sendKeys(value);
        driver.findElement(By.xpath("//div[@class='sv-col-md-2 sv-col-md-offset-10']/input[@value='Find']")).click();
    }

    public void selectStudentRecord() {
        driver.findElement(By.xpath("//table[@id='searchresults']/tbody/tr/td/a[2]")).click();
    }

    public void selectPanelTitle(String title) throws InterruptedException {
        switchToWindow();
        Thread.sleep(5000);
        WebElement Title = driver.findElement(By.xpath("//div[@role='button']/h2[@class='sv-panel-title' and contains(text(),'" + title + "')]"));
        waitForElementToBeClickable(50, Title);
        Title.click();
    }

//    public void UpdateStatus() {
//        driver.findElement(By.xpath("//a[contains(text(),'Update Acceptance Status')]")).click();
//        switchToWindow();
//    }

    public void closePanelTitle(String title) {
        switchToWindow();
        WebElement Title = driver.findElement(By.xpath("//div[@role='button']/h2[@class='sv-panel-title' and contains(text(),'" + title + "')]"));
        waitForElementToBePresent(10, Title);
        Title.click();
    }

    public void updatePersonalDetails(String Details) throws InterruptedException {
        Thread.sleep(2000);
        switchToWindow();
        WebElement details = driver.findElement(By.xpath("//div[@class='sv-col-sm-offset-4 sv-col-sm-4']/a[contains(text(),'" + Details + "')]"));
        details.click();
        switchToWindow();
    }

    public void selectButton(String btn) throws InterruptedException {
        Thread.sleep(3000);
        WebElement Btn = driver.findElement(By.xpath("//button[@title='"+btn+"']"));
        waitForElementToBeClickable(20, Btn);
        Btn.click();
    }

    public void basicOperations(String op) throws InterruptedException {
        Thread.sleep(3000);
//        WebElement OP;
//        waitForElementToBeClickable(50,OP);
        List<WebElement> buttons = driver.findElements(By.tagName("button"));
        for (WebElement button : buttons) {
            System.out.println(button.getText());
            if (button.getText().equalsIgnoreCase(op)) {
                button.click();
                break;
            }
        }
//        OP.click();
    }

    public void performAction(String action) {
        WebElement Action = driver.findElement(By.xpath("//a[contains(text(),'" + action + "')]"));
        waitForElementToBeClickable(10, Action);
        Action.click();
    }

    public void selectCheckbox(String value) {
        switchToWindow();
        WebElement cb = driver.findElement(By.xpath("//li[@class='search-field']/input[contains(@aria-label,' Send to Collection  search')]"));
        cb.click();
        cb.sendKeys(value);
        cb.sendKeys(Keys.ENTER);
    }

    public void reviewButton() {
        review_Button.click();
    }

//    public void addSCCButton() {
//        driver.findElement(By.xpath("//button[@name='ADDSCC']")).click();
//    }

    public void clickEditBtn() {
        WebElement edit_btn =parentSectionElement.findElement(By.tagName("a"));
//        for(WebElement edit:edit_btns){
//            if(edit.getText().contains(""))
//        }
       edit_btn.click();
    }

    public void select_SMA_Add_Button(String button) throws InterruptedException {
        if (button.equalsIgnoreCase("Add")) {
            Add_SMA_Button.click();
        } else{
            Thread.sleep(3000);
            waitForElementToBeClickable(10, Generate_SMA_Button);
            Generate_SMA_Button.click();
        }

    }

    public void select_scc_Add_Button(String button) throws InterruptedException {
        if (button.equalsIgnoreCase("Add")) {
            Add_SCC_Button.click();
        } else{
            Thread.sleep(7000);
            waitForElementToBeClickable(30, Generate_SCC_Button);
            Generate_SCC_Button.click();
        }

    }

//    public void radioButton() {
//        External.click();
//    }

    public void clickEmailBtn() {
        WebElement btn = driver.findElement(By.xpath("//table[@aria-label='Letters and Emails']/tbody"));

    }

    public void emailLink() {

        driver.findElement(By.xpath("//a[contains(text(),'Send email to applicant')]")).click();
    }

    public void addButton() {

        driver.findElement(By.xpath("//button[@title='Add']")).click();
    }

    public void enterCCLCode(String value, String input) throws InterruptedException {
        WebElement inputDiv = driver.findElement(By.xpath("//label[contains(text(),'" + input + "')]/parent::div"));
        WebElement inp = inputDiv.findElement(By.tagName("input"));
        System.out.println("CCL Code: " + value);
        inp.sendKeys(value);
//        driver.findElement(By.xpath("//div[@id='dmu_l0']")).click();
//        inp.sendKeys(Keys.TAB);
        inp.sendKeys(Keys.ARROW_DOWN);
//        Thread.sleep(100);
        inp.sendKeys(Keys.ENTER);
    }
}


