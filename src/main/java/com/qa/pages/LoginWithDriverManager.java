package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginWithDriverManager {
	
	
	WebDriver driver;
	@Test
	
	public void login() {
		
	WebDriverManager.chromedriver().setup();
		
    driver = new ChromeDriver();
	    
	   // System.setProperty("webdriver.chrome.driver", "D:\\Chrome88\\chromedriver.exe");
	    //driver = new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/dashboard");
		
	}
	
	
	

}
