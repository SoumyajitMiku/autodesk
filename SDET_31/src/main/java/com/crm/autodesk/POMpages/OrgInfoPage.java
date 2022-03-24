package com.crm.autodesk.POMpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
/**
 * This class is for verifying the header text of organization
 * @author Ramya
 *
 */
public class OrgInfoPage 
{
	//declaration
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement headerText;
	
	//initialization
	public OrgInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//business logic
	public String verifyHeaderText() 
	{			
		return headerText.getText();
		
	}	
}
