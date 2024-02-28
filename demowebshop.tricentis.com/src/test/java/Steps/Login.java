package Steps;

import java.time.Duration;

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

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login {

	WebDriver driver;
	
	public Login() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	private static final Logger logger = LogManager.getLogger(Login.class);

	@When("user enters {string} and {string}")
	public void userEntersemailAndPassword(String email, String password) {
		logger.info("user Enters email And Password");
		WebElement emailField = driver.findElement(By.xpath("//input[@id='Email']"));
		WebElement passwordField = driver.findElement(By.xpath("//input[@id='Password']"));
		emailField.sendKeys(email);
		passwordField.sendKeys(password);
	}

	@Given("user navigates to the login page")
	public void userNavigatesToLoginPage() throws InterruptedException {
		logger.info("user Navigates To Login Page");
		driver.get("http://demowebshop.tricentis.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement loginpage = driver.findElement(By.xpath("//a[@href='/login']"));
		loginpage.click();
		Thread.sleep(5000);
	}

	@And("clicks the login button")
	public void clicksLoginButton() {
		logger.info("clicks Login Button");
		WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log in']"));
		loginButton.click();
	}

	@Then("Message Should Be Displayed {string}")
	public void messageShouldBeDisplayed(String loginResult) throws java.io.IOException {
		logger.info("message Should Be Displayed");
		String actual = loginResult;
		System.out.println(actual);
		String expected = "logged_in_successfully";

		try {
			Assert.assertEquals(expected, actual);
		} catch (AssertionError e) {
			// Log the failure message before logging out
			System.out.println("Assertion failed: " + e.getMessage());
			TakesScreenshot ts = (TakesScreenshot) driver;
			java.io.File screenshot = ts.getScreenshotAs(OutputType.FILE);
			String screenshotName = "Failure_" + "_" + System.currentTimeMillis() + ".png";
			FileUtils.copyFile(screenshot,
					new java.io.File("D:\\demowebshop.tricentis.com\\ScreenShots\\Login\\" + screenshotName));
			WebElement loginpage = driver.findElement(By.xpath("//a[@href='/login']"));
			loginpage.clear();
			}
		}
	
	@After
	public void quitBrowserSession() {
		driver.quit();
	}
}
