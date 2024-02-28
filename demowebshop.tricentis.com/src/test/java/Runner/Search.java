package Runner;

import org.junit.runner.RunWith;
import org.testng.annotations.Listeners;

import TestNGListners.CucumberExtentReportListener;
import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(publish = true, features = {
		"D:\\demowebshop.tricentis.com\\src\\test\\java\\Features\\SearchFeature.feature" }, glue = {
				"Steps" }, dryRun = false, tags = "@SearchTest", plugin = { "pretty",
						"html:target/cucumberreport_search.html", "json:target/cucumber.json",
						"junit:target/xmlReport.xml" }, monochrome = true)
@Listeners(CucumberExtentReportListener.class)
public class Search extends AbstractTestNGCucumberTests {
}
