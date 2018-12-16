package com.example.pageobject2;

import org.testng.annotations.Test;

import com.example.framework.TestCommands;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

public class PageObject003 extends TestCommands{
	  private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
 
  @BeforeMethod(alwaysRun = true)
  public void setUp() throws Exception {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\Desktop\\Automation\\TestAutomationDay3\\lib\\chromedriver.exe");
	  driver= new ChromeDriver();
    baseUrl = "https://www.katalon.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  

  @DataProvider
  public Object[][] test_dt003() {
    return new Object[][] {
    	new Object[] {"dinu92","dinu92","London","December","30", "New York", "December", "31","Blue Skies Airlines","New York to London", "London to New York"},
      
    };
  }
  
  @Test(dataProvider = "test_dt003")
  public void test003(String username, String password, String port1, String month1,String date1, String port2, String month2, String date2 , String flight, String expected1, String expected2) throws Exception  {
  
  open (driver,"http://newtours.demoaut.com/");
  
  Login login= new Login();
  login.Userlogin(driver,username, password);
  
  
  Formfill formfill= new Formfill();
  formfill.fromdata(driver,port1,month1,date1);
  
  formfill.todata(driver, port2, month2, date2);
  
  formfill.airline(driver, flight);
  
  formfill.findflight(driver);
  
  formfill.confirm(driver, expected1, expected2);
  
  }
  
  
  @AfterMethod(alwaysRun = true)
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
