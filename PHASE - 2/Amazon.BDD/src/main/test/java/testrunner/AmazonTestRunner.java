package testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features/amazon-product-search2.feature", 
	glue = {"stepdefinitions"})
public class AmazonTestRunner {

}
