package com.shivanshu.selenium_project.amazon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonLogin {
	static WebDriver driver;
	static WebDriverWait wait;
	static EdgeOptions options;
	
	public static void main(String[] args) {

		setUp();

		testFailureLogin();
	}

	public static void setUp() {

		// step1: domain url & driver path
		String siteUrl = "https://www.amazon.in";
		String driverPath = "drivers/msedgedriver.exe";

		// step2: system properties for selenium driver
		System.setProperty("webdriver.edge.driver", driverPath);

		options = new EdgeOptions();
		
		// step3: instantiate selenium webdriver
		driver = new EdgeDriver(options);

		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		
		driver.get(siteUrl);
	}

	public static void testFailureLogin() {

		driver.findElement(By.id("email")).sendKeys("sample@email.com");
		driver.findElement(By.id("pass")).sendKeys("sample-password");
		driver.findElement(By.name("login")).submit();

		// evaluate a failure login test
		WebElement errorMsg = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("#loginform > div:nth-child(12) > div._9ay7")));

		String errorText = "The password that you've entered is incorrect. Forgotten password?";

		if (errorText.equals(errorMsg.getText())) {
			System.out.println("Test is Passed !");
		} else {
			System.out.println("Test is Failed !");
		}

		System.out.println("Expected Error Text : " + errorText);
		System.out.println("Actual Error Text : " + errorMsg.getText());
	}

}
