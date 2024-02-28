package pages;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import utilities.ExcelUtility;

@Listeners(utilities.MyListener.class)
public class LoginPageTest {

	String siteUrl = "https://demowebshop.tricentis.com/login";
	String driverPath = "drivers/windows/chromedriver.exe";
	WebDriver driver;
	WebDriverWait wait;

	@BeforeMethod
	public void setUp() {
		// step2: set system properties for selenium dirver
		System.setProperty("webdriver.chrome.driver", driverPath);
		// step3: instantiate selenium webdriver
		driver = new ChromeDriver();
		// step4: launch browser
		driver.get(siteUrl);
	}

	@AfterMethod
	public void cleanUp(ITestResult result) throws IOException {
		if (ITestResult.FAILURE == result.getStatus()) {
			File fileName = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(fileName, new File("D:\\GIT\\A.MLA.T\\SeleniumS2\\S2\\Screenshots\\TestCaseFailed.png"));
		}
		// driver.quit(); // the quit() method closes all browser windows and ends the
		// WebDriver session.
		driver.close(); // the close() closes only the current window on which
	}

	@Test(dataProviderClass = ExcelUtility.class, dataProvider = "xlxsDataProvider")
	public void LoginPagelinkTest(String Username, String Password) throws InterruptedException, IOException {

		driver.manage().window().maximize();

		driver.findElement(By.id("Email")).sendKeys(Username);
		driver.findElement(By.id("Password")).sendKeys(Password);

		driver.findElement(By.id("RememberMe")).click();
		driver.findElement(
				By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[5]/input"))
				.click();

		Assert.assertTrue(driver
				.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[3]/div/div/div[2]/div[1]/h2")) != null);

		// driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a")).click();

		Thread.sleep(1000);

	}
}
