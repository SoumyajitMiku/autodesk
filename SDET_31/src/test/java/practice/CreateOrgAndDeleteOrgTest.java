package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import GenericUtilities.BaseClass;
import GenericUtilities.ExcelLibUtilities;
import GenericUtilities.FileUtilitites;
import GenericUtilities.WebDriverUtilities;
import GenericUtilities.JavaUtilities;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrgAndDeleteOrgTest extends BaseClass {
	@Test
	public void createOrgDeleteOrg() throws Throwable {

		// 3rd scenario starts here contact field
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		String orgName = eUtil.getDataFromExcel("Sheet1", 4, 0) + "_" + jUtil.randomNumber();
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		
	/*	if (actHeaderMessage.contains(orgName)) {
			System.out.println(orgName + " is verified = pass");
		} else {
			System.out.println(orgName + " is not verified =  fail");
		}*/
		
		//verification
		String actHeaderMessage = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();

		Assert.assertEquals( actHeaderMessage.contains(orgName),true);
		
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();

		// fetch the list of organizations

		for (;;)

		{
			try {
				List<WebElement> orgList = driver.findElements(By.xpath("//a[@title='Organizations']"));

				for (WebElement ele : orgList) {

					if (ele.equals(orgName)) {
						System.out.println("org created successfully");
						break;
					} else {
						driver.findElement(By.xpath("//img[@src='themes/images/next.gif']")).click();
						Thread.sleep(2000);
					}
				}

			} catch (Exception e) {

				driver.findElement(By.linkText(orgName)).click();

				break;
			}

		}
		driver.findElement(By.xpath("//input[@value='Delete']")).click();
		System.out.println(orgName + "  deleted successfully  ");
		wUtil.alertPopupAndAccept(driver);

		// logout functionality
	}
}
