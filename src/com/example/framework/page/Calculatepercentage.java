package com.example.framework.page;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.example.framework.TestCommands;

public class Calculatepercentage extends TestCommands{
	private By input1= By.id("cpar1");
	private By input2=By.id("cpar2");
	
	private By calc= By.xpath("(//input[@value='Calculate'])[1]");
	
	private By verify=By.xpath("//p[@class='verybigtext']//b");
	
	
	public void calculatePercent(WebDriver driver, String percent, String amount ) {
		//WebElement element3=driver.findElement(input1);
		//WebElement element4=driver.findElement(input2);
		//WebElement element5=driver.findElement(calc);
		//element3.click();
		//element3.clear();
		//element3.sendKeys(percent);
		
		click(driver, input1); // all the above called emelents are called by a single method
		type(driver,input1, percent);
		//#####EXTEND THE COMMNDS CLASS CREATED AND CALL THOSE METHODS IN THIS CLASS######
		
		
		//element4.click();
		//element4.clear();
		//element4.sendKeys(amount);
		
		click(driver, input2);
		type(driver, input2, amount);
		
		//element5.click();
		click(driver,calc);
	}
	
	public void verifyResults(WebDriver driver, String expected) {
		//WebElement element6=driver.findElement(verify);
	   //assertEquals(element6.getText(),expected);
	//}
	assertText(driver, verify,expected);
	//#####EXTEND THE COMMANDS CLASS CREATED AND CALL THOSE METHODS IN THIS CLASS######
	}
}
