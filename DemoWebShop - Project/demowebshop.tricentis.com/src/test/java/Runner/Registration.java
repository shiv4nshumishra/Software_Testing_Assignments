package Runner;

import org.junit.runner.RunWith;
import org.testng.annotations.Listeners;

import TestNGListners.CucumberExtentReportListener;
import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(publish = true, features = {
		"D:\\demowebshop.tricentis.com\\src\\test\\java\\Features\\RegistrationFeature.feature" }, glue = {
				"Steps" }, dryRun = false, tags = "@RegistrationTest", plugin = { "pretty", "html:target/cucumberreport_Registration.html",
						"json:target/cucumber.json", "junit:target/xmlReport.xml",
						"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:\", \"timeline:test-output-thread/",
						"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }, monochrome = true)
@Listeners(CucumberExtentReportListener.class)
public class Registration extends AbstractTestNGCucumberTests {
}
