package com.shivanshu.TestNG.amazon;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;

public class Search {
	        // step1: formulate a test domain url & driver path
			String siteUrl = "https://www.amazon.in/";
			String driverPath = "Drivers/msedgedriver.exe";
			WebDriver driver;

		@BeforeClass
		public void beforeClass() {

			// step2: set system properties for selenium dirver
			System.setProperty("webdriver.edge.driver", driverPath);

			// step3: instantiate selenium webdriver
			driver = new EdgeDriver();

			// step4: launch browser
			driver.get(siteUrl);
		}

		@AfterClass
		public void afterClass() {
			driver.quit();
		}

		@Test (description = "Search Why I Am An Athiest")
		public void testSearch1() throws InterruptedException {
			WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
			searchBox.sendKeys("Why I Am An Athiest");
			searchBox.submit();

			// add delay 
			Thread.sleep(1000);
			
			String expectedTitle = "Amazon.in : Why I Am An Athiest";
			String actualTitle = driver.getTitle();
			
			assertEquals(actualTitle, expectedTitle);
		}
		
		@Test (description = "Search The God Delusion")
		public void testSearch2() throws InterruptedException {
			WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
			searchBox.clear();
			searchBox.sendKeys("The God Delusion");
			searchBox.submit();

			// add delay 
			Thread.sleep(1000);
			
			String expectedTitle = "Amazon.in : The God Delusion";
			String actualTitle = driver.getTitle();
			
			assertEquals(actualTitle, expectedTitle);
		}
		
		@Test (description = "Search The Blind Watchmaker")
		public void testSearch3() throws InterruptedException {
			WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
			searchBox.clear();
			searchBox.sendKeys("The Blind Watchmaker");
			searchBox.submit();

			// add delay 
			Thread.sleep(1000);
			
			String expectedTitle = "Amazon.in : The Blind Watchmaker";
			String actualTitle = driver.getTitle();
			
			assertEquals(actualTitle, expectedTitle);
		}
		
		@Test (description = "Search Sapiens")
		public void testSearch4() throws InterruptedException {
			WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
			searchBox.clear();
			searchBox.sendKeys("Sapiens");
			searchBox.submit();

			// add delay 
			Thread.sleep(1000);
			
			String expectedTitle = "Amazon.in : Sapiens";
			String actualTitle = driver.getTitle();
			
			assertEquals(actualTitle, expectedTitle);
		}
}
