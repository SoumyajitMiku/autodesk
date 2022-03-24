package com.crm.autodesk.POMpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtilities.WebDriverUtilities;

public class NewCampaignPage extends WebDriverUtilities {
	@FindBy(name = "campaignname")
	private WebElement campaignNameField;

	@FindBy(xpath = "//img[@title='Select']")
	private WebElement prodPlusBtn;

	@FindBy(id = "search_txt")
	private WebElement searchBox;

	@FindBy(name = "search")
	private WebElement searchBtn;

	@FindBy(name = "product_name")
	private WebElement ProductNameField;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	public NewCampaignPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	public WebElement getSearchBox() {
		return searchBox;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public void setSaveBtn(WebElement saveBtn) {
		this.saveBtn = saveBtn;
	}

	public WebElement getCampaignNameField() {
		return campaignNameField;
	}

	public WebElement getProdPlusBtn() {
		return prodPlusBtn;
	}

	public WebElement getProductNameField() {
		return ProductNameField;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public void campNameText(String CampaignName) {
		campaignNameField.sendKeys(CampaignName);
	}

	public void productPlusBtn() {
		prodPlusBtn.click();
	}

	public void campPlusClick(WebDriver driver, String ProductName) {
		switchToWindow(driver, "Products");
		searchBox.sendKeys(ProductName);
		searchBtn.click();
		driver.findElement(By.xpath("//a[text()='" + ProductName + "']")).click();
		switchToWindow(driver, "Campaigns");
		
	}
	public void save() {
		saveBtn.click();
	}

	public void passProductNameField(String ProductName) {
		ProductNameField.sendKeys(ProductName);
	}
}
