package com.crm.autodesk.POMpages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtilities.WebDriverUtilities;

/**
 * this class creates organization with industry type of healthcare
 * 
 * @author Ramya
 *
 */
public class CreateOrganizationWithIndustryPage extends WebDriverUtilities {
	// declaration of web elements
	@FindBy(name = "accountname")
	private WebElement OrganizationNameTextField;

	@FindBy(name = "industry")
	private WebElement industryDD;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']") // cannot use dynmaic xpath with FindBy
	private WebElement saveButton;

	// initialization of web elements
	public CreateOrganizationWithIndustryPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// utilization of web elements
	public void createOrg(String orgName) {

		OrganizationNameTextField.sendKeys(orgName);

	}

	public void findOrg(WebDriver driver, String orgName) {
		List<WebElement> orgList = driver.findElements(By.xpath("//a[@title='Organizations']"));
		int i = 0;
		for (;;)

		{
			for (WebElement ele : orgList) {

				if (orgList.contains(orgName)) {
					ele.click();
				} else {
					driver.findElement(By.xpath("//img[@src='themes/images/next.gif']")).click();

				}

			}
			i++;
		}
	}

	public void withIndustry(String IndustryType) {
		select(industryDD, IndustryType);
	}

	public void saveClick() {

		saveButton.click();
	}

}
