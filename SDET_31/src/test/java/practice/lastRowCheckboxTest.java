package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import GenericUtilities.FileUtilitites;
import GenericUtilities.WebDriverUtilities;
import io.github.bonigarcia.wdm.WebDriverManager;

@Test
public class lastRowCheckboxTest {

	public void lastRowCheckBox() throws Throwable {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		WebDriverUtilities wutil = new WebDriverUtilities();
		FileUtilitites fUtil = new FileUtilitites();
		
		wutil.maximizeBrowserWindow(driver);
		wutil.waitForPageLoad(driver);
		
		String url = fUtil.getPropertyFiledata("url");
		driver.get(url);
		
		String username = fUtil.getPropertyFiledata("username");
		driver.findElement(By.name("user_name")).sendKeys(username);
		
		String password = fUtil.getPropertyFiledata("password");
		driver.findElement(By.name("user_password")).sendKeys(password);
		
		driver.findElement(By.id("submitButton")).click();

		driver.findElement(By.linkText("Opportunities")).click();
		driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[last()]/td[1]")).click();
		

	}
}
