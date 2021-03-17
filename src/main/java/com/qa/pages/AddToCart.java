package com.qa.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import utilities.Utility;

public class AddToCart {
	
	WebDriver driver;
	Properties prop;
	
	@Test
	public void AddToCartItem() throws FileNotFoundException, Exception {
		
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
		
	  driver.findElement(By.xpath("//span[text()='Shopping cart']")).click();
	  
	 // driver.findElement(By.xpath("//input[@name='removefromcart']")).click();
	  
	  //driver.findElement(By.name("updatecart")).click();
	  
	  driver.findElement(By.xpath("//ul[@class='top-menu']//li//a[@href='/books']")).click();
	  
	  driver.findElement(By.xpath("//img[@alt='Picture of Computing and Internet']")).click();
	  
	  driver.findElement(By.id("addtocart_13_EnteredQuantity")).clear();
	  
	  driver.findElement(By.id("addtocart_13_EnteredQuantity")).sendKeys("3");
	  
	  driver.findElement(By.id("add-to-cart-button-13")).click();
	  
	  Thread.sleep(3000);
	  
	  if(driver.getPageSource().contains("The product has been added to your shopping cart")) {
		  
		  System.out.println("test pass....");
		  
	  }else {
		  
		  System.out.println("test fail....");
	  }
	  
	  driver.findElement(By.xpath("//span[text()='Shopping cart']")).click();
	  
	  String subtotal = driver.getPageSource();
	  
	  
	  if(subtotal.contains("30")) {
		  
		  System.out.println("the subtotal is....30");
		  
	  }else {
		  System.out.println("wrong subtotal....");
	  }
	  
	  driver.findElement(By.id("termsofservice")).click();
	  
	  driver.findElement(By.id("checkout")).click();
	  
	  driver.findElement(By.id("Email")).sendKeys(prop.getProperty("username"));
		
	   driver.findElement(By.id("Password")).sendKeys(prop.getProperty("password"));
		
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
	  
	  Select select = new Select(driver.findElement(By.id("billing-address-select")));
	  
	  select.selectByVisibleText("atest dummy,assd,abc 123,Iceland");
	  
	  driver.findElement(By.xpath("//input[@class='button-1 new-address-next-step-button']"
	  		+ "//parent::div[@id='billing-buttons-container']")).click();
	  
	  
	  Select select1 = new Select(driver.findElement(By.id("billing-address-select")));
	  
	  select1.selectByVisibleText("atest dummy,assd,abc 123,Iceland");
	  
	  
	  driver.findElement(By.xpath("//input[@class='button-1 new-address-next-step-button']"
		  		+ "//parent::div[@id='billing-buttons-container']")).click();
	  
	  driver.findElement(By.id("shippingoption_1")).click();
	  
	  driver.findElement(By.xpath("//input[@class='button-1 shipping-method-next-step-button']")).click();
	  
	  driver.findElement(By.id("paymentmethod_0")).click();
	  
	  driver.findElement(By.xpath("//input[@class='button-1 payment-method-next-step-button']")).click();
	  
	  driver.findElement(By.xpath("//input[@class='button-1 payment-info-next-step-button']")).click();
	  
	  driver.findElement(By.xpath("//input[@class='button-1 confirm-order-next-step-button']")).click();
	  
	  if(driver.getPageSource().contains("Your order has been successfully processed!")) {
		  
		  System.out.println("test case pass...");
		  
	  }else {
		  
		  System.out.println("test case fail...");
	  }
	  
	  
	  driver.findElement(By.xpath("//input[@class='button-2 order-completed-continue-button']")).click();
	  
	  
		
	}

}
