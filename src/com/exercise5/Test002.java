package com.exercise5;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class Test002 {
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
		  new Object[] {"dinu92","dinu92","London","December","30", "New York", "December", "31","Blue Skies Airlines","New York to London", "London to New York"},
  };
}


  @Test(dataProvider = "dp")
  public void test003(String username, String passowrd, String port1, String month1,String date1, String port2, String month2, String date2 , String flight, String expected1, String expected2) throws Exception {
	  
	    driver.get("http://newtours.demoaut.com/");
	    driver.findElement(By.xpath("//input[@name='userName']")).click();
	    driver.findElement(By.xpath("//input[@name='userName']")).clear();
	    driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(username);
	    driver.findElement(By.xpath("//input[@type='password']")).clear();
	    driver.findElement(By.xpath("//input[@type='password']")).sendKeys(passowrd);
	    driver.findElement(By.xpath("//input[@value='Login']")).click();
	    
	   driver.findElement(By.xpath("//select[@name='fromPort']")).click();
	    new Select(driver.findElement(By.xpath("//select[@name='fromPort']"))).selectByVisibleText(port1);

	    driver.findElement(By.xpath("//select[@name='fromMonth']")).click();
		   // new Select(driver.findElement(By.xpath("toMonth"))).selectByVisibleText("December");
		new Select(driver.findElement(By.xpath("//select[@name='fromMonth']"))).selectByVisibleText(month1);
		    
		
		driver.findElement(By.xpath("//select[@name='fromDay']")).click();
	    //new Select(driver.findElement(By.xpath("toDay"))).selectByVisibleText("2");
	    new Select(driver.findElement(By.xpath("//select[@name='fromDay']"))).selectByVisibleText(date1);
	   // driver.findElement(By.xpath("toDay")).click();
	    
	   
	    driver.findElement(By.xpath("//select[@name='toPort']")).click();
	    new Select(driver.findElement(By.xpath("//select[@name='toPort']"))).selectByVisibleText(port2);
	    //new Select(driver.findElement(By.xpath("toPort"))).selectByVisibleText("New York");
	    //driver.findElement(By.xpath("toPort")).click();
	    
	    driver.findElement(By.xpath("//select[@name='toMonth']")).click();
	   // new Select(driver.findElement(By.xpath("toMonth"))).selectByVisibleText("December");
	    new Select(driver.findElement(By.xpath("//select[@name='toMonth']"))).selectByVisibleText(month2);
	    
	    //driver.findElement(By.xpath("toMonth")).click();
	    
	    driver.findElement(By.xpath("//select[@name='toDay']")).click();
	    //new Select(driver.findElement(By.xpath("toDay"))).selectByVisibleText("2");
	    new Select(driver.findElement(By.xpath("//select[@name='toDay']"))).selectByVisibleText(date2);
	   // driver.findElement(By.xpath("toDay")).click();
	    
	    driver.findElement(By.xpath("//select[@name='airline']")).click();
	    new Select(driver.findElement(By.xpath("//select[@name='airline']"))).selectByVisibleText(flight);
	    //new Select(driver.findElement(By.xpath("airline"))).selectByVisibleText("Blue Skies Airlines");
	   // driver.findElement(By.xpath("airline")).click();
	    
	    driver.findElement(By.xpath("//input[@name='findFlights']")).click();
	    
	    driver.findElement(By.xpath("//table[2]/tbody/tr/td/table")).click();
	    //assertEquals(driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='RETURN'])[1]/following::font[1]")).getText(), "New York to London");
	    assertEquals(driver.findElement(By.xpath("//table[2]/tbody/tr/td/table/tbody/tr[2]/td/b/font")).getText(), expected1);
	    
	    driver.findElement(By.xpath("//table[1]/tbody/tr/td/table/tbody/tr[2]/td/b/font")).click();
	    assertEquals(driver.findElement(By.xpath("//table[1]/tbody/tr/td/table/tbody/tr[2]/td/b/font")).getText(), expected2);

  }
 

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }


 
  
  
}
