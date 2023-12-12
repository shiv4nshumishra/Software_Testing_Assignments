package com.shivanshu.simplilearn.p1p1.screenshot;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class screenshot {

	static EdgeDriver driver;
	static WebDriverWait wait;

	public static void main(String[] args) {

		setUp();

		testFailureLogin();
	}

	public static void setUp() {

		String siteUrl = "https://www.flipkart.com";
		String driverPath = "drivers/msedgedriver.exe";

		System.setProperty("webdriver.edge.driver", driverPath);

		driver = new EdgeDriver();

		driver.get(siteUrl);
	}

	public static void testFailureLogin() {

		driver.findElement(By.id("email")).sendKeys("coffee@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("c0ff33");
		driver.findElement(By.name("login")).submit();

		takeScreenShot("flipkart.png");
		
		// evaluate a failure login test
		WebElement errorMsg = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div/div[1]/div/div/div/div/div[1]/div/div[1]/div/div[1]/div[1]/header/div[2]/div[2]/div/a/img")));

		String errorText = "The password that you've entered is incorrect.";

		if (errorText.equals(errorMsg.getText())) {
			System.out.println("Test is Passed !");
		} else {
			System.out.println("Test is Failed !");
		}

		System.out.println("Expected Error Text : " + errorText);
		System.out.println("Actual Error Text : " + errorMsg.getText());
	}
	
	public static void takeScreenShot(String fileName) {
		TakesScreenshot tsc = (TakesScreenshot) driver ;

		File src = tsc.getScreenshotAs(OutputType.FILE);

		try {
			FileHandler.copy(src, new File("output-screenshot\\"+fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
