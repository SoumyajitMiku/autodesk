package com.crm.autodeskselenium.Contact;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.autodesk.POMpages.ContactPlusPage;
import com.crm.autodesk.POMpages.NewContactPage;
import com.crm.autodesk.POMpages.HomePage;
import GenericUtilities.BaseClass;
@Listeners(GenericUtilities.ListenerImplementationClass.class)
public class TC_12Test extends BaseClass{
	@Test(groups="regressionTest")
	public  void contact() throws Throwable {
		
		// click on contact link
		HomePage homePage = new HomePage(driver);
		homePage.mouseOverOnContacts(driver);

		// click on + contact button
		ContactPlusPage plusPage = new ContactPlusPage(driver);
		plusPage.clickContactPlusButton();

		//contact page pass last name and select group radio button
		NewContactPage contactPage = new NewContactPage(driver);
		String lastName =eUtil.getDataFromExcel("Sheet1", 7, 1);
		contactPage.passLastName(lastName);
	
		wUtil.scrollBar(driver, 0, 150);
		//select radio button
		contactPage.getSelectGroupRadio().click();
		contactPage.selectGroup();
		
		//select TeamSellingGroup from dropdown
		String TeamSellingGroup = eUtil.getDataFromExcel("Sheet1", 15, 1);
		contactPage.teamSellingDD(TeamSellingGroup);
		
		//logout function
		
	}

}
