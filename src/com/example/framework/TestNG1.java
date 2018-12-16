package com.example.framework;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class TestNG1 extends TestCommands {
	
	 private WebDriver driver;
	 // private String baseUrl;
	 private StringBuffer verificationErrors = new StringBuffer();
	 
	 @Parameters({"browser"})
	   
	 @BeforeMethod
	  public void setUp(String browser) throws Exception {
		  if(browser.equals("chrome")) {
			  System.setProperty("webdriver.chrome.driver","C:\\Users\\csc17\\Desktop\\Dinu_day3\\TestAutomationDay3\\lib\\chromedriver.exe");
			  //give the path of the lib folder in work space
		    driver = new ChromeDriver();
		   // baseUrl = "https://www.katalon.com/";
		    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  }
		  else {System.out.println("It is not a valid a browser");
		  }
	  }
	 @DataProvider
	  public Object[][]data_test002(){
		  return new Object[][] {
			  new Object[] {"5","200","10"},
			 // new Object[] {"5","300","15"},
	  };
	  }
	 
  @Test(dataProvider = "data_test002")
	 public void test002(String input1, String input2, String expected) throws Exception {
		    //driver.get("https://www.calculator.net/");
	  		open(driver, "https://www.calculator.net/");
	  		
		   // driver.findElement(By.xpath("//a[text()='Math Calculators']")).click();
	  		
		    driver.findElement(By.xpath("//a[text()='Percentage Calculator']")).click();
		    driver.findElement(By.xpath("//input[@id='cpar1']")).click();
		    driver.findElement(By.xpath("//input[@id='cpar1']")).clear();
		    driver.findElement(By.xpath("//input[@id='cpar1']")).sendKeys(input1);
		    driver.findElement(By.xpath("//input[@id='cpar2']")).click();
		    driver.findElement(By.xpath("//input[@id='cpar2']")).clear();
		    driver.findElement(By.xpath("//input[@id='cpar2']")).sendKeys(input2);
		    driver.findElement(By.xpath("(//input[@value='Calculate'])[1]")).click();
		    
		    assertEquals(driver.findElement(By.xpath("//p[@class='verybigtext']//b")).getText(),expected);
		  }
	 
	 
 

  @AfterMethod
  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }

 
}
