package Runner;

import org.junit.runner.RunWith;
import org.testng.annotations.Listeners;
import io.cucumber.junit.Cucumber;
import TestNGListners.CucumberExtentReportListener;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(publish = true, features = {
		"D:\\demowebshop.tricentis.com\\src\\test\\java\\Features\\CartFeature.feature" }, glue = {
				"Steps" }, dryRun = false,tags = "@CartTest",  plugin = { "html:target/Demowebshop_addtocart_report.html", "pretty",
						"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
						"timeline:test-output-thread/" })
@Listeners(CucumberExtentReportListener.class)
public class Cart extends AbstractTestNGCucumberTests {
}
