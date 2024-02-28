package Steps;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.CheckoutPage;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Checkout {
	private static final Logger logger = LogManager.getLogger(Checkout.class);

	WebDriver driver;
	CheckoutPage web;
	public Checkout() {
		driver=new ChromeDriver();
		web=new CheckoutPage(driver);	
	}
	
	@Given("User navigates to the URL demowebshop tricentis")
	
	public void user_navigates_to_the_url_demowebshop_tricentis() {
		logger.info("User navigates to the URL"); 
		driver.manage().window().maximize();
	web.navigateToURL("http://demowebshop.tricentis.com");
	}

	@When("User performs the login process in demowebshop")
	public void user_performs_the_login_process_in_demowebshop() {
		logger.info("User performs the login process"); 
		web.clickLoginLink();
		web.performLogin("supriyabc123@gmail.com", "sup123");
	}
	

	@Then("Validate the login is successful or not in demowebshop")
	public void validate_the_login_is_successful_or_not_in_demowebshop() throws InterruptedException {
		logger.info("Validate the login is successful");
		Thread.sleep(2000);
		String e1 = driver.getTitle();
		Thread.sleep(2000);
		String e2 = "Demo Web Shop";
		Assert.assertEquals(e1, e2);
	}
	
    @Given("User clicks on book menu in demowebshop")
    public void user_clicks_on_book_menu_in_demowebshop() throws InterruptedException {
    	logger.info("User clicks on book menu");
    	Thread.sleep(2000);
    	web.clickbookmenu();
    }
    
    @Given("User add third book to cart in demowebshop")
	public void user_add_third_book_to_cart_in_demowebshop() throws InterruptedException {
    	logger.info("User add third book to cart");
		Thread.sleep(2000);
		web.Iconlists3();
		web.clickAddToCartButton();
		web.shoppingcart();
	}
	
	@When("User clicks on the checkbox in demowebshop")
	public void user_clicks_on_the_checkbox_in_demowebshop() throws InterruptedException {
		logger.info("User clicks on the checkbox");
		Thread.sleep(1000);
	    web.checkbox();
	}
	
	@Then("User should able to checkout in demowebshop")
	public void user_should_able_to_checkout_in_demowebshop() throws InterruptedException {
		logger.info("User should able to checkout");
		Thread.sleep(2000);
		web.checkoutButton();
	}

	@Then("billing information")
	public void billing_information() throws InterruptedException {
		logger.info("billing information");
	    web.ContinueButton();
	}
	
	@Then("enters valid shipping")
	public void enters_valid_shipping() throws InterruptedException {
		logger.info("enters valid shipping");
		Thread.sleep(2000);
		web.shipButton();    
	}
	
	@Then("select shipping type")
	public void select_shipping_type() throws InterruptedException {
		logger.info("select shipping type");
		Thread.sleep(2000);
		web.ground();
		web.clickcontinue1();
	}
	
	@Then("selects a payment method")
	public void selects_a_payment_method1() throws InterruptedException {
		logger.info("selects a payment method");
		web.payment();
		Thread.sleep(1000);
		web.clickcontinue2();
	}
	
	@Then("completes the purchase cod")
	public void completes_the_purchase_cod() throws InterruptedException {
	web.clickcontinue3();
	Thread.sleep(2000);
	web.conform();
	Thread.sleep(2000);
	}
	
	@Then("the user should see order confirmation")
	public void the_user_should_see_order_confirmation() throws InterruptedException {
	  Thread.sleep(2000);
	  System.out.println(web.thanku());
	  driver.close();
	}
	
	@Then("enters payment details")
	public void enters_payment_details() throws InterruptedException {
		logger.info("enters payment details");
		Thread.sleep(2000);
		web.CreditCard("supr");
		web.cardnum("1111222244");
		web.cardcode("163");
	     
	}
	
	@Then("completes the purchase")
	public void completes_the_purchase() throws InterruptedException {
		logger.info("completes the purchase");
		Thread.sleep(2000);
		web.clickcontinue3();
		Thread.sleep(2000);
		web.error();
	    captureScreenshot(driver, "Failed1.png");
		System.out.print(web.error);
		Thread.sleep(3000);
		driver.close();
		
	}

	@Then("the user should see a confirmation message")
	public void the_user_should_see_a_confirmation_message() throws InterruptedException {
		logger.info("the user should see a confirmation message");
		Thread.sleep(2000);
	    web.conform();
		driver.quit();
	}

	private static void captureScreenshot(WebDriver driver, String fileName) {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
		File destinationFile = new File("D:\\demowebshop.tricentis.com\\ScreenShots\\Checkout\\");
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
