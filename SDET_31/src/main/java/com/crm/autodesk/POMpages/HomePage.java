package com.crm.autodesk.POMpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtilities.WebDriverUtilities;

public class HomePage extends WebDriverUtilities {

	// declaration of web elements
	@FindBy(linkText = "Organizations")
	private WebElement OrganizationsLink;

	@FindBy(linkText = "Contacts")
	private WebElement ContactsLink;

	@FindBy(linkText = "Products")
	private WebElement ProductsLink;

	@FindBy(linkText = "More")
	private WebElement MoreLink;

	@FindBy(name = "Campaigns")
	private WebElement campaignLink;
	
	@FindBy(name="Purchase Order")
	private WebElement purchaseOrderLink;

	@FindBy(name="Vendors")
	private WebElement VendorsLink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement signoutIcon;

	@FindBy(linkText = "Sign Out")
	private WebElement SignoutLink;

	// initialization of web elements
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
//getters methods
	public WebElement getOrganizationsLink() {
		return OrganizationsLink;
	}

	public WebElement getContacts() {
		return ContactsLink;
	}

	public WebElement getMoreLink() {
		return MoreLink;
	}
	public WebElement getContactsLink() {
		return ContactsLink;
	}

	public WebElement getProductsLink() {
		return ProductsLink;
	}

	public WebElement getCampaignLink() {
		return campaignLink;
	}

	public WebElement getSignoutIcon() {
		return signoutIcon;
	}

	public WebElement getSignoutLink() {
		return SignoutLink;
	}
	
	public WebElement getVendorsLink() {
		return VendorsLink;
	}
	public WebElement getPurchaseOrderLink() {
		return purchaseOrderLink;
	}
	// business logic
	public void clickOnOrganization() {
		OrganizationsLink.click();
	}

	public void clickOnContacts() {
		ContactsLink.click();
	}

	public void mouseOverOnContacts(WebDriver driver) {
		mouseOver(driver, ContactsLink);
		ContactsLink.click();
	}

	public void clickOnProducts() {
		ProductsLink.click();
	}

	public void mouseOverOnMore(WebDriver driver) {
		mouseOver(driver, MoreLink);
	}

	public void clickOnCampaign() {
		campaignLink.click();
	}
	public void clickOnPurchaseOrder() {
		purchaseOrderLink.click();
	}
	public void clickOnVendors() {
		VendorsLink.click();
	}

	public void signoutMouseOver(WebDriver driver) {
		mouseOver(driver, signoutIcon);
	}

	public void signoutClick() {
		SignoutLink.click();
	}

}
