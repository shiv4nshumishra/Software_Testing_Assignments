package com.simplilearn.seleniumtest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LauchFireFoxTest {

	public static void main(String[] args) {
		
		// step1: formulate a test domain url & driver path
		String siteUrl = "https://www.google.com/";
		String driverPath = "drivers/windows/geckodriver.exe";
		
		// step2: set system properties for selenium dirver
		System.setProperty("webdriver.gecko.driver", driverPath);
		
		// step3: instantiate selenium webdriver
		WebDriver driver = new FirefoxDriver();
		
		// step4: launch browser
		driver.get(siteUrl);
		
		// step5 : Evaluate the Test
		
		// step6: Close browser
		driver.close();
	}
}
