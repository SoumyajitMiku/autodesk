package com.crm.autodeskselenium.PurchaseOrder;

import org.testng.annotations.Listeners;

import org.testng.annotations.Test;

import com.crm.autodesk.POMpages.HomePage;
import com.crm.autodesk.POMpages.NewPurchaseOrderPage;
import com.crm.autodesk.POMpages.NewVendorPage;
import com.crm.autodesk.POMpages.PurchaseOrderPlusPage;
import com.crm.autodesk.POMpages.VendorPlusPage;

import GenericUtilities.BaseClass;

/**
 * This class creates the vendor and creates a purchase order for that vendor
 * 
 * @author Ramya
 *
 */
@Listeners(GenericUtilities.ListenerImplementationClass.class)
public class CreatePurchaseOrderWithVendorTest extends BaseClass {
	@Test(groups = "smokeTest")

	public void purchaseOrder() throws Throwable {
		
		//data from excel
		String vendorName = eUtil.getDataFromExcel("Sheet1", 17, 1);
		String ProductName = eUtil.getDataFromExcel("Sheet1", 8, 1);
		String subject = eUtil.getDataFromExcel("Sheet1", 19, 2);
		String billingAddress = eUtil.getDataFromExcel("Sheet1", 19, 3);
		String Qty = eUtil.getDataFromExcel("Sheet1", 19, 5);

		HomePage homePage = new HomePage(driver);
		homePage.mouseOverOnMore(driver);
		homePage.clickOnVendors();

		VendorPlusPage vendorPage = new VendorPlusPage(driver);
		vendorPage.newVendorBtn();

		NewVendorPage createvendor = new NewVendorPage(driver);

		createvendor.vendorName(vendorName);
		createvendor.saveBtnClick();

		homePage.mouseOverOnMore(driver);
		homePage.clickOnPurchaseOrder();

		PurchaseOrderPlusPage purchaseOrderPlus = new PurchaseOrderPlusPage(driver);
		purchaseOrderPlus.newPurchaseOrderBtn();

		NewPurchaseOrderPage createPurchaseOrder = new NewPurchaseOrderPage(driver);

		createPurchaseOrder.subjectSendText(subject);
		createPurchaseOrder.vendorSelect(driver, vendorName);

		createPurchaseOrder.subjectSendText(subject);

		createPurchaseOrder.billingAddress(billingAddress);

		createPurchaseOrder.sameShippRadioClick();

		createPurchaseOrder.itemSelect(driver, ProductName);
		createPurchaseOrder.productSendText(ProductName);

		createPurchaseOrder.quantityText(Qty);

		createPurchaseOrder.saveClick();

	}
}
