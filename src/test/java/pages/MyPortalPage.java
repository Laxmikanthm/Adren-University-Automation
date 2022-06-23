package pages;

import base.BasePage;
import base.CommonMethods;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MyPortalPage extends BasePage {
    CommonMethods cm = new CommonMethods();

    //    constructor
    public MyPortalPage() {

        PageFactory.initElements(driver, this);
    }


    public void click_on_link(String link) throws InterruptedException {
        WebElement menu = driver.findElement(By.xpath("//div[@class='sv-list-group sv-portal-2-col']/a[contains( text(),'" + link + "')]"));
        menu.click();
        Thread.sleep(2000);
    }

    public void updateEmergencyContact(int index, String link, DataTable table) throws InterruptedException {
        Map<String, String> data = table.asMap(String.class, String.class);

        WebElement parentDiv = driver.findElement(By.xpath("(//h2[@class =  'sv-panel-title']/parent::div/parent::div)[" + index + "]"));
        if (data.get("Relationship") != null) {
            Select selectRelationship = new Select(parentDiv.findElement(By.id("SNK_NKRC.SNK.SRS." + index + "")));
            selectRelationship.selectByVisibleText(data.get("Relationship"));
        }
        if (data.get("Initials") != null) {
            Thread.sleep(200);
            WebElement inp = parentDiv.findElement(By.id("SNK_INIT.SNK.SRS." + index + ""));
            inp.sendKeys(data.get("Initials"));
            inp.sendKeys(Keys.TAB);
        }
        if (data.get("Surname") != null) {
            Thread.sleep(200);
            WebElement inp = parentDiv.findElement(By.id("SNK_SURN.SNK.SRS." + index + ""));
            inp.sendKeys(data.get("Surname"));
            inp.sendKeys(Keys.TAB);
        }
        if (data.get("Forename 1") != null) {
            Thread.sleep(200);
            WebElement inp = parentDiv.findElement(By.id("SNK_FNM1.SNK.SRS." + index + ""));
            inp.sendKeys(data.get("Forename 1"));
            inp.sendKeys(Keys.TAB);
        }
        if (data.get("Email Address") != null) {
            Thread.sleep(200);
            WebElement inp = parentDiv.findElement(By.id("EMAIL." + index + ""));
            inp.sendKeys(data.get("Email Address"));
            inp.sendKeys(Keys.TAB);
        }

        if (data.get("Telephone 1") != null) {
            Thread.sleep(200);
            WebElement inp = parentDiv.findElement(By.id("TEL1.SNK.SRS." + index + ""));
            inp.sendKeys(data.get("Telephone 1"));
            inp.sendKeys(Keys.TAB);
        }


    }

    public void verifyLinks(DataTable table) throws InterruptedException {
        for (String data : table.asList()) {
            if (data.contains("Exceptional Mitigating")) {
                driver.findElement(By.xpath("//p[ text() = '" + data + "']//ancestor::a")).click();
            } else {
                driver.findElement(By.xpath("//div[@class='sv-tiled-link-text' and text() = '" + data + "']//ancestor::a")).click();
            }

            Thread.sleep(3000);
            Set<String> tabs = driver.getWindowHandles();
            Iterator<String> it = tabs.iterator();
            String tab1 = it.next();
            String tab2 = it.next();
            driver.switchTo().window(tab2);
            driver.close();
            driver.switchTo().window(tab1);
        }

    }


}
