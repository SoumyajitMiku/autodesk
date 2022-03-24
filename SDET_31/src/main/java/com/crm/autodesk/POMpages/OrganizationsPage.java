package com.crm.autodesk.POMpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage 
{
		
	@FindBy (xpath= "//img[@title='Create Organization...']")
	private WebElement createOrganization;
	
	//initialization of web elements
	public OrganizationsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization of web elements
	
	public WebElement getCreateOrganization() {
		return createOrganization;
	}
	public void createOrganizationButton() {
		createOrganization.click();
	}
	

}
