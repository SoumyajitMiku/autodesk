package com.crm.autodesk.POMpages.Scenarios_7_Mar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.autodesk.POMpages.CreateOrganizationWithIndustryPage;
import com.crm.autodesk.POMpages.OrgInfoPage;
import com.crm.autodesk.POMpages.OrganizationsPage;
import com.crm.autodesk.POMpages.HomePage;
import com.crm.autodesk.POMpages.LoginPage;

import GenericUtilities.BaseClass;
import GenericUtilities.ExcelLibUtilities;
import GenericUtilities.FileUtilitites;
import GenericUtilities.WebDriverUtilities;
import GenericUtilities.JavaUtilities;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * this class creates new organization fetching data from excel
 * 
 * @author Ramya
 *
 */
@Listeners(GenericUtilities.ListenerImplementationClass.class)
public class CreateOrganizationTest extends BaseClass {
	@Test(groups = "smokeTest")
	public void createOrg() throws Throwable {
		// get orgName and Industry from excel
		String orgName = eUtil.getDataFromExcel("Sheet1", 4, 0) + "_" + jUtil.randomNumber();
		String IndustryType = eUtil.getDataFromExcel("Sheet1", 6, 1);

		HomePage homePage = new HomePage(driver);
		homePage.clickOnOrganization();
		// click on + button to create organization
		OrganizationsPage orgPage = new OrganizationsPage(driver);
		orgPage.createOrganizationButton();

		// create new organization
		CreateOrganizationWithIndustryPage createOrg = new CreateOrganizationWithIndustryPage(driver);

		createOrg.createOrg(orgName);

		createOrg.withIndustry(IndustryType);
		createOrg.saveClick();

		// verify organization Information
		OrgInfoPage verifyHeader= new OrgInfoPage(driver);
		String actHeaderMessage = verifyHeader.verifyHeaderText();
		Assert.assertEquals(actHeaderMessage.contains(orgName), true);
		// logout function

	}

}
