package com.shivanshu.SeleniumWithJUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@DisplayName("Google Homepage Test")
class GoogleTest {

			// step1: formulate a test domain url & driver path
			String siteUrl = "https://www.google.co.in/";
			String driverPath = "drivers/windows/geckodriver.exe";
			WebDriver driver;

			@BeforeEach
			void setUp() throws Exception {

				// step2: set system properties for selenium dirver
				System.setProperty("webdriver.geckodriver.driver", driverPath);

				// step3: instantiate selenium webdriver
				driver = new FirefoxDriver();

				// step4: launch browser
				driver.get(siteUrl);
			}

			@AfterEach
			void tearDown() throws Exception {
				driver.quit(); // the quit() method closes all browser windows and ends the WebDriver session.
			}

			@Test
			@RepeatedTest(value = 3 , name = RepeatedTest.LONG_DISPLAY_NAME)
			@DisplayName("Should validate Google Homepage title")
			void testGoogleHomePageTitle() {
				String expectedTitle = "Google";
				String actualTitle = driver.getTitle();
				assertEquals(actualTitle, expectedTitle);
			}
			
			@Test
			@DisplayName("Should validate Google Homepage source url")
			public void testGoogleHomePageSourceUrl() {
				assertEquals(siteUrl, driver.getCurrentUrl());
			}
			
			@Test
			@DisplayName("Should validate Google Homepage for invalid title")
			public void testGoogleHomePageTitle2() {
				String expectedTitle = "Google";
				String actualTitle = driver.getTitle();
				assertNotEquals(actualTitle, expectedTitle);
			}
}
