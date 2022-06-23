package pages;

import base.BasePage;
import base.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Set;

public class AgentPage extends BasePage {
    CommonMethods cm = new CommonMethods();

    //Locators
    @FindBy(xpath = "//h1")
    WebElement titles;

    @FindBy(xpath = "//select[@id='SPLITDATE_D.DUMMY_FIELDS.MENSYS.4-1']")
    WebElement Day;

    @FindBy(xpath = "//select[@id='SPLITDATE_M.DUMMY_FIELDS.MENSYS.4-1']")
    WebElement Month;

    @FindBy(xpath = "//select[@id='SPLITDATE_Y.DUMMY_FIELDS.MENSYS.4-1']")
    WebElement Year;

    @FindBy(xpath = "//button[@class='sv-btn sv-btn-primary']")
    WebElement Select;

    public AgentPage() {
        PageFactory.initElements(driver, this);
    }

    public void UserSelectsTopMenuTab(String menu) {
        List<WebElement> Menu = driver.findElements(By.xpath("//li[@role='menuitem']"));
        for (WebElement Menuitem : Menu) {
            if (Menuitem.getText().contains(menu)) {
                System.out.println(Menuitem.getText());
                Menuitem.findElement(By.tagName("a")).click();
                break;
            }
        }
    }

    public void clickOnsection(String section) {
//        WebElement Section = null;
//        if (section.equalsIgnoreCase("Submit a New Application")) {
//            Section = driver.findElement(By.xpath("//div[@class='sv-col-sm-4 sv-col-xs-6 sv-tiled-col']/a"));
//        } else {
        WebElement Section = driver.findElement(By.xpath("//div[@class='sv-list-group']/a[contains(text(),'" + section + "')]"));
//        }
        Section.click();
    }

    public void waitForTitles() {
        waitForElementToBePresent(10, titles);
//        return titles.getText();
    }

//    public void enterAgencyCode(String value, String input) {
//        String date = cm.getDate("HHmm");
//        if (input.equalsIgnoreCase("Agency code*")) {
//            value = date;
//        }
//        cm.enterInputValue(input, value);
//    }

    public void agentDOB(String value) {
        String[] cellValues = value.split(" ");
        String date = cellValues[0];
        String month = cellValues[1];
        String year = cellValues[2];
        Select selectdate = new Select(Day);
        selectdate.selectByVisibleText(date);
        Select selectmonth = new Select(Month);
        selectmonth.selectByVisibleText(month);
        Select selectyear = new Select(Year);
        selectyear.selectByVisibleText(year);

    }

    public void enterInput(String value, String input) {
        WebElement Input = driver.findElement(By.xpath("//input[@title='" + input + "']"));
//        WebElement inp = inputDiv.findElement(By.xpath("input[@type='text']"));
        Input.sendKeys(value);

    }

    public void clicksOnButton(String Btn) {
        WebElement btn = null;
        if (Btn.equals("Add New Agency")) {
            btn = driver.findElement(By.xpath("//div[@class='sv-col-sm-4']/a"));
        } else if (Btn.equalsIgnoreCase("Continue")) {
            btn = driver.findElement(By.xpath("//div[@class='sv-col-sm-2']/a"));
        } else if (Btn.equalsIgnoreCase("Back")) {
            btn = driver.findElement(By.xpath("//div[@class='sv-col-sm-offset-5 sv-col-sm-2']/a"));
        }else if(Btn.equalsIgnoreCase("Upload Evidence")){
            btn=driver.findElement(By.xpath("//button[contains(text(),'Upload Evidence')]"));
        } else {
            btn = driver.findElement(By.xpath("//div[@class='sv-col-sm-6']/a"));
//        }else  {
//            btn=driver.findElement(By.xpath("//button[@class='sv-btn sv-btn-primary']"));
        }
        btn.click();
    }

    public void clickOnTile(String value) throws InterruptedException {
        switchToWindow();
        List<WebElement> tiles = driver.findElements(By.xpath("//div[contains(@class,'sv-tiled-col')]/a"));
        for (WebElement tile : tiles) {
            String Tile = tile.findElement(By.xpath("./div/div")).getText();
            System.out.println("Tile : " + Tile);
            if (Tile.contains(value)) {
                tile.click();
                Thread.sleep(3000);
                break;
            }
        }
    }

    public void clickOnSelectBtn() {
        Select.click();
    }
}

