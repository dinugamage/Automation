package com.test.exercise3;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class TestNG2 {
	
	private WebDriver driver;
	 // private String baseUrl;
	 private StringBuffer verificationErrors = new StringBuffer();
	 
 
  
  @Parameters({"browser"})
  
  @BeforeMethod
  public void setUp(String browser) throws Exception {
	  if(browser.equals("chrome")) {
		  System.setProperty("webdriver.chrome.driver","C:\\Users\\Lenovo\\Desktop\\Automation\\TestAutomationDay3\\lib\\chromedriver.exe");
		  //give the path of the lib folder in work space
	    driver = new ChromeDriver();
	   // baseUrl = "https://www.katalon.com/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }
	  else {System.out.println("It is not a valid a browser");
	  }
  }
  
  @DataProvider
  public Object[][]data_test003(){
	  return new Object[][] {
		  new Object[] {"dinu92","dinu92","London","December","30", "New York", "December", "31","Blue Skies Airlines","New York to London", "London to New York"},
		// new Object[] {"dinu92", "dinu92", "London","December","30","New York", "December","31","Blue Skies Airlines", "London to New York"},
  };
  }
  
  
  @Test(dataProvider = "data_test003")
	 public void test003(String username, String passowrd, String port1, String month1,String date1, String port2, String month2, String date2 , String flight, String expected1, String expected2) throws Exception {
 
	    driver.get("http://newtours.demoaut.com/");
	    driver.findElement(By.xpath("//input[@name='userName']")).click();
	    driver.findElement(By.xpath("//input[@name='userName']")).clear();
	    driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(username);
	    driver.findElement(By.xpath("//input[@type='password']")).clear();
	    driver.findElement(By.xpath("//input[@type='password']")).sendKeys(passowrd);
	    driver.findElement(By.xpath("//input[@value='Login']")).click();
	    
	   driver.findElement(By.xpath("//select[@name='fromPort']")).click();
	    new Select(driver.findElement(By.xpath("//select[@name='fromPort']"))).selectByVisibleText(port1);
  
	    driver.findElement(By.xpath("//select[@name='fromMonth']")).click();
		   // new Select(driver.findElement(By.xpath("toMonth"))).selectByVisibleText("December");
		new Select(driver.findElement(By.xpath("//select[@name='fromMonth']"))).selectByVisibleText(month1);
		    
		
		driver.findElement(By.xpath("//select[@name='fromDay']")).click();
	    //new Select(driver.findElement(By.xpath("toDay"))).selectByVisibleText("2");
	    new Select(driver.findElement(By.xpath("//select[@name='fromDay']"))).selectByVisibleText(date1);
	   // driver.findElement(By.xpath("toDay")).click();
	    
	   
	    driver.findElement(By.xpath("//select[@name='toPort']")).click();
	    new Select(driver.findElement(By.xpath("//select[@name='toPort']"))).selectByVisibleText(port2);
	    //new Select(driver.findElement(By.xpath("toPort"))).selectByVisibleText("New York");
	    //driver.findElement(By.xpath("toPort")).click();
	    
	    driver.findElement(By.xpath("//select[@name='toMonth']")).click();
	   // new Select(driver.findElement(By.xpath("toMonth"))).selectByVisibleText("December");
	    new Select(driver.findElement(By.xpath("//select[@name='toMonth']"))).selectByVisibleText(month2);
	    
	    //driver.findElement(By.xpath("toMonth")).click();
	    
	    driver.findElement(By.xpath("//select[@name='toDay']")).click();
	    //new Select(driver.findElement(By.xpath("toDay"))).selectByVisibleText("2");
	    new Select(driver.findElement(By.xpath("//select[@name='toDay']"))).selectByVisibleText(date2);
	   // driver.findElement(By.xpath("toDay")).click();
	    
	    driver.findElement(By.xpath("//select[@name='airline']")).click();
	    new Select(driver.findElement(By.xpath("//select[@name='airline']"))).selectByVisibleText(flight);
	    //new Select(driver.findElement(By.xpath("airline"))).selectByVisibleText("Blue Skies Airlines");
	   // driver.findElement(By.xpath("airline")).click();
	    
	    driver.findElement(By.xpath("//input[@name='findFlights']")).click();
	    
	    driver.findElement(By.xpath("//table[2]/tbody/tr/td/table")).click();
	    //assertEquals(driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='RETURN'])[1]/following::font[1]")).getText(), "New York to London");
	    assertEquals(driver.findElement(By.xpath("//table[2]/tbody/tr/td/table/tbody/tr[2]/td/b/font")).getText(), expected1);
	    
	    driver.findElement(By.xpath("//table[1]/tbody/tr/td/table/tbody/tr[2]/td/b/font")).click();
	    assertEquals(driver.findElement(By.xpath("//table[1]/tbody/tr/td/table/tbody/tr[2]/td/b/font")).getText(), expected2);
  
  }

  @AfterMethod
  public void afterMethod() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  } {
  }


  
}
