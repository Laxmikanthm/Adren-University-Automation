package base;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommonMethods extends BasePage {

    @FindBy(xpath = "//div[@id='sits_loading_dialog']")
    WebElement loading;

    @FindBy(xpath = "//div[@id='dmu_results_div']")
    WebElement result_div;

    @FindBy(xpath = "//img[@alt='loading next page']")
    WebElement loading_next_page;

    @FindBy(xpath = "//select[@id='IPQ_OA_QCOM1']")
    public WebElement Completed;

    @FindBy(xpath = "//input[@id='IPQ_OA_AGREE']")
    WebElement check_box;

    @FindBy(xpath = "//input[@id='but_fake_submit']")
    WebElement submit_btn;

    @FindBy(xpath = "//div[@id='print_preview']")
    WebElement preview_btn;

    @FindBy(xpath = "//h2[@class='sv-panel-title']")
    List<WebElement> Panel_Titles;

    @FindBy(how = How.TAG_NAME, using = "a")
    List<WebElement> links;

    public CommonMethods() {
        PageFactory.initElements(driver, this);
    }

    public void selectValueContainsFromDropDown(String drpdwn, String value) throws InterruptedException {
        switchToWindow();
        Thread.sleep(5000);
        WebElement dd = driver.findElement(By.xpath("//label[contains(text(),'" + drpdwn + "')]/parent::div"));
        WebElement sel = dd.findElement(By.tagName("select"));
        Select select = new Select(sel);
        List<WebElement> options = select.getOptions();
        for (WebElement option : options) {
            if (option.getText().contains(value)) {
                option.click();
                break;
            }
        }
    }

    public void SelectValueFromDropdown(String drpdwn, String value) throws InterruptedException {
        WebElement dd = driver.findElement(By.xpath("//label[contains(text(),'" + drpdwn + "')]/parent::div"));
        WebElement sel = dd.findElement(By.tagName("select"));
        Select select = new Select(sel);
        select.selectByVisibleText(value);
        Thread.sleep(2000);
        System.out.println("Selected :" + drpdwn + " as " + value);
    }

    public void enterInputValue(String input, String value) throws InterruptedException {
        Thread.sleep(200);
        WebElement inputDiv = driver.findElement(By.xpath("//label[contains(text(),'" + input + "')]/parent::div"));
        WebElement inp = inputDiv.findElement(By.tagName("input"));
        inp.sendKeys(value);
        inp.sendKeys(Keys.TAB);
    }

    public void clickOnButton(String btn) throws InterruptedException {
        Thread.sleep(2000);
        WebElement button;
        try {
            button = driver.findElement(By.xpath("//input[@value = '" + btn + "' and @type='submit']"));
        } catch (Exception e) {
            button = driver.findElement(By.xpath("//input[@value = '" + btn + "' and @type='button']"));
//        }finally {
//            button=driver.findElement(By.xpath("//button[@title='Ok']"));
        }
        if (button != null)
            button.click();

    }

    public String getDate(String pattern) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    public String getPageTitle(String title) {
        WebElement PageTitle = driver.findElement(By.xpath("//h2[contains(text(),'" + title + "')]"));
        return PageTitle.getText();
    }

    public void enterTextAreaValue(String value, String input) {
        WebElement textArea = driver.findElement(By.xpath("//label[contains(text(),'" + input + "')]/parent::div"));
        WebElement TA = textArea.findElement(By.tagName("textarea"));
        TA.sendKeys(value);
    }

    public void uploadFile(String fileName) {
        File file = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\Files\\upload.txt");
        WebElement fileElement = driver.findElement(By.xpath("//input[@type='file'and @id='" + fileName + "']"));
//        fileElement.click();
        fileElement.sendKeys(file.getAbsolutePath());
//        WebElement file=driver.findElement(By.xpath("//input[@value='Select File']"));
//        .sendKeys();
//        file.sendKeys(System.getProperty(("user.dir") + "\\src\\test\\resources\\Files\\upload.txt"));
//        try {
//            if(file.isFile()){
//                System.out.println(file.toString());
//                fileElement.sendKeys(file.toString());
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    public void selectFromInput(String input, String value) throws InterruptedException {
//        enterInputValue(input, value);
        WebElement inputDiv = driver.findElement(By.xpath("//label[contains(text(),'" + input + "')]/parent::div"));        
        
        WebElement inp = inputDiv.findElement(By.tagName("input"));
        inp.sendKeys(value);
        
//        if(inp.getText().contains("Queen Mary University of London")) {
        driver.findElement(By.xpath("//a[@id = 'dmu_a0']/div")).click();
//        }else(inp.getText().contains("British Virgin Islander")){
//            driver.findElement(By.xpath("//a[@id = 'dmu_a0']/div")).click();
//        }
        inp.sendKeys(Keys.TAB);
        Thread.sleep(5000);
//        waitForElementToBePresent(60, result_div);
//        List<WebElement> searchResults = result_div.findElements(By.tagName("a"));
//        List<WebElement> searchResults1 = searchResults.findElement(By.tagName("a"));
//        System.out.println(searchResults.size());
//        searchResults.get(0).click();
    }

    public void refresh() throws InterruptedException {
        driver.navigate().refresh();
        Thread.sleep(3000);
    }

    public void waitTillPageLoads() {
        waitUntilElementNotDisplayed(60, loading_next_page);
    }

    public void scrollToView(WebElement element) throws Exception {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoViewIfNeeded()", element);
        Thread.sleep(1000);
    }

    public void clickOncheckbox() {
        check_box.click();
        System.out.println("checkbox clicked");
    }

    public void clickOnCompletedDropdown() {
        Completed.click();
        Completed.sendKeys(Keys.ARROW_DOWN);
        Completed.sendKeys(Keys.ENTER);
    }

    public void clickOnsubmitbtn() {
        submit_btn.click();
        System.out.println("submit button clicked");
    }

    public void clickOnPreview() throws Exception {
        checkPreview();
        preview_btn.click();

    }

    public void checkPreview() throws Exception {
        List<String> titles = new ArrayList<String>();
        titles.add("Personal Details");
        titles.add("Qualifications");
        titles.add("Passport and Visa");
        titles.add("Submission");

        for (WebElement panel_title : Panel_Titles) {
            String title_text = panel_title.getText();
            for (String t : titles) {
                if (title_text.contains(t)) {
//                	Assert.assertTrue();
                    scrollToView(panel_title);
                }

            }
        }

    }
//	public function testDraw() {
//		try {
//			$this->execute(array('script' => "  var c = document.getElementById('canvas');
//					var ctx = c.getContext('2d');
//			ctx.beginPath();
//			ctx.arc(100, 75, 50, 0, 2 * Math.PI);
//			ctx.stroke();",
//			'args' => array()));
//
//			echo 'done';
//			sleep(10);
//		} catch (Exception $ex) {
//			echo 'not done';
//		}

    public void clickOnLink(String link) throws InterruptedException {
        Thread.sleep(3000);
        for (WebElement single_link : links) {
//            if(link.equalsIgnoreCase("Logout"))
//                scrollToTopOfPage(single_link);
//            System.out.println(single_link.getText() + "link clicked");
            if (single_link.getText().equalsIgnoreCase(link)) {
                single_link.click();
//                switchToWindow();
                break;

            }
        }
//        switchToWindow();
    }

    public void getSectionElement(String sectionName) throws InterruptedException {
        Thread.sleep(3000);
        switchToWindow();
        parentSectionElement = driver.findElement(By.xpath("//h2[text() = '" + sectionName + "']/parent::div/parent::div"));

    }

    public void selectDropDownFromList(String dropdown, String value) throws InterruptedException {
        WebElement dd = driver.findElement(By.xpath("//label[contains(text(),'" + dropdown + "')]/parent::div"));
        WebElement attr = dd.findElement(By.tagName("a"));
        attr.click();
        waitForElementToBeClickable(10, dd);
        Thread.sleep(2000);
        try {
            dd.findElement(By.xpath("//ul[@class = 'chosen-results']/li[text()='" + value + "']")).click();
            Thread.sleep(2000);
        } catch (ElementClickInterceptedException e) {
            driver.findElement(By.xpath("//input[contains(@aria-label, '" + dropdown + "')]")).sendKeys(value, Keys.ARROW_DOWN, Keys.ENTER);
            Thread.sleep(2000);
        }
//        //ul[@class = 'chosen-results']/li[text()='United Kingdom, not otherwise specified']
    }
    
    public void selectDropDownFromList2(String dropdown, String value) throws InterruptedException {
        WebElement dd = driver.findElement(By.id("//select[@id='ANSWER.TTQ.MENSYS.4.']"));
        WebElement attr = dd.findElement(By.tagName("a"));
        attr.click();
        waitForElementToBeClickable(10, dd);
        Thread.sleep(2000);
        Select select = null;
		List<WebElement> options = select.getOptions();
        for (WebElement option : options) {
            if (option.getText().contains(value)) {
                option.click();
                break;
            }
        }
//        try {
//            dd.findElement(By.xpath("//ul[@class = 'chosen-results']/li[text()='" + value + "']")).click();
//            Thread.sleep(2000);
//        } catch (ElementClickInterceptedException e) {
//            driver.findElement(By.xpath("//input[contains(@aria-label, '" + dropdown + "')]")).sendKeys(value, Keys.ARROW_DOWN, Keys.ENTER);
//            Thread.sleep(2000);
//        }
//        //ul[@class = 'chosen-results']/li[text()='United Kingdom, not otherwise specified']
    }
    

    
    public void selectDropDownByVisisbleTextFromList(String dropdown, String value) throws InterruptedException {
       Select dd = new Select(driver.findElement(By.xpath("//p[contains(text(),'" + dropdown + "')]/parent::div//select[contains(@id,'SPLITDATE_D')]")));
        //WebElement attr = dd.findElement(By.tagName("a"));
       // attr.click();
       // waitForElementToBeClickable(10, dd);
        Thread.sleep(2000);
        try {
        	dd.selectByVisibleText(value);
         //   dd.findElement(By.xpath("//ul[@class = 'chosen-results']/li[text()='" + value + "']")).click();
            Thread.sleep(2000);
        } catch (ElementClickInterceptedException e) {
            driver.findElement(By.xpath("//input[contains(@aria-label, '" + dropdown + "')]")).sendKeys(value, Keys.ARROW_DOWN, Keys.ENTER);
            Thread.sleep(2000);
        }
        //ul[@class = 'chosen-results']/li[text()='United Kingdom, not otherwise specified']
    }

    public void enterPasswordValue(String input, String value) {
        WebElement inputDiv = driver.findElement(By.xpath("//label[contains(text(),'" + input + "')]/parent::div"));
        WebElement inp = inputDiv.findElement(By.tagName("input"));
        inp.sendKeys(value);
    }

    public void uploadPassportFile() {
        File file = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\Files\\upload.txt");
        WebElement fileElement = driver.findElement(By.xpath("//input[@type='file']"));
        fileElement.sendKeys(file.getAbsolutePath());
    }
    public void scrollToTopOfPage(WebElement element){
//        WebDriver driver = new ChromeDriver();
//        JavascriptExecutor jsExecuter = (JavascriptExecutor)driver;
//        jsExecuter.executeScript(window.scrollTo(0,document.body.scrollTop));
        Actions action = new Actions(driver);
        action.moveToElement(element);
    }

}