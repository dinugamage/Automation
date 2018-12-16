package com.example.framework;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Test002 extends TestCommands{
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
  public void test002() throws Exception {
    //driver.get("https://www.calculator.net/");
	 open(driver,"https://www.calculator.net/" );
	 
	 //create page objects under CalculateHomePgae java file and call here
    //driver.findElement(By.xpath("//a[text()='Math Calculators']")).click();
    click(driver, "//a[text()='Math Calculators']");
    
   // driver.findElement(By.xpath("//a[text()='Percentage Calculator']")).click();
    click(driver,"//a[text()='Percentage Calculator']");
    //driver.findElement(By.id("cpar1")).click();
    click(driver, "//input[@id='cpar1']");
    //driver.findElement(By.id("cpar1")).clear();
   // driver.findElement(By.xpath("//input[@id='cpar1']")).sendKeys("5");
    type(driver,"//input[@id='cpar1']","5" );
   //driver.findElement(By.xpath("//input[@id='cpar2']")).clear();
    
   // driver.findElement(By.xpath("//input[@id='cpar2']")).sendKeys("200");
    type(driver, "\"//input[@id='cpar2']\"", "200");
    //driver.findElement(By.xpath("(//input[@value='Calculate'])[1]")).click();
    click(driver,"(//input[@value='Calculate'])[1]");
    //assertEquals(driver.findElement(By.xpath("//p[@class='verybigtext']//b")).getText(),"10");
    assertText(driver,"//p[@class='verybigtext']//b", "10" );
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
