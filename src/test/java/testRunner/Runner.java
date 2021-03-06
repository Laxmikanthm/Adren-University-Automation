package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
					features = { "src/test/java/features" }, glue = { "stepDefinitions" },
					plugin = { "pretty","json:target/cucumber-reports/report.json",
								"html:target/cucumber-reports/report.html" }, 
					tags = "@NoBrowserforCreateUser", dryRun = false, monochrome = true, publish = true)

public class Runner {
	

}
