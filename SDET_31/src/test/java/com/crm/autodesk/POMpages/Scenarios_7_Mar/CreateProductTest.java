package com.crm.autodesk.POMpages.Scenarios_7_Mar;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.autodesk.POMpages.HomePage;
import com.crm.autodesk.POMpages.NewProductPage;
import com.crm.autodesk.POMpages.ProductInfoPage;
import com.crm.autodesk.POMpages.ProductsPlusPage;
import GenericUtilities.BaseClass;

@Listeners(GenericUtilities.ListenerImplementationClass.class)
public class CreateProductTest extends BaseClass {
	@Test(groups = "regressionTest")
	public void createProduct() throws Throwable {
//data from excel
		String ProductName = eUtil.getDataFromExcel("Sheet1", 8, 1);
		HomePage homePage = new HomePage(driver);
		homePage.clickOnProducts();

		// click on plus button
		ProductsPlusPage productPlusBtn = new ProductsPlusPage(driver);
		productPlusBtn.clickProductPlusButton();

		// goto create product page
		NewProductPage prodPage = new NewProductPage(driver);

		prodPage.passProductName(ProductName);

		prodPage.saveButton();

		// verify ProductName Information

		ProductInfoPage verifyInfo = new ProductInfoPage(driver);

		String actHeaderMessage = verifyInfo.verifyHeaderText();
		Assert.assertEquals(actHeaderMessage.contains(ProductName), true);
		// logout function

	}

}
