package com.exercise5;
// to run the application

import java.util.regex.Pattern;
import java.io.File;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;

//import com.example.framework.page.Calculatepercentage;
//import com.example.framework.page.CalculatorHomePage;

import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestPageObject  extends TestCommands{
  private WebDriver driver;
  private String baseUrl;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeMethod(alwaysRun = true)
  public void setUp() throws Exception {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\Desktop\\Automation\\TestAutomationDay3\\lib\\chromedriver.exe");
	  driver= new ChromeDriver();
    baseUrl = "https://www.katalon.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }
  @DataProvider
  public Object[][] dt_test001(){
	 // return new Object[][] {
	 // new Object[] {"5","200","10"},
  	//ReadFromExcel reader=new ReadFromExcel ("data"+File.separator+"Percentage.xlsx");
	  ReadFromExcel reader=new ReadFromExcel ("C:\\Users\\Lenovo\\Desktop\\Automation\\SeleniumTesting\\data","Percentage.xlsx");
  	return reader.getSheetData();
	 
			   }

 // }
  
  
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
	// calpercent.verifyResults(driver, "15");
  }

  
  @AfterMethod(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

 //
}
