package com.example.pageobject2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.example.framework.TestCommands;

public class Formfill extends TestCommands{

	private By fport= By.xpath("//select[@name='fromPort']");
	private By fmonth= By.xpath ("//select[@name='fromMonth']");
	private By fdate=By.xpath("//select[@name='fromDay']");
	
	private By tport=By.xpath("//select[@name='toPort']");
	private By tomonth=By.xpath("//select[@name='toMonth']");
	private By todate=By.xpath("//select[@name='toDay");
	
	private By airline=By.xpath("//select[@name='airline']");
	
	private By find =By.xpath("//input[@name='findFlights']");
	
	private By text1= By.xpath("//table[2]/tbody/tr/td/table/tbody/tr[2]/td/b/font");
	
	private By text2 = By.xpath("//table[1]/tbody/tr/td/table/tbody/tr[2]/td/b/font");
	
	public void fromdata(WebDriver driver,String port1, String month1, String date1) {
		click (driver, fport);
		select(driver, fport,port1);
		
		click (driver,fmonth);
		select(driver,fmonth,month1);
		
		click (driver,fdate);
		select (driver, fdate, date1);
		
	}
	
	public void todata(WebDriver driver,String port2, String month2, String date2) {
		click (driver, tport);
		select(driver, tport,port2);
		
		click (driver,tomonth);
		select(driver,tomonth,month2);
		
		click (driver,todate);
		select (driver, fdate, date2);
		
		
	}
	 
	    
	public void airline(WebDriver driver,String flight ) {
	click(driver, airline);
	select(driver,airline,flight);
	}
	
 public void  findflight(WebDriver driver) {
	 click(driver, find);
 }
 
 public void  confirm (WebDriver driver, String expected1,String expected2 ) {
	 click(driver, text1);
	 assertText(driver,text1,expected1);
	 
	 click(driver, text2);
	 assertText(driver,text2,expected2);
 }
    
}
