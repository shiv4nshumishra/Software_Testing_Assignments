package Steps;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.SearchPage;
import Utilities.Xls_DataProvider_search;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Search {
	Logger logger = LogManager.getLogger(Search.class);

	private WebDriver driver;
	private SearchPage Page_search;

	@Before("@SearchTest")
	public void setUp() {
		logger.info("Setting up WebDriver and Page_search.");
		driver = new ChromeDriver();
		Page_search = new SearchPage(driver);
		driver.manage().window().maximize();
	}

	@Given("the user is on the search page")
	public void userIsOnSearchPage() {
		logger.info("Navigating to the search page.");
		Page_search.navigateToURL("http://demowebshop.tricentis.com");
		Assert.assertEquals(driver.getTitle(), "Demo Web Shop", "User is not on the search tab");
	}

	@When("the user clicks the search button")
	public void userClicksSearchButton() throws InterruptedException {
		logger.info("Clicking the search button.");
		Page_search.searchbtn();
		Thread.sleep(2000);
	}

	@Then("the user dismisses the pop-up")
	public void userDismissesPopup() {
		logger.info("Dismissing the pop-up.");
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		System.out.println(alertText);
		alert.dismiss();
	}

	@When("the user performs a search with data from Excel sheet {string}")
	public void userPerformsSearchWithDataFromExcel(String search_term) throws IOException, InterruptedException {
		String sheetName = "Sheet1"; // Specify the sheet name from your Excel file
		String[] searchTerms = Xls_DataProvider_search.getSearchData(sheetName);
		logger.info("Search terms from Excel sheet: " + Arrays.toString(searchTerms));
		System.out.println("Search terms from Excel sheet: " + Arrays.toString(searchTerms));
		for (String currentterm : searchTerms) {
			Page_search.search_placeholder(currentterm); // Here, you pass the data to the method
			validateSearchResults(currentterm);
		}
	}

	@Test
	@Then("the search results should be displayed for {string}")
	public void validateSearchResults(String search_term) throws IOException {

		By noResultsMessage = By.xpath("//strong[@class='result' and contains(text(), 'No products were found')]");

		boolean isNoResultsMessageDisplayed = driver.findElements(noResultsMessage).size() > 0;
		
		try {
			if (isNoResultsMessageDisplayed) {
				Assert.fail("No result displayed for " + search_term);
			}
			else {
				logger.info("Search results displayed for: " + search_term);
				System.out.println("Search results displayed for: " + search_term);
				return; // Break out of retry loop if successful
			}
		}

		catch (AssertionError e) {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File sourceFile = ts.getScreenshotAs(OutputType.FILE);
			File destinationFile = new File("D:\\demowebshop.tricentis.com\\ScreenShots\\Search\\" +sourceFile);
			System.out.println("Screenshot captured: " + destinationFile);
			logger.error("Screenshot captured: " + destinationFile);
		}
	}
}