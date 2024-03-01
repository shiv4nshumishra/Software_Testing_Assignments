package Runner;

import org.junit.runner.RunWith;
import org.testng.annotations.Listeners;

import TestNGListners.CucumberExtentReportListener;
import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(publish = true, features = {
		"D:\\demowebshop.tricentis.com\\src\\test\\java\\Features\\CheckoutFeature.feature" }, glue = {
				"Steps" }, dryRun = false, tags = "@CheckoutTest", plugin = { "pretty",
						"html:target/cucumberreport_checkout.html", "json:target/cucumber.json",
						"junit:target/xmlReport.xml",
						"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:\", \"timeline:test-output-thread/"

}, monochrome = true)
@Listeners(CucumberExtentReportListener.class)
public class Checkout extends AbstractTestNGCucumberTests {
}
