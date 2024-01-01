package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features/static-login.feature", 
	glue = {"StepDefinitions"},
	plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/html/ExtentReport.html"})
public class StaticLoginTestRunner {

}
