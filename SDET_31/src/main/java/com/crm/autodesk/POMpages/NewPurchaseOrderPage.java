package com.crm.autodesk.POMpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtilities.WebDriverUtilities;

public class NewPurchaseOrderPage extends WebDriverUtilities {
	@FindBy(name = "subject")
	private WebElement subjectTxtField;

	@FindBy(xpath = "//img[@title='Select']")
	private WebElement vendorPlusBtn;

	@FindBy(id = "search_txt")
	private WebElement searchBox;

	@FindBy(name = "search")
	private WebElement searchBtn;

	@FindBy(name = "product_name")
	private WebElement vendorNameField;

	@FindBy(xpath = "//textarea[@name='bill_street']")
	private WebElement billingAdds;

	@FindBy(xpath = "//textarea[@name='ship_street']")
	private WebElement shippingAdds;

	@FindBy(xpath = "//input[contains(@name,'productName1')]")
	private WebElement itemNameTxtField;

	@FindBy(xpath = "//img[contains(@id,'searchIcon1')]")
	private WebElement productsSelectIcon;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	@FindBy(xpath = "//input[@onclick='return copyAddressRight(EditView)']")
	private WebElement radioBtn;

	@FindBy(name = "qty1")
	private WebElement qtyTxtField;

	public NewPurchaseOrderPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getBillingAdds() {
		return billingAdds;
	}

	public WebElement getShippingAdds() {
		return shippingAdds;
	}

	public WebElement getItemNameTxtField() {
		return itemNameTxtField;
	}

	public WebElement getProductsSelectIcon() {
		return productsSelectIcon;
	}

	public WebElement getRadioBtn() {
		return radioBtn;
	}

	public WebElement getQtyTxtField() {
		return qtyTxtField;
	}

//business logic
	public void subjectSendText(String vendorName) {
		subjectTxtField.sendKeys(vendorName);
	}

	public void vendorSelect(WebDriver driver, String vendorName) {
		vendorPlusBtn.click();
		switchToWindow(driver, "Vendors");
		searchBox.sendKeys(vendorName);
		searchBtn.click();
		driver.findElement(By.xpath("//a[text()='" + vendorName + "']")).click();
		switchToWindow(driver, "PurchaseOrder");

	}

	public void billingAddress(String billingAddress) {
		billingAdds.sendKeys(billingAddress);
	}

	public void sameShippRadioClick() {
		radioBtn.click();
	}

	public void productSendText(String ProductName) {
		itemNameTxtField.sendKeys(ProductName);
	}

	public void itemSelect(WebDriver driver, String ProductName) {

		productsSelectIcon.click();
		switchToWindow(driver, "Products");
		searchBox.sendKeys(ProductName);
		searchBtn.click();
		driver.findElement(By.xpath("//a[text()='" + ProductName + "']")).click();
		switchToWindow(driver, "PurchaseOrder");

	}

	public void quantityText(String Qty) {
		qtyTxtField.sendKeys(Qty);
	}

	public void saveClick() {
		saveBtn.click();
	}

}
