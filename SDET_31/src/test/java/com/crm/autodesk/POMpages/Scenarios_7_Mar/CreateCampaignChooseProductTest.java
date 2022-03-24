package com.crm.autodesk.POMpages.Scenarios_7_Mar;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.autodesk.POMpages.CampaignPlusPage;
import com.crm.autodesk.POMpages.CampaignVerifyInfoPage;
import com.crm.autodesk.POMpages.HomePage;
import com.crm.autodesk.POMpages.NewCampaignPage;
import GenericUtilities.BaseClass;

/**
 * this class is used to create campaign and select the same product in campaign
 * page
 * 
 * @author Ramya
 *
 */
@Listeners(GenericUtilities.ListenerImplementationClass.class)
public class CreateCampaignChooseProductTest extends BaseClass {
	@Test(groups = "regressionTest")
	public void createCampaignChooseProduct() throws Throwable {
//data from excel
		String ProductName = eUtil.getDataFromExcel("Sheet1", 8, 1);
		String CampaignName = eUtil.getDataFromExcel("Sheet1", 10, 1);
		
		HomePage homePage = new HomePage(driver);
		homePage.mouseOverOnMore(driver);
		homePage.clickOnCampaign();

		CampaignPlusPage campaignPlusBtn = new CampaignPlusPage(driver);
		campaignPlusBtn.campaignPlusButton();

		NewCampaignPage campPage = new NewCampaignPage(driver);

		campPage.campNameText(CampaignName);
		// click on plus orgname and go to new page

		campPage.productPlusBtn();

		// in child window
		campPage.passProductNameField(ProductName);
		campPage.campPlusClick(driver, ProductName);
		campPage.save();

		// verify campaign Information
		CampaignVerifyInfoPage verifyInfo = new CampaignVerifyInfoPage(driver);

		String actHeaderMessage = verifyInfo.verifyHeaderText();
		
		Assert.assertEquals(actHeaderMessage.contains(CampaignName), true);
		// logout function

	}

}
