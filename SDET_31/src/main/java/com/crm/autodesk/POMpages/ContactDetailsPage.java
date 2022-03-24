package com.crm.autodesk.POMpages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mysql.cj.jdbc.Driver;

import GenericUtilities.WebDriverUtilities;

/**
 * this class is used to add contact in the contact page
 * 
 * @author Ramya
 *
 */
public class ContactDetailsPage extends WebDriverUtilities {
	// declaration of web elements

	@FindBy(xpath = "//input[@name='selected_id']")
	private List<WebElement> listOfCheckBoxes;

	@FindBy(xpath = "//input[@class='crmbutton small delete']")
	private WebElement deleteBtn;

	// initialization of web elements
	public ContactDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// utilization

	public WebElement getDeleteBtn() {
		return deleteBtn;
	}

	// business logic
	public List<WebElement> getListOfCheckBoxes() {
		return listOfCheckBoxes;
	}

	public void clickOnCheckBox(WebDriver driver) {
		int count = 0;

		for (WebElement ele : listOfCheckBoxes) {
			if (count < 2) {
				ele.click();
				count++;
			} else {
				break;
			}
		}
		
	}

	public void deleteName() {
		deleteBtn.click();
	}

	public void alertHandle(WebDriver driver) {
		alertPopupAndAccept(driver);
	}
}
