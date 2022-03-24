package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import GenericUtilities.ExcelLibUtilities;
import GenericUtilities.FileUtilitites;
import GenericUtilities.WebDriverUtilities;
import GenericUtilities.JavaUtilities;
import io.github.bonigarcia.wdm.WebDriverManager;

public class IndustryTypeHardCode {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub


		JavaUtilities jLib = new JavaUtilities();
		ExcelLibUtilities eLib = new ExcelLibUtilities();
		FileUtilitites fUtil = new FileUtilitites();
		WebDriverUtilities wUtils = new WebDriverUtilities();
		WebDriver driver = null;
		
		
		
		//code for fetching Common data 
		fUtil.getPropertyFiledata("browser_name");
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
		String url =  fUtil.getPropertyFiledata("url");
		String username = fUtil.getPropertyFiledata("username");
		String password = fUtil.getPropertyFiledata("password");
		
		//getting data from Common data file
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		//get OrgName from excel file eg: SAP
		String orgName = eLib.getDataFromExcel("Sheet1", 2, 0)+jLib.randomNumber();
		
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		
		
		//2nd scenario select Healthcare 
		
		WebElement dropdown = driver.findElement(By.name("industry"));
		String industryType = eLib.getDataFromExcel("Sheet1", 6, 1);
		wUtils.select(dropdown, industryType);
		//save Org Details code
		
	
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		String actHeaderMessage = driver.findElement(By.className("dvHeaderText")).getText();
		//confirm if org Name has come
		if(actHeaderMessage.contains(orgName))
		{
			System.out.println(orgName + " is verified = pass");
		}
		else
		{
			System.out.println(orgName + " is not verified =  fail");
		}
		
		//logout functionality
		WebElement mouseoverSignOutBtn = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wUtils.mouseOver(driver, mouseoverSignOutBtn);
		
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		driver.quit();
		
	}

}
