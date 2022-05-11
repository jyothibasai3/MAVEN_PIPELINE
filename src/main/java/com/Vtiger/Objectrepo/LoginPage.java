package com.Vtiger.Objectrepo;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.Vtiger.generic.PropertyFile;


public class LoginPage {  

//Rule:1
	
	WebDriver driver;
	
	//Rule:3 creating constructor
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	//Rule:2 
	@FindBy(name="user_name")
	private WebElement usernametxtfld;
	
	@FindBys({@FindBy(name="user_password"),@FindBy(xpath="//input[@type='password']")})
	private WebElement passwordtxtfld;
	
	@FindAll({@FindBy(id="submitButton"),@FindBy(xpath="//input[@type='submit']")})
	private WebElement loginbtn;
	
	
		
	public WebElement getPasswordtxtfld() {
		return passwordtxtfld;
	}


	public WebElement getLoginbtn() {
		return loginbtn;
	}


	public WebElement getUsernametxtfld() {
		return usernametxtfld;
	}
     
	public void logintoApp() throws Throwable  //Rule4--business logic libraries
	{
		PropertyFile propertyfile= new PropertyFile();
	
		usernametxtfld.sendKeys(propertyfile.readDatafrompropertyfile("username"));
		passwordtxtfld.sendKeys(propertyfile.readDatafrompropertyfile("password"));
		loginbtn.click();
	}
	
	

}