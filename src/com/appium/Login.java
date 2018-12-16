package com.appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class Login {
	AppiumDriver driver;
	  
	MobileElement el1 = (MobileElement) driver.findElementById("com.experitest.eribank:id/usernameTextField");
	el1.sendKeys("company");
	MobileElement el2 = (MobileElement) driver.findElementById("com.experitest.eribank:id/passwordTextField");
	el2.sendKeys("company");
	MobileElement el3 = (MobileElement) driver.findElementById("com.experitest.eribank:id/loginButton");
	el3.click();
}
