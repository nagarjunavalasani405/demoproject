package com.qa.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utilities.Utility;

public class Login {
	
	WebDriver driver;
	
	Properties prop;
	
	@BeforeMethod
	
	public void setUp() throws FileNotFoundException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Chrome88\\chromedriver.exe");
	    driver = new ChromeDriver();
	    
	    prop = new Properties();
	    
	 
	   FileInputStream imp = new FileInputStream("C:\\workspace\\demoproject\\src\\main\\java\\configproperties\\config.properties");
		
	    
	   try {
		   
		prop.load(imp);
		
	} catch (IOException e) {
		
		e.printStackTrace();
	}
	   
	  driver.manage().window().maximize();
	  driver.manage().timeouts().pageLoadTimeout(Utility.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	  driver.manage().timeouts().implicitlyWait(Utility.IMPLICT_WAIT, TimeUnit.SECONDS);
	   
	  driver.get(prop.getProperty("url")); 
	
	   
	}
	
	@Test
	public void login() {
		
		driver.findElement(By.xpath("//a[text()='Log in']")).click();
		
		if(driver.getPageSource().contains("Welcome, Please Sign In!")) {
			
			System.out.println("Test case pass.....");
			
		}
		else {
			
			System.out.println("Test case Fail.....");
		}
		
		
		driver.findElement(By.id("Email")).sendKeys(prop.getProperty("username"));
		
		driver.findElement(By.id("Password")).sendKeys(prop.getProperty("password"));
		
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		
		if(driver.getPageSource().contains("atest@gmail.com")) {
			
			System.out.println("test pass....text is..atest@gmail.com");
		}
		else {
			System.out.println("test case fail...");
		}
		
		
	}
	@AfterMethod
	public void teaeDown() {
		
		driver.quit();
	}
	
	

}
