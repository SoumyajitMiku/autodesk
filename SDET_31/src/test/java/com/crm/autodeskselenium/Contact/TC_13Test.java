package com.crm.autodeskselenium.Contact;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.autodesk.POMpages.ContactDetailsPage;
import com.crm.autodesk.POMpages.HomePage;
import GenericUtilities.BaseClass;
/**
 * this class checks the checkboxes and delete the contacts
 * @author Ramya
 *
 */
@Listeners(GenericUtilities.ListenerImplementationClass.class)
public class TC_13Test extends BaseClass{
@Test(groups="smokeTest")
	public  void contactDelete() throws Throwable {
		
		// click on contact link
		HomePage homePage = new HomePage(driver);
		homePage.mouseOverOnContacts(driver);
		
		ContactDetailsPage detailsPage = new ContactDetailsPage(driver);
		
		  detailsPage.clickOnCheckBox(driver); 
		  detailsPage.deleteName();
		  detailsPage.alertHandle(driver);
		  
	}

}
