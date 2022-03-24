package com.crm.autodesk.POMpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorPlusPage {
	
	@FindBy(xpath="//img[@title=\"Create Vendor...\"]")
	private WebElement vendorPlusBtn;
	
	public VendorPlusPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getVendorPlusBtn() {
		return vendorPlusBtn;
	}
	
	public void newVendorBtn() {
		vendorPlusBtn.click();
	}

}
