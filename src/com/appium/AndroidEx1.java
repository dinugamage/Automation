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

public class AndroidEx1 {
	
    AppiumDriver driver;
  
    @BeforeMethod
    public void beforeMethod() throws Exception {
    	
    	File apkFile = new File("apk"+File.separator+"eribank.apk");
    	String apkFilePath = apkFile.getAbsolutePath();
        
    	DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
    	desiredCapabilities.setCapability(MobileCapabilityType.APP, apkFilePath);
    	desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
    	desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7");
    	desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "500");//maximum session retemsion time fot the device
    	desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
    	URL url = new URL("http://127.0.0.1:4723/wd/hub");
    	driver = new AndroidDriver(url, desiredCapabilities);
    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    
    @Test
    public void testCase() throws InterruptedException {
    	 //Login to the system
         driver.findElement(By.xpath("//android.widget.EditText[@text='Username']")).sendKeys("company");
         driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.experitest.eribank:id/passwordTextField']")).sendKeys("company");
         driver.findElement(By.xpath("//android.widget.Button[@text='Login']")).click();
         
         
         //navigate to morgage section
         driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.experitest.eribank:id/mortageRequestButton']")).click();
         //Navigate to Make Payment screen
        // driver.findElement(By.xpath("//android.widget.Button[@text='Make Payment']")).click();
         
         
         //Enter  data
         driver.findElement(By.xpath("//android.widget.EditText[@text='First Name']")).sendKeys("dinu");
         driver.findElement(By.xpath("//android.widget.EditText[@text='Last Name']")).sendKeys("gam");
         driver.findElement(By.xpath("//android.widget.EditText[@text='Age']")).sendKeys("25");
         driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.experitest.eribank:id/addressOneTextField']")).sendKeys("aaaa");
         driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.experitest.eribank:id/addressTwoTextField']")).sendKeys("bbb");
         
         driver.hideKeyboard();
 
         driver.findElement(By.xpath("//android.widget.Button[@text='Select']")).click();//to select country
         
       //Scroll to the correct country
         driver.scrollTo("Spain");
         driver.findElement(By.xpath("//android.widget.TextView[@text='Spain']")).click();
         
         // go to next
         driver.findElement(By.xpath("//android.widget.Button[@text='Next']")).click();
         
        // driver.findElement(By.xpath("//android.widget.EditText[@text='Phone']")).sendKeys("0112345678");
         //driver.findElement(By.xpath("//android.widget.EditText[@text='Name']")).sendKeys("John");
         //driver.findElement(By.xpath("//android.widget.EditText[@text='Amount']")).sendKeys("2");
         
         
         //select loan type
         driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Personal']")).click();
         
         //select # of years
         
         driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='15']")).click();
         
         //type of occupation
         driver.scrollTo("Type Of Occupation");
         driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Business']")).click();
         
         //year income
         driver.scrollTo("5,000,000");
         driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='5,000,000']")).click();
         
         
         //Save details
         driver.findElement(By.xpath("//android.widget.Button[@text='Save']")).click();
        
         
         //verify
         driver.findElement(By.xpath("//android.widget.Button[@text='Logout']")).click();
         
        
        
         //Send Payment
        // driver.findElement(By.xpath("//android.widget.Button[@text='Send Payment']")).click();
         
         //Confirm
        // driver.findElement(By.xpath("//android.view.View[@text='Yes']")).click();
    } 
    
    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
   
}

