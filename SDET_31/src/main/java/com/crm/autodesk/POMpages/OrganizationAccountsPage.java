package com.crm.autodesk.POMpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtilities.WebDriverUtilities;

/**
 * this page is the child window of organization accounts page
 * 
 * @author Ramya
 *
 */
public class OrganizationAccountsPage extends WebDriverUtilities {

	@FindBy(id = "search_txt")
	private WebElement searchBox;

	@FindBy(name = "search")
	private WebElement searchBtn;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']") // cannot use dynmaic xpath with FindBy
	private WebElement saveButton;

	public OrganizationAccountsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// utilization
	public WebElement getSearchBox() {
		return searchBox;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}
	public WebElement getSaveButton() {
		return saveButton;
	}

	// business logic switching to and from child window and saving operation
	public void searchTxtBox(String orgName, WebDriver driver) {

		switchToWindow(driver, "Accounts");
		searchBox.sendKeys(orgName);
		searchBtn.click();
		driver.findElement(By.xpath("//a[text()='" + orgName + "']")).click();
		switchToWindow(driver, "Contacts");
		saveButton.click();

	}

	

}
