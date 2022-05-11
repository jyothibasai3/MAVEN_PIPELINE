package com.Vtiger.Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.Vtiger.Objectrepo.ContactInfoPage;
import com.Vtiger.Objectrepo.ContactOrgPopUp;
import com.Vtiger.Objectrepo.CreateNewContactPage;
import com.Vtiger.Objectrepo.HomePage;
import com.Vtiger.generic.BaseClass;

import com.Vtiger.generic.TestData;
import com.Vtiger.generic.WebDriverUtil;


public class Tc_003Contacts_Lastname extends BaseClass{

	@Test
	public void ContactsLastName() throws InterruptedException
	{
		WebDriverUtil webDriverUtil = new WebDriverUtil(driver);

		HomePage homePage = new HomePage(driver);
		homePage.getContactslink().click();

		ContactInfoPage conatctInfoPage = new  ContactInfoPage(driver);
		conatctInfoPage.getCreatecontactsimg().click();
		TestData testData= new TestData();

		String contactname=testData.getLastName();

		System.out.println(contactname);
		
		CreateNewContactPage createNewContactPage = new CreateNewContactPage(driver);
		createNewContactPage.getLastNameEdt().sendKeys(contactname);

		createNewContactPage.getOrganizationLookUpImage().click();

		Thread.sleep(2000);
		webDriverUtil.switchWindow("Accounts");
		Thread.sleep(4000);

		ContactOrgPopUp contactOrg_popup = new ContactOrgPopUp(driver);

		contactOrg_popup.searchandSelectforOrg("Renewables & Environment166");

		Thread.sleep(2000);
		webDriverUtil.switchWindow("Contacts");

		createNewContactPage.getSaveBtn().click();

		Thread.sleep(8000);

		String contactid=createNewContactPage.getcontactid().getText();

		System.out.println(contactid);
		driver.navigate().refresh();

		homePage.getContactslink().click();

		conatctInfoPage.checkcontactcreated(contactid);

		Thread.sleep(4000);

		String actualcontactlastname=conatctInfoPage.getactualcontact().getText();

		System.out.println(actualcontactlastname);
		Assert.assertEquals(contactid,true);//if (actualcontactlastname.equals(contactname)) 
//		{
//			System.out.println("Tc Passes");
//		}
//		else {
//			System.out.println("TC Fail");
//		}
//		
		
		
		
	}
}
