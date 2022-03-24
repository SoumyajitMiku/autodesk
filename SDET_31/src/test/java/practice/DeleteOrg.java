package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.crm.autodesk.POMpages.CreateOrganizationWithIndustryPage;
import com.crm.autodesk.POMpages.OrgInfoPage;
import com.crm.autodesk.POMpages.OrganizationsPage;
import com.crm.autodesk.POMpages.HomePage;
import com.crm.autodesk.POMpages.LoginPage;

import GenericUtilities.ExcelLibUtilities;
import GenericUtilities.FileUtilitites;
import GenericUtilities.WebDriverUtilities;
import GenericUtilities.JavaUtilities;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteOrg {

	public static void main(String[] args) throws Throwable {
		WebDriver driver = new ChromeDriver();
		JavaUtilities jutil = new JavaUtilities();
		ExcelLibUtilities elib = new ExcelLibUtilities();
		FileUtilitites fUtil = new FileUtilitites();
		WebDriverUtilities wUtils = new WebDriverUtilities();

		String browser_name = fUtil.getPropertyFiledata("browser_name");
		System.out.println("test script is running on "+browser_name);
		//example of run time polymorphism
		if(browser_name.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browser_name.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(browser_name.equalsIgnoreCase("IE"))
		{
			WebDriverManager.iedriver();
			driver = new InternetExplorerDriver();
		}
		else if(browser_name.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver();
			driver = new EdgeDriver();
		}
		
			
		wUtils.maximizeBrowserWindow(driver);
		wUtils.waitForPageLoad(driver);
		
		String url = fUtil.getPropertyFiledata("url");
		String username = fUtil.getPropertyFiledata("username");
		String password =  fUtil.getPropertyFiledata("password");
		
		//login page gets details of username and password from common data
		driver.get(url);
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(username, password);
		
		//click on organization link
		HomePage homePage = new HomePage(driver);
		homePage.clickOnOrganization();
		
		//click on + button to create organization
		OrganizationsPage orgPage =  new OrganizationsPage(driver);
		orgPage.createOrganizationButton();
		
		//get orgName and Industry from excel
		String orgName = elib.getDataFromExcel("Sheet1", 4, 0)+"_"+jutil.randomNumber();
		String IndustryType = elib.getDataFromExcel("Sheet1", 6, 1);
		
		
		//create new organization
		CreateOrganizationWithIndustryPage createOrg =  new CreateOrganizationWithIndustryPage(driver);
		createOrg.createOrg(orgName);	
		createOrg.withIndustry(IndustryType);
		createOrg.saveClick();
		/*
		//verify organization Information
		OrgInfo5Page orgInfo = new OrgInfo5Page(driver);
		orgInfo.verifyHeaderText(driver, orgName);
		
		//logout function
		homePage.signoutMouseOver(driver);
		homePage.signoutClick();
		
		*/
		createOrg.findOrg(driver, orgName);
	}

}
