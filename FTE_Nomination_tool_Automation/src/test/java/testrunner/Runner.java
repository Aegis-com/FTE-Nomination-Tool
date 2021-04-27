package testrunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/resources/Features" }, 
glue = { "src/test/java/testrunner","src/test/java/hooks" }, 
plugin = { "pretty",
"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", 
"timeline:test-output-thread/"},
monochrome = true
)

public class Runner {

}
