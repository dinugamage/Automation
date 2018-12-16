package com.appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AppiumHybrid {
	
    AppiumDriver driver;
  
    @BeforeMethod
    public void beforeMethod() throws Exception {
    	
    	File apkFile = new File("apk"+File.separator+"eribank.apk");
    	String apkFilePath = apkFile.getAbsolutePath();
        
    	DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
    	desiredCapabilities.setCapability(MobileCapabilityType.APP, apkFilePath);
    	desiredCapabilities.setCapability(MobileCapabilityType.APP_PACKAGE, "com.android.chrome"); //give package name
    	desiredCapabilities.setCapability(MobileCapabilityType.APP_ACTIVITY, "com.google.android.apps.chrome.Main"); //give app activity name
    	
    	desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
    	desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.1.1");
    	desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "300");
    	desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
    	URL url = new URL("http://127.0.0.1:4723/wd/hub");
    	driver = new AndroidDriver(url, desiredCapabilities);
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    
    @Test
    public void testCase() throws InterruptedException {
    	 //Login to the system
    	
    	driver.findElement(By.xpath("//android.widget.Button[@text='ACCEPT & CONTINUE']")).click();
    	//driver.findElement(By.xpath("//android.widget.Button[@text='NEXT']")).click();
    	driver.findElement(By.xpath("//android.widget.Button[@text='NO THANKS']")).click();
    	driver.findElement(By.xpath("//android.widget.EditText[@text='Search or type URL']")).sendKeys("www.google.com"+"\n");
    	
    	//select suggestions other than enter
    	//driver.findElement(By.xpath("//android.widget.TextView[@text='www.google.com']")).click();
    	
         //driver.findElement(By.xpath("//android.widget.EditText[@text='Username']")).sendKeys("company");
        // driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.experitest.ExperiBank:id/passwordTextField']")).sendKeys("company");
        // driver.findElement(By.xpath("//android.widget.EditText[@text='Login']")).click();         
         
         //Check the available balance
         System.out.println("Current available contexts are : "+driver.getContextHandles());
         
        // driver.context("WEBVIEW_com.experitest.ExperiBank");
         //switch context from native to web view
         driver.context("WEBVIEW_chrome");
         
         System.out.println("Current available contexts are : "+driver.getContextHandles());
         //driver.get("https://www.google.com");
        // driver.findElement(By.xpath("//input[@type='search']")).click();
         
         driver.findElement(By.xpath("//input[@type='search']")).sendKeys("Selenium"+"\n");
        // element.sendKeys("your text"+"\n")
        
      //   System.out.println("Page Source of the Web Context ::: \n*********************\n");
         
        // System.out.println(driver.getPageSource());
         //String balance = driver.findElement(By.xpath("//h1[@align='center']")).getText();
         //System.out.println(balance);
         
         //Switch back to the native context
        // driver.context("NATIVE_APP");
         //Logout
        // driver.findElement(By.xpath("//android.widget.Button[@text='Logout']")).click();
    } 
    
    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
   
}

