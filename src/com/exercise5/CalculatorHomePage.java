package com.exercise5;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//import com.example.framework.TestCommands;

public class CalculatorHomePage extends TestCommands {

	private By percCalculatorLink= By.linkText("Percentage Calculator");
	
	private By mathCalculatorLink= By.linkText("Math Calculators");
	
	//private By input1= By.id("cpar1");
	//private By input2=By.id("cpar2");
	
	//private By calc= By.xpath("(//input[@value='Calculate'])[1]");
	
	//private By verify=By.xpath("//p[@class='verybigtext']//b");
	
	
	
	
	
	public void navigateToPercCalcPage(WebDriver driver) {
		//WebElement element= driver.findElement(mathCalculatorLink);
		
		//#####EXTEND THE COMMNDS CLASS CREATED AND CALL THOSE METHODS IN THIS CLASS######
		click(driver, mathCalculatorLink);
		
		//WebElement element2=driver.findElement(percCalculatorLink);
		click(driver, percCalculatorLink);
	}
	
	
	/*public void calculatePercent(WebDriver driver, String percent, String amount ) {
		WebElement element3=driver.findElement(input1);
		WebElement element4=driver.findElement(input2);
		WebElement element5=driver.findElement(calc);
		element3.click();
		element3.clear();
		element3.sendKeys(percent);
		
		element4.click();
		element4.clear();
		element4.sendKeys(amount);
		
		element5.click();
	}
	
	public void verifyResults(WebDriver driver, String expected) {
		WebElement element6=driver.findElement(verify);
		
	assertEquals(element6.getText(),expected);
	}*/
}
