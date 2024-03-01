package Runner;

import org.junit.runner.RunWith;
import org.testng.annotations.Listeners;

import TestNGListners.CucumberExtentReportListener;
import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(publish = true, features = {
		"D:\\demowebshop.tricentis.com\\src\\test\\java\\Features\\WishListFeature.feature" }, glue = {
				"Steps" }, dryRun = false,tags = "@WishListTest", plugin = { "html:target/Demowebshop_addtowishlist_report.html", "pretty",
						"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
						"timeline:test-output-thread/" }, monochrome = true)
@Listeners(CucumberExtentReportListener.class)
public class WishList extends AbstractTestNGCucumberTests {
}