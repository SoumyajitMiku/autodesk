package com.crm.autodesk.POMpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtilities.WebDriverUtilities;

public class NewContactPage extends WebDriverUtilities{
	// declaration of web elements

	
	@FindBy(xpath = "//input[@name='lastname']")
	private WebElement lastNameField;

	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img")
	private WebElement plusOrgNameBtn;
	
	@FindBy(name = "account_name")
	private WebElement passOrgNameTextField;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	@FindBy(xpath = "//input[@value='T']")
	private WebElement selectGroupRadio;

	@FindBy(xpath = "//select[@name='assigned_group_id']")
	private WebElement dropdownValue;

	// initialization of web elements
	public NewContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getSelectGroupRadio() {
		return selectGroupRadio;
	}

	public void setSelectGroupRadio(WebElement selectGroupRadio) {
		this.selectGroupRadio = selectGroupRadio;
	}

	public WebElement getLastNameField() {
		return lastNameField;
	}

	public WebElement getPlusOrgNameBtn() {
		return plusOrgNameBtn;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	// business logic
	public void passLastName(String lastName) {
		lastNameField.sendKeys(lastName);
	}

	public void plusOrgClick(WebDriver driver) {
		plusOrgNameBtn.click();
		switchToWindow(driver, "Accounts");
	}
	public void sendOrgName(String orgName) {
		passOrgNameTextField.sendKeys(orgName);
	}

	public void saveButton() {
		saveBtn.click();

	}

	public void selectGroup() {
		selectGroupRadio.isSelected();
	}

	public void teamSellingDD(String TeamSellingGroup) {

		select(dropdownValue, TeamSellingGroup);

	}

}
