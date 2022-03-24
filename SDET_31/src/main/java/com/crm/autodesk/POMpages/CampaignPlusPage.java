package com.crm.autodesk.POMpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtilities.ExcelLibUtilities;
import GenericUtilities.WebDriverUtilities;
import GenericUtilities.JavaUtilities;

public class CampaignPlusPage {
	
	
	ExcelLibUtilities eUtil = new ExcelLibUtilities();
	WebDriverUtilities wUtil = new WebDriverUtilities();
	JavaUtilities jUtil = new JavaUtilities();

	// declaration of web elements
	@FindBy(xpath = "//img[@title='Create Campaign...']")
	private WebElement clickCampaignPlusButton;

	// initialization of web elements
	public CampaignPlusPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	// utilization of web elements

	public WebElement getClickCampaignPlusButton() {
		return clickCampaignPlusButton;
	}

	// business logic
	public void campaignPlusButton() {
		clickCampaignPlusButton.click();
	}
}
