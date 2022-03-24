package com.crm.autodesk.POMpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewVendorPage {
	@FindBy(name = "vendorname")
	private WebElement vendorTextField;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	public NewVendorPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getVendorTextField() {
		return vendorTextField;

	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public void vendorName(String vendorName) {
		vendorTextField.sendKeys(vendorName);
	}

	public void saveBtnClick() {
		saveBtn.click();
	}
}
