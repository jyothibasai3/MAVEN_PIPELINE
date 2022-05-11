package com.Vtiger.Testcases;

import org.testng.annotations.Test;

import com.Vtiger.Objectrepo.CreateNewOrgPage;
import com.Vtiger.Objectrepo.HomePage;
import com.Vtiger.Objectrepo.LoginPage;
import com.Vtiger.Objectrepo.OrganisationInfoPage;
import com.Vtiger.generic.BaseClass;
import com.Vtiger.generic.JavaUtil;
import com.Vtiger.generic.TestData;
import com.Vtiger.generic.WebDriverUtil;



public class TC_001Vtiger   extends BaseClass  {

	@Test
	public void OrganisationName() throws InterruptedException
	{
		//launching the browser and login page
		WebDriverUtil web=new WebDriverUtil(driver);
		web.maxwindow();
		web.pageloadtimeout();
		LoginPage login=new LoginPage(driver);
		login.getLoginbtn();
		//home page
		HomePage homepage=new HomePage(driver);
		homepage.getOrglink().click();
		//click on create new organization
		OrganisationInfoPage orginfopage=new OrganisationInfoPage(driver);
		orginfopage.getCreateorgbtn().click();
		//taking the data from faker
		TestData testData= new TestData();
		JavaUtil javaUtil = new JavaUtil();
		String orgname=testData.getOrganizationName()+javaUtil.createRandomnumber();
		//clicking on create new organization and save the data
		CreateNewOrgPage createorgpage=new CreateNewOrgPage(driver);
		createorgpage.getOrgname().sendKeys(orgname);
		createorgpage.getSaveorgbtn().click();
		Thread.sleep(4000);
		driver.navigate().refresh();
		homepage.getOrglink().click();

		orginfopage.searchforOrg(orgname, "accountname");
		Thread.sleep(3000);

		String actualorgname=orginfopage.getfirstOrg().getText();

		if (orgname.equals(actualorgname)) 
		{
			System.out.println("Tc Passes");
		}
		else {
			System.out.println("TC Fail");
		}
	}  

}

