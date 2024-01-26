package TestNG;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationPage {
	// step1: formulate a test domain url & driver path
		String siteUrl = "http://localhost:9010/register";
		String driverPath = "Drivers/msedgedriver.exe";
		WebDriver driver;
		WebDriverWait wait;

		@BeforeMethod
		public void setUp() {

			// step2: set system properties for selenium dirver
			System.setProperty("webdriver.edge.driver", driverPath);

			// step3: instantiate selenium webdriver
			driver = (WebDriver) new EdgeDriver();

			// step4: launch browser
			driver.get(siteUrl);
		}

		@AfterMethod
		public void cleanUp() {
			driver.quit(); // the quit() method closes all browser windows and ends the WebDriver session.
			driver.close(); // the close() closes only the current window on which
		}

		@Test(description = "Test Registration Page")
		public void nameBox() throws InterruptedException {
			WebElement box = driver.findElement(By.id("name"));

			System.out.println("Is link loaded :: " + box.isDisplayed());
			System.out.println("Is link is enabled :: " + box.isEnabled());

			box.click();

			String expectedTitle = "";
			String actualTitle = driver.getTitle();
			assertEquals(actualTitle, expectedTitle);
		}
		
		@Test(description = "Test Registration Page")
		public void emailBox() throws InterruptedException {
			WebElement box = driver.findElement(By.id("email"));

			System.out.println("Is link loaded :: " + box.isDisplayed());
			System.out.println("Is link is enabled :: " + box.isEnabled());

			box.click();

			String expectedTitle = "";
			String actualTitle = driver.getTitle();
			assertEquals(actualTitle, expectedTitle);
		}
		
}
