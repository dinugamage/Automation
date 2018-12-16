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
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Test001 {

		  private WebDriver driver;
		  private String baseUrl;
		  private boolean acceptNextAlert = true;
		  private StringBuffer verificationErrors = new StringBuffer();

		  @BeforeClass(alwaysRun = true)
		  public void setUp() throws Exception {
		   // driver = new FirefoxDriver();
			  //initialize the driver
			  //give the path of the chrome driver file in the lib folder
			  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\Desktop\\Automation\\TestAutomationDay3\\lib\\chromedriver.exe");
			  driver= new ChromeDriver();
		    baseUrl = "https://www.katalon.com/";
		    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  }

@Test
		  public void test001() throws Exception {
		    driver.get("https://www.calculator.net/");
		    driver.findElement(By.xpath("//a[text()='Math Calculators']")).click();
		    driver.findElement(By.xpath("//a[text()='Percentage Calculator']")).click();
		    driver.findElement(By.xpath("//input[@id='cpar1']")).click();
		    driver.findElement(By.xpath("//input[@id='cpar1']")).clear();
		    driver.findElement(By.xpath("//input[@id='cpar1']")).sendKeys("5");
		    driver.findElement(By.xpath("//input[@id='cpar2']")).click();
		    driver.findElement(By.xpath("//input[@id='cpar2']")).clear();
		    driver.findElement(By.xpath("//input[@id='cpar2']")).sendKeys("200");
		    driver.findElement(By.xpath("(//input[@value='Calculate'])[1]")).click();
		    
		    assertEquals(driver.findElement(By.xpath("//p[@class='verybigtext']//b")).getText(),"10");
		    //driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Percentage Calculator'])[3]/following::input[5]")).click();
		   // driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Result: 10'])[1]/following::p[1]")).click();
		    //assertEquals(driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Result: 10'])[1]/following::b[1]")).getText(), "10");
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



