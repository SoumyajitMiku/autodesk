package com.crm.autodesk.POMpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
/** 
 * This class is used to verify product name
 * @author Ramya
 *
 */
public class ProductInfoPage {

	// declaration
	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	private WebElement headerText;

	// initialization
	public ProductInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// business logic
	public String verifyHeaderText() 
	{			
		return headerText.getText();
		
	}

}
