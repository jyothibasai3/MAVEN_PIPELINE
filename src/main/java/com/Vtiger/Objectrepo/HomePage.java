package com.Vtiger.Objectrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Vtiger.generic.WebDriverUtil;



public class HomePage {   //Rule:1

	//Rule:1

	WebDriver driver;

	//Rule:3

	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}
	@FindBy(xpath=("//a[.='Organizations']"))
	private WebElement orglink;

	public WebElement getOrglink() 
	{
		return orglink;
	}

	@FindBy(xpath="//a[text()='Contacts']")
	private WebElement contactslink;

	public WebElement getContactslink() 
	{
		return contactslink;
	}


	@FindBy(xpath=("//img[@src='themes/softed/images/user.PNG']"))
	private WebElement logoutimg; 
	public WebElement getLogoutimg()
	{
		return logoutimg;
	}

	@FindBy(xpath="//a[.='Sign Out']")
	private WebElement logoutbtn;

	public WebElement getLogoutbtn() {
		return logoutbtn;
	}
	public void logoutfromApp() throws InterruptedException
	{
		WebDriverUtil WebDriverutil=new WebDriverUtil(driver);
		WebDriverutil.moveToelement(logoutimg);
		Thread.sleep(2000);
		logoutbtn.click();

	}

}
