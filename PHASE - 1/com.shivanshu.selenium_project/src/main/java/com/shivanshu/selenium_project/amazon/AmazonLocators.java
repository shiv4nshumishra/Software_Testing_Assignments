package com.shivanshu.selenium_project.amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class AmazonLocators {
	static WebDriver driver = null;

	public static void main(String[] args) throws InterruptedException {

		// step1: domain url & driver path
		String siteUrl = "https://www.amazon.in";
		String driverPath = "Drivers/msedgedriver.exe";

		// step2: system properties for selenium dirver
		System.setProperty("webdriver.edge.driver", driverPath);

		// step3: instantiate selenium webdriver
		WebDriver driver = new EdgeDriver();

		// step4: launch browser
		driver.get(siteUrl);

		testSearch();
		
		Thread.sleep(2000);
		
		driver.close();
	}

	private static void testSearch() throws InterruptedException {

		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		searchBox.sendKeys("iPhone 13");
		searchBox.submit();

		Thread.sleep(2000);
		
		String expectedTitle = "Amazon.in : iPhone 13";
		String actualTitle = driver.getTitle();

		if (expectedTitle.equals(actualTitle)) {
			System.out.println("Test is Passed !");
		} else {
			System.out.println("Test is Failed !");
		}

		System.out.println("Expected Title : " + expectedTitle);
		System.out.println("Actual Title : " + actualTitle);
	}

}
