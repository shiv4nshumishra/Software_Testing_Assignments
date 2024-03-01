package Steps;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import Pages.SubscriptionPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Subscription {

	WebDriver driver = new ChromeDriver();

	SoftAssert s = new SoftAssert();
	private static final Logger logger = LogManager.getLogger(Subscription.class);
	SubscriptionPage snl = new SubscriptionPage(driver);

	@Given("I am on DemoWebShop Homepage launching url")
	public void i_am_on_demo_web_shop_homepage_launching_url() {
		logger.info("Navigating to the URL");
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
	}

	@When("I click on login link")
	public void i_click_on_login_link() throws InterruptedException {
		logger.info("Clicking on login link");
		snl.Click_LoginLink();
	}

	@Then("I will be on Login Page and Capture the title of the page")
	public void i_will_be_on_login_page_and_capture_the_title_of_the_page() throws InterruptedException {
		driver.getTitle();
		System.out.println("title of the is page is : " + driver.getTitle());
	}

	@Then("I entered email id on the page")
	public void i_entered_email_id_on_the_page() throws InterruptedException {
		logger.info("Entering the Email id");
		// Thread.sleep(2000);
		snl.give_email("iamalexanderwho@gmail.com");
	}

	@Then("I entered password on the page")
	public void i_entered_password_on_the_page() throws InterruptedException {
		logger.info("Entering the Password");
		// Thread.sleep(2000);
		snl.give_password("12345678");
	}

	@Then("I click on Login button")
	public void i_click_on_submit_button() throws InterruptedException {
		logger.info("Clicking on login button");
		// Thread.sleep(2000);
		snl.Click_Login();
	}

	@Then("I click on sign up for our newsletter {string}")
	public void i_click_on_sign_up_for_our_newsletter(String signup_emailid) throws InterruptedException {
		logger.info("Entering the signup mail id");
		Thread.sleep(2000);
		snl.give_signup_emailid(signup_emailid);
	}

	@Then("I click on Subscribe")
	public void i_click_on_subscribe() throws InterruptedException {
		logger.info("Clicking on Subscribe");
		Thread.sleep(2000);
		snl.Click_Signup();
	}

	@Then("i get the result block")
	public void i_get_the_result_block() throws InterruptedException, IOException {
		Thread.sleep(1000);
		String actualResult = driver.findElement(By.id("newsletter-result-block")).getText();
		System.out.print(actualResult);
		String expectedResult = "Thank you for signing up! A verification email has been sent. We appreciate your interest.";

		try {
			Assert.assertEquals(expectedResult, actualResult);
		} catch (AssertionError e) {
			// Log the failure message before logging out
			System.out.println("Assertion failed: " + e.getMessage());
			TakesScreenshot ts = (TakesScreenshot) driver;
			File screenshot = ts.getScreenshotAs(OutputType.FILE);
			String screenshotName = "Failure_" + "_" + System.currentTimeMillis() + ".png";
			FileUtils.copyFile(screenshot,
					new File("D:\\demowebshop.tricentis.com\\ScreenShots\\Subscription\\" + screenshotName));
			i_logout();
		}
	}

	@Then("I logout")
	public void i_logout() throws InterruptedException {
		logger.info("Clicking on logout");
		snl.Click_Logout();
		driver.quit();
	}

}
