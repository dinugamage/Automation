package com.example.framework;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class TestCommands {
	
	//pass web driver and locator as variables so that can be used in test cases
	public void  click(WebDriver driver, By string) { // created click command wrapping selenium click method
		//WebElement element=driver.findElement(By.xpath(locator));
		
		//####### PASS DRIVER AND STRING TO THE CREATED FIND ELEMENT METHOD#####
		WebElement element = findElementByLocator(driver, string);
		element.click(); // selenium click method
		logReport("Clicked on element:" +string);
	}

	public void type(WebDriver driver, By string, String i) {
		//WebElement element=driver.findElement(By.xpath(locator));
		WebElement element =findElementByLocator(driver, string);
				
		element.clear(); //to clear of there is already added text in field
		element.sendKeys(i);
		logReport("Typed text:" + i + "on element" +string);
	
	}
	
	
/*	public void selectByVisibleText(WebDriver driver, String locator, String text2) {
		WebElement element=driver.findElement(By.xpath(locator));
		 element.selectByVisibleText(text2);
		
	}*/
	
	public void open(WebDriver driver,String url) {
		driver.get(url);
		logReport("Opened URL:" +url);
		
	}
	
	public void assertText(WebDriver driver,By locator, String expected) {
		//WebElement element=driver.findElement(By.xpath(locator));
		WebElement element=findElementByLocator(driver, locator);
		//String actual=element.getText();
		assertEquals(element.getText(), expected);
		logReport("The actual value:" +element.getText()+ "on element" +locator );
		
	}
	
	public void select (WebDriver driver,By locator, String name1) {
		
		WebElement element= findElementByLocator(driver,locator);
		Select dropdown = new Select(element);
		dropdown.selectByVisibleText(name1);
	}
	
	
	//################################################################
	//created to find elements and used everywhere to find elements
	public WebElement findElementByLocator(WebDriver driver, By string) {
		try {
		//find the web element by waiitn until loading
		WebDriverWait wait = new WebDriverWait(driver, 10); 
	WebElement ele=wait.until(ExpectedConditions.presenceOfElementLocated(string));
	return ele;
		}
		catch(Exception e) {
			System.err.println("**********************");
		System.err.println("Could not find eleent:"+e.getMessage());
			throw e;
		}
	//return ele;
	}
	private void logReport(String logMessage) {
		Reporter.log("<p>"+logMessage +"</p>");
		
	}
	
//PropertyFileReader propreder = new PropertyFileReader("config.prop")
	//		String propValue=propReader.getPropertyValue("MAX_TIMEOUT_SECONDS");
//	return Integer.parseInt(propValue);
	
	
}
