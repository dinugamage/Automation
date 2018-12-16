package com.example.xpath;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Test003 {
	 private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();

	  @BeforeClass(alwaysRun = true)
	  public void setUp() throws Exception {
		  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\Desktop\\Automation\\TestAutomationDay3\\lib\\chromedriver.exe");
		  driver= new ChromeDriver();
	    baseUrl = "https://www.katalon.com/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }

	  
	  @Test
	  public void test003() throws Exception {
		    driver.get("http://newtours.demoaut.com/");
		    driver.findElement(By.xpath("//input[@name='userName']")).click();
		    driver.findElement(By.xpath("//input[@name='userName']")).clear();
		    driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("dinu92");
		    driver.findElement(By.xpath("//input[@type='password']")).clear();
		    driver.findElement(By.xpath("//input[@type='password']")).sendKeys("dinu92");
		    driver.findElement(By.xpath("//input[@value='Login']")).click();
		    
		   driver.findElement(By.xpath("//select[@name='fromPort']")).click();
		    new Select(driver.findElement(By.xpath("//select[@name='fromPort']"))).selectByVisibleText("London");
		    //new Select(driver.findElement(By.xpath("//select[@name='fromPort']/option[text()='London']")));
		    //driver.findElement(By.xpath("fromPort")).click();
		  //select[@name='country']/option[text() = 'ALGERIA ']
		    
		    driver.findElement(By.xpath("//select[@name='fromMonth']")).click();
			   // new Select(driver.findElement(By.xpath("toMonth"))).selectByVisibleText("December");
			new Select(driver.findElement(By.xpath("//select[@name='fromMonth']"))).selectByVisibleText("December");
			    
			
			driver.findElement(By.xpath("//select[@name='fromDay']")).click();
		    //new Select(driver.findElement(By.xpath("toDay"))).selectByVisibleText("2");
		    new Select(driver.findElement(By.xpath("//select[@name='fromDay']"))).selectByVisibleText("30");
		   // driver.findElement(By.xpath("toDay")).click();
		    
		   
		    driver.findElement(By.xpath("//select[@name='toPort']")).click();
		    new Select(driver.findElement(By.xpath("//select[@name='toPort']"))).selectByVisibleText("New York");
		    //new Select(driver.findElement(By.xpath("toPort"))).selectByVisibleText("New York");
		    //driver.findElement(By.xpath("toPort")).click();
		    
		    driver.findElement(By.xpath("//select[@name='toMonth']")).click();
		   // new Select(driver.findElement(By.xpath("toMonth"))).selectByVisibleText("December");
		    new Select(driver.findElement(By.xpath("//select[@name='toMonth']"))).selectByVisibleText("December");
		    
		    //driver.findElement(By.xpath("toMonth")).click();
		    
		    driver.findElement(By.xpath("//select[@name='toDay']")).click();
		    //new Select(driver.findElement(By.xpath("toDay"))).selectByVisibleText("2");
		    new Select(driver.findElement(By.xpath("//select[@name='toDay']"))).selectByVisibleText("31");
		   // driver.findElement(By.xpath("toDay")).click();
		    
		    driver.findElement(By.xpath("//select[@name='airline']")).click();
		    new Select(driver.findElement(By.xpath("//select[@name='airline']"))).selectByVisibleText("Blue Skies Airlines");
		    //new Select(driver.findElement(By.xpath("airline"))).selectByVisibleText("Blue Skies Airlines");
		   // driver.findElement(By.xpath("airline")).click();
		    
		    driver.findElement(By.xpath("//input[@name='findFlights']")).click();
		    
		    driver.findElement(By.xpath("//table[2]/tbody/tr/td/table")).click();
		    //assertEquals(driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='RETURN'])[1]/following::font[1]")).getText(), "New York to London");
		    assertEquals(driver.findElement(By.xpath("//table[2]/tbody/tr/td/table/tbody/tr[2]/td/b/font")).getText(), "New York to London");
		    
		  //for the return text in the table
		    //tr/following::b/font[text()='DEPART']/following::font
		  }

	  @AfterClass(alwaysRun = true)
	  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }

	  private boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	  private boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	  private String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }
}
