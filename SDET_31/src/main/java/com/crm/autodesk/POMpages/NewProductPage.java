package com.crm.autodesk.POMpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtilities.WebDriverUtilities;

public class NewProductPage {

	WebDriverUtilities wUtils = new WebDriverUtilities();
	@FindBy(name = "productname")
	private WebElement prodNametextField;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	public NewProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebDriverUtilities getwUtils() {
		return wUtils;
	}

	public WebElement getProdNametextField() {
		return prodNametextField;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	public void passProductName(String ProductName) {
		prodNametextField.sendKeys(ProductName);
	}
	public void saveButton() {
		saveBtn.click();

	}

}
