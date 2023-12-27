package com.shivanshu.SeleniumWithJUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@DisplayName("Facebook Homepage Test")
class FacebookTest {

	 	// step1: formulate a test domain url & driver path
		String siteUrl = "https://www.facebook.com/";
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
		@DisplayName("Should validate Facebook Homepage title")
		void testFacebookHomePageTitle() {
			String expectedTitle = "Facebook - log in or sign up";
			String actualTitle = driver.getTitle();
			assertEquals(actualTitle, expectedTitle);
		}
		
		@Test
		@DisplayName("Should validate Facebook Homepage source url")
		public void testFacebookHomePageSourceUrl() {
			assertEquals(siteUrl, driver.getCurrentUrl());
		}
		
		@Test
		@DisplayName("Should validate Facebook Homepage for invalid title")
		public void testFacebookHomePageTitle2() {
			String expectedTitle = "Facebook-log in or sign up";
			String actualTitle = driver.getTitle();
			assertNotEquals(actualTitle, expectedTitle);
		}
}
