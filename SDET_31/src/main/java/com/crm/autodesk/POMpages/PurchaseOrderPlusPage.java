package com.crm.autodesk.POMpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PurchaseOrderPlusPage {

	@FindBy(xpath="//img[@title=\"Create Purchase Order...\"]")
	private WebElement purchaseOrderPlusBtn;
	
	public PurchaseOrderPlusPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getPurchaseOrderPlusBtn() {
		return purchaseOrderPlusBtn;
	}
	
	public void newPurchaseOrderBtn() {
		purchaseOrderPlusBtn.click();
	}
	
}
