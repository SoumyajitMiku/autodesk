package com.crm.autodesk.POMpages.Scenarios_7_Mar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.autodesk.POMpages.CampaignVerifyInfoPage;
import com.crm.autodesk.POMpages.ContactPlusPage;
import com.crm.autodesk.POMpages.CreateOrganizationWithIndustryPage;
import com.crm.autodesk.POMpages.HomePage;
import com.crm.autodesk.POMpages.NewContactPage;
import com.crm.autodesk.POMpages.OrgInfoPage;
import com.crm.autodesk.POMpages.OrganizationAccountsPage;
import com.crm.autodesk.POMpages.OrganizationsPage;

import GenericUtilities.BaseClass;

/**
 * this class is used to create organization and select the same org in contact
 * page
 * 
 * @author Ramya
 *
 */
@Listeners(GenericUtilities.ListenerImplementationClass.class)
public class CreateContactChooseOrgTest extends BaseClass {
	@Test(groups = "smokeTest")
	public void createContactChooseOrg() throws Throwable {
//data from excel
		String orgName = eUtil.getDataFromExcel("Sheet1", 4, 0) + "_" + jUtil.randomNumber();
		String lastName = eUtil.getDataFromExcel("Sheet1", 7, 1);
		HomePage homePage = new HomePage(driver);
		homePage.clickOnOrganization();

		OrganizationsPage orgplusBtn = new OrganizationsPage(driver);
		orgplusBtn.createOrganizationButton();

		// get OrgName from excel file eg: SAP
		
		CreateOrganizationWithIndustryPage saveOrgClick = new CreateOrganizationWithIndustryPage(driver);
		saveOrgClick.createOrg(orgName);

		saveOrgClick.saveClick();

		OrgInfoPage infoPage = new OrgInfoPage(driver);
		String mainHeaderText = infoPage.verifyHeaderText();
		Assert.assertEquals(mainHeaderText.contains(orgName), true);
		// click on contact link

		homePage.clickOnContacts();

		// click on + contact button
		ContactPlusPage plusPage = new ContactPlusPage(driver);
		plusPage.clickContactPlusButton();

		// contact page pass last name and select group radio button
		NewContactPage contactPage = new NewContactPage(driver);
		
		contactPage.passLastName(lastName);
		// click on plus orgname and go to new page

		contactPage.plusOrgClick(driver);

		// switch to accounts window

		OrganizationAccountsPage accountsOrg = new OrganizationAccountsPage(driver);
		accountsOrg.searchTxtBox(orgName, driver);

		// verify organization Information

		OrgInfoPage verifyInfo = new OrgInfoPage(driver);

		String actHeaderMessage = verifyInfo.verifyHeaderText();
		Assert.assertEquals(actHeaderMessage.contains(lastName), true);

		// logout function

	}

}
