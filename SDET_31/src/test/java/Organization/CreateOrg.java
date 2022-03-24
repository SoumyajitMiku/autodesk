package Organization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.crm.autodesk.POMpages.HomePage;
import com.crm.autodesk.POMpages.OrganizationsPage;

import GenericUtilities.BaseClass;
import GenericUtilities.ExcelLibUtilities;
import GenericUtilities.FileUtilitites;
import GenericUtilities.WebDriverUtilities;
import GenericUtilities.JavaUtilities;

public class CreateOrg extends BaseClass{
@Test
	public void createOrg() throws Throwable {
		
		HomePage homePage = new HomePage(driver);
		homePage.clickOnOrganization();
		// get OrgName from excel file eg: SAP
		// code for fetching test data
		String orgName = eUtil.getDataFromExcel("Sheet1", 3, 0);

		orgName = orgName + jUtil.randomNumber();
		OrganizationsPage orgPage = new OrganizationsPage(driver);
		orgPage.createOrganizationButton();

		driver.findElement(By.name("accountname")).sendKeys(orgName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		String actHeaderMessage = driver.findElement(By.className("dvHeaderText")).getText();
		// confirm if org Name has come
		if (actHeaderMessage.contains(orgName)) {
			System.out.println(orgName + " is verified = pass");
		} else {
			System.out.println(orgName + " is not verified =  fail");
		}

	}

}
