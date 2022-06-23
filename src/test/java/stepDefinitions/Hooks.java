package stepDefinitions;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import base.BasePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.util.Collection;

public class Hooks extends BasePage {
	@Before
	public void beforeScenario(Scenario scenario) {
		Collection<String> tagNames = scenario.getSourceTagNames();
		if(tagNames.contains("@NoBrowser"))
			return;
		BasePage.setup(tagNames);
	}

	@After
	public void takeScreenshot(Scenario scenario) {
		Collection<String> tagNames = scenario.getSourceTagNames();
		if(tagNames.contains("@NoBrowser"))
			return;
		if(scenario.isFailed()) {
			try {
				final byte[] screenshot= ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				String testName=scenario.getName();
				scenario.attach(screenshot, "image/png", testName);
			}catch(WebDriverException wde) {
				System.err.println(wde.getMessage());
			}catch(ClassCastException cce) {
				cce.printStackTrace();
			}
		}
	BasePage.tearDown();
	}
}
