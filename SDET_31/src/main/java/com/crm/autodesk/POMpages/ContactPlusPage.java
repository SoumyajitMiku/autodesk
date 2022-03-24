package com.crm.autodesk.POMpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPlusPage {
	
	//declaration of web elements
	@FindBy (xpath= "//img[@title='Create Contact...']")
	private WebElement clickPlusButton;
	
	//initialization of web elements
	public ContactPlusPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//utilization of web elements
	
	public WebElement getClickPlusButton() {
		return clickPlusButton;
	}
	//business logic
	public void clickContactPlusButton() {
		clickPlusButton.click();
	}
	
	
	
}
