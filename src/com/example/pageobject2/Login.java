package com.example.pageobject2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.example.framework.TestCommands;

public class Login extends TestCommands{
	private By un= By.xpath("//input[@name='userName']");
	private By pw= By.xpath("//input[@type='password']");
	private By login= By.xpath("//input[@value='Login']");
	
	public void Userlogin (WebDriver driver,String username, String password){
		click(driver, un);
		
		type(driver,un, username );
		
		click(driver, pw);
		type(driver,pw,password);
		
		
		click(driver,login);
		
		
	}
	
}
