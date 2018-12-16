package com.example.framework;

import java.util.regex.Pattern;
import java.io.File;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;

import com.example.framework.page.Calculatepercentage;
import com.example.framework.page.CalculatorHomePage;

import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestPageObject extends TestCommands{
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
  @DataProvider
  public Object[][] dt_test001(){
  	//ReadFromExcel reader=new ReadFromExcel ("C:\\Users\\Lenovo\\Desktop\\Automation\\TestAutomationDay3\\data","PercentageData.xls");
  	//return reader.getSheetData();
	  return new Object[][] {
		  new Object[] {"5","200","10"},
  };
  }
  
  @Test(dataProvider="dt_test001")
  public void test002(String percentage, String value, String expected) throws Exception {
    //driver.get("https://www.calculator.net/");
	 open(driver,"https://www.calculator.net/" );
	 
	 //create page objects under CalculateHomePgae java file and call here
	 
	 CalculatorHomePage calHome = new CalculatorHomePage  ();
	 calHome.navigateToPercCalcPage(driver);

	 
	 Calculatepercentage calpercent= new Calculatepercentage();
	 calpercent.calculatePercent(driver, percentage, value);
	// calpercent.calculatePercent(driver,"5", "300"); // whole calculation method is done in CalculatorHomePage class
	 //passing values to the method
	 
	 calpercent.verifyResults(driver,expected);
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
