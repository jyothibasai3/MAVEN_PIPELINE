package com.Vtiger.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.Vtiger.Objectrepo.HomePage;
import com.Vtiger.Objectrepo.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public 	WebDriver driver;
	public PropertyFile proper = new PropertyFile();

    @Parameters("BROWSER")
	@BeforeClass
	public void OpenBrowser(String BROWSER) throws Throwable {



		//String BROWSER =	proper.readDatafrompropertyfile("browser");

		if (BROWSER.equalsIgnoreCase("chrome")) 
		{
			WebDriverManager.chromedriver().setup();

			driver = new ChromeDriver();

		}
		else if (BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}
		else
		{
			System.out.println("No Browser Provided Launching Default browser");

		}

		driver.get(proper.readDatafrompropertyfile("url"));
		WebDriverUtil  webDriverUtil=new WebDriverUtil(driver);
		webDriverUtil.maxwindow();
		webDriverUtil.pageloadtimeout();
	}
	@BeforeMethod
	public void login() throws Throwable {
		LoginPage loginPage=new LoginPage(driver);
		loginPage.logintoApp();
	}
	@AfterMethod
	public void logout() throws InterruptedException {
		HomePage homepage=new HomePage(driver);
		homepage.logoutfromApp();
	}
	@AfterClass
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(10000);
		driver.close();
	}
}