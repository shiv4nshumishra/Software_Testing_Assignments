package com.shivanshu.selenium_project.amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class AmazonHomepage {
	
	public static void main(String[] args){

		// step1: domain url & driver path
		String siteUrl = "https://www.amazon.in";
		String driverPath = "Drivers/msedgedriver.exe";

		// step2: system properties for selenium dirver
		System.setProperty("webdriver.edge.driver", driverPath);

		// step3: instantiate selenium webdriver
		WebDriver driver = new EdgeDriver();

		// step4: launch browser
		driver.get(siteUrl);
		
	}
}
