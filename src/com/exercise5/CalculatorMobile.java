package com.exercise5;

import org.testng.annotations.Test;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class CalculatorMobile extends TestCommands {
	 AppiumDriver driver;
	 
	 
	 @Parameters({"browser", "platform","version", "timeout","device_name"})

 
  @BeforeMethod
  public void beforeMethod(String browser, String platform,String version,String timeout,String device_name) throws Exception {
	 
  	DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
  	
	//desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
  	desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME, browser);
  //	desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
  	desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platform);
  	
  	//desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.1.1");
  	desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, version);
  	//desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "300");
  	
  	desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, timeout);
  	
  	//desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
  	desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, device_name);
  	
  	URL url = new URL("http://127.0.0.1:4723/wd/hub");
  	driver = new AndroidDriver(url, desiredCapabilities);
  	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }
  

  @DataProvider
  public Object[][] dp() {
	 return new Object[][] {
		  new Object[] {"5","200","10"},
    };
  }
  
  
  @Test(dataProvider = "dp")
  public void test002(String input1, String input2, String expected) throws Exception {
	    driver.get("https://www.calculator.net/");
	    
	   
	    driver.findElement(By.xpath("//a[text()='Math']")).click();
	  //  driver.scrollTo("Percentage Calculator");
	    driver.findElement(By.xpath("//a[text()='Percentage Calculator']")).click();
	    driver.findElement(By.xpath("//input[@id='cpar1']")).click();
	    driver.findElement(By.xpath("//input[@id='cpar1']")).clear();
	    driver.findElement(By.xpath("//input[@id='cpar1']")).sendKeys(input1);
	    driver.findElement(By.xpath("//input[@id='cpar2']")).click();
	    driver.findElement(By.xpath("//input[@id='cpar2']")).clear();
	    driver.findElement(By.xpath("//input[@id='cpar2']")).sendKeys(input2);
	    driver.findElement(By.xpath("(//input[@value='Calculate'])[1]")).click();
	    
	    assertEquals(driver.findElement(By.xpath("//p[@class='verybigtext']//b")).getText(),expected);
	  }
  
  //public void test001(String percentage, String value, String expected) {
	 // public void testCase() {
	// open(driver,"https://www.calculator.net/" );
	  
	 //driver.scrollTo(0, 100);
	 //driver.scrollTo("Percentage Calculator");
	  //CalculateM calM = new CalculateM  ();
		// calM.navigateToPercCalcPage(driver);
		 
		 
		// Calculatepercentage calpercent= new Calculatepercentage();
		// calM.calculatePercent(driver, percentage, value);
		 

		 //calM.verifyResults(driver,expected);
	  
	    	 //driver.get("https://www.calculator.net/");
	         //driver.findElement(By.id("searchInput")).sendKeys("Selenium");     
	         //driver.findElement(By.name("go")).click();   
	         //String searchResult = driver.findElement(By.xpath("//h1[@id='section_0']")).getText();
	         //Assert.assertTrue("Selenium".equals(searchResult.trim()));
  //}

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }
  }



