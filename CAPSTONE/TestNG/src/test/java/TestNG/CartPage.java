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

public class CartPage {
	// step1: formulate a test domain url & driver path
		String siteUrl = "http://localhost:9010/cart";
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

		@Test(description = "Test Cart Titan, Jaw Titan")
		public void xpathLinkTest() throws InterruptedException {
			WebElement Link = driver.findElement(By.xpath("/html/body/div[2]/div/h1"));

			System.out.println("Is link loaded :: " + Link.isDisplayed());
			System.out.println("Is link is enabled :: " + Link.isEnabled());

			Link.click();

			String expectedTitle = "";
			String actualTitle = driver.getTitle();
			assertEquals(actualTitle, expectedTitle);
		}
}
