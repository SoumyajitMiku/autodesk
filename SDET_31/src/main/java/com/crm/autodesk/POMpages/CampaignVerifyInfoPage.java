package com.crm.autodesk.POMpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
/**
 * This class is for verifying the header text of campaign
 * @author Ramya
 *
 */
public class CampaignVerifyInfoPage {
	//declaration
		@FindBy(xpath="//span[@class='dvHeaderText']")
		private WebElement headerText;
		
		//initialization
		public CampaignVerifyInfoPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		
		//business logic
		public String verifyHeaderText() 
		{			
			return headerText.getText();
			
			
		}
}
