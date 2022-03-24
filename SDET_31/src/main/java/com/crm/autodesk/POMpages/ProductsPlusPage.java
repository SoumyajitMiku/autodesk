package com.crm.autodesk.POMpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPlusPage 
{

	
	//declaration of web elements
	@FindBy (xpath= "//img[@title='Create Product...']")
	private WebElement clickPlusButton;
	
	//initialization of web elements
	public ProductsPlusPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//utilization of web elements
	public WebElement getClickPlusButton() {
		return clickPlusButton;
	}
	//business logic
	public void clickProductPlusButton() {
		clickPlusButton.click();
	}
}
