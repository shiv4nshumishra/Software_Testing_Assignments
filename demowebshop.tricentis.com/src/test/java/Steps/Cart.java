package Steps;

import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import Pages.CartPage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Cart {
	private static final Logger logger = LogManager.getLogger(Cart.class);
	
	WebDriver driver = new ChromeDriver();
	CartPage cart = new CartPage(driver);

	@Given("User navigates to the URL")
	public void userNavigatesToURL() {
		logger.info("Navigating to the URL");
		driver.manage().window().maximize();
		cart.navigateToURL("http://demowebshop.tricentis.com");
	}

	@When("User performs the login process")
	public void userPerformsLoginProcess() {
		logger.info("Performing the login process");
		cart.clickLoginLink();
		cart.performLogin("iamalexanderwho@gmail.com", "12345678");
	}

	@Then("Validate the login is successful")
	public void validateLoginProcess() {
		logger.info("Validating the login process");
		String e1 = driver.getTitle();
		String e2 = "Demo Web Shop";
		Assert.assertEquals(e2, e1);
	}

	@And("User clicks on book menu")
	public void Userclickbookmenu() throws InterruptedException {
		Thread.sleep(2000);
		logger.info("Clicking on the book menu");
		cart.clickbookmenu();
	}

	@Then("User validates whether all books have addtocart button")
	public void validateCartButtonForAllBooks() throws InterruptedException {
		logger.info("Validating add to cart buttons for all books");

		int numberOfProducts = 6; // Adjust the number based on your actual scenario
		boolean overallResult = true;

		for (int i = 1; i <= numberOfProducts; i++) {
			cart.clickIconlists(i);

			String buttonxpath = "//input[@class='button-1 add-to-cart-button']";

			try {
				Assert.assertTrue(isElementPresentByXPath(driver, buttonxpath), "Button is present in product" + i);
				System.out.println("Button is present in product" + i);
			} catch (AssertionError e) {
				System.out.println("Button is not present product" + i);
				captureScreenshot(driver, "screenshot" + i + ".png");

				overallResult = false; // Mark the scenario as failed
				// Continue to the next iteration even after a failure
			} finally {
				try {
					driver.navigate().back();
				} catch (Exception e) {
					// Handle any exception that may occur during navigation back
				}
			}
		}
		// Check overall result and fail the scenario if needed
		if (!overallResult) {
			Assert.fail("Scenario failed - Some products do not have the 'Add to Cart' button.");
		}
	}
	
	@And("User add third book to cart")
	public void addthirdbooktocart() throws InterruptedException {
		logger.info("Adding the third book to the cart");
		cart.Iconlists3();
		cart.validatebutton();
		Thread.sleep(2000);
		cart.shoppingcart();
	}
	
	@Then("Validate the third book is successfully added to the cart")
	public void validatethirdbook() throws InterruptedException {
		Thread.sleep(2000);
		logger.info("Validating the third book is successfully added to the cart");
		String Shopingproduct = "//tbody[1]//td[@class='product']//a[text()='Fiction']";
		if (isElementPresentByXPath(driver, Shopingproduct)) {
			System.out.println("Third product added to cart");
			System.out.println("AddToCart Button is clickable");
		} else {
			System.out.println("Cart is empty");
			Assert.fail("Validation failed: Third product not added to cart");
		}

		WebElement table = driver.findElement(By.xpath("//table[contains(@class,'cart')][1]"));
		java.util.List<WebElement> checkboxes = table.findElements(By.xpath(".//td/input[@type='checkbox']"));
		for (WebElement checkbox : checkboxes) {
			checkbox.click();
		}
		cart.shoppingpro();
	}
	
	@And("User adds any 3 products to the cart")
	public void addanythreeproducts() {
		logger.info("Adding any 3 products to the cart");
		cart.Iconlists1();
		cart.validatebutton();
		driver.navigate().back();

		cart.Iconlists3();
		cart.validatebutton();
		driver.navigate().back();

		cart.Iconlists5();
		cart.validatebutton();
		driver.navigate().back();
	}
	
	@And("User deletes any two products from the cart")
	public void deletetwoproducts() throws InterruptedException {
		logger.info("Deleting any two products from the cart");
		Thread.sleep(2000);
		cart.shoppingcart();
		WebElement table = driver.findElement(By.xpath("//table[contains(@class,'cart')][1]"));
		java.util.List<WebElement> checkboxes = table.findElements(By.xpath(".//td/input[@type='checkbox']"));
		for (int i = 0; i < Math.min(2, checkboxes.size()); i++) {
			checkboxes.get(i).click();
		}
		cart.shoppingpro();
	}
	
	@Then("Validate the cart after deleting the products")
	public void validateproductafterdelete() throws InterruptedException {
		logger.info("Validating the cart after deleting the products");
		Thread.sleep(2000);
		WebElement table = driver.findElement(By.xpath("//table/tbody"));
		int rowCount = table.findElements(By.tagName("tr")).size();
		if (rowCount == 1) {
			System.out.println("Validation passed: Only one product in the cart.");
		} else {
			System.out.println("Validation failed: Multiple product in the cart.");
		}
		driver.quit();
	}
	
	private static boolean isElementPresentByXPath(WebDriver driver, String xpath) {
		return !driver.findElements(By.xpath(xpath)).isEmpty();
	}
	
	private static void captureScreenshot(WebDriver driver, String fileName) {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		java.io.File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
		java.io.File destinationFile = new java.io.File("D:\\demowebshop.tricentis.com\\ScreenShots\\Cart\\" + fileName);
		try {
			FileUtils.copyFile(sourceFile, destinationFile);
			System.out.println("Screenshot captured: " + destinationFile);
		} catch (IOException e) {
			System.out.println("Unable to capture screenshot: " + e.getMessage());
		}
	}
	
	@After
	public void quitBrowserSession() {
		driver.quit();
	}
}
