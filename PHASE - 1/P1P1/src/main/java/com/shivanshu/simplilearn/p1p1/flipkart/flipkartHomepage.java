package com.shivanshu.simplilearn.p1p1.flipkart;

import org.openqa.selenium.edge.EdgeDriver;

public class flipkartHomepage {

	public static void main(String[] args) {

		String siteUrl = "https://www.flipkart.com";
		String driverPath = "drivers/msedgedriver.exe";

		System.setProperty("webdriver.edge.driver", driverPath);

		EdgeDriver driver = new EdgeDriver();

		driver.get(siteUrl);
		
		try {
			if(siteUrl.equals(driver.getCurrentUrl())) {
				System.out.println("Test is Passed !");
			} else {
				System.out.println("Test is Failed !");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Expected Url :: " + siteUrl);
		System.out.println("Actual Url :: " + driver.getCurrentUrl());
		
		
		// step6: Close browser
		driver.close();
	}
}
