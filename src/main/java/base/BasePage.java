package base;

import java.time.Duration;
import java.util.Collection;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
    public static WebDriver driver;
    public static String email;
    public static String code;
    public static String parentWindow;
    public static String panel;
    public static WebElement parentSectionElement;
    public static String referenceNumber;
    public static int DataRowNumber;
    public static String SheetName;
//    public static window;
//	locators

//	@FindBy(xpath = "//div[@id='sits_loading_dialog']")
//	WebElement loading;

    // Constructor
    public BasePage() {

    }

    public static void setup(Collection<String> tags) {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        String app = null;
        String url;
        for (String tag : tags) {
            if (tag.contains("create_user")) {
                app = tag.substring(1).toLowerCase(Locale.ROOT);
                break;
            }
        }
        if ("create_user".equals(app))
            url = "https://evision.test.arden.tribalsits.com/urd/sits.urd/run/siw_ipp_lgn.login?process=siw_ipp_app_crs";
        else url = "https://evision.test.arden.tribalsits.com/urd/sits.urd/run/siw_lgn";

        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        parentWindow = driver.getWindowHandle();
    }

    public static void tearDown() {
//		driver.quit();

    }

    public void waitForElementToBeClickable(int time, WebElement locator) {
        new WebDriverWait(driver, Duration.ofSeconds(time)).until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitForElementToBePresent(int time, WebElement locator) {
        new WebDriverWait(driver, Duration.ofSeconds(time)).until(ExpectedConditions.visibilityOf(locator));
    }

    public void waitUntilElementNotDisplayed(int time, WebElement locator) {
        new WebDriverWait(driver, Duration.ofSeconds(time)).until(ExpectedConditions.invisibilityOf(locator));
    }

    public void switchToWindow() {
        Set<String> handles = driver.getWindowHandles();
        System.out.println("No of window handles: " + handles.size());
        if (handles.size() > 1) {
            for (String windowHandle : handles) {
                if (!windowHandle.equals(parentWindow)) {
                    driver.switchTo().window(windowHandle);
                } else {
                    driver.switchTo().window(parentWindow);
                }
            }
        } else {
            driver.switchTo().window(parentWindow);
        }

    }

}
