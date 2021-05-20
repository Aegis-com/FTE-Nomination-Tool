package fte.testrunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
features = "src\\test\\resources\\Features\\Nomination.feature", 
glue =  {"fte.testcases", "fte.hooks"}, 
plugin = { "pretty",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"timeline:test-output-thread/" }, 
monochrome = true,
dryRun = false

)

public class Runner {

}
