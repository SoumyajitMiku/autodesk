package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ContactFRomDPtest {

	@Test(dataProvider = "getData")

	public void MultipleDataPrint(String name, String mobileNo) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin123");
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();

		driver.findElement(By.name("lastname")).sendKeys(name);
		driver.findElement(By.name("mobile")).sendKeys(mobileNo);

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		WebElement mouseoverSignOutBtn = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));

		Actions action = new Actions(driver);
		action.moveToElement(mouseoverSignOutBtn);

		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		driver.quit();

		System.out.println("name" + name);

		System.out.println("mobileNo" + mobileNo);

		System.out.println("==============================");
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] objArray = new Object[5][2];

		objArray[0][0] = "Shailaja";
		objArray[0][1] = "6361412478";

		objArray[1][0] = "Renuka";
		objArray[1][1] = "6361412457";

		objArray[2][0] = "Sunanda";
		objArray[2][1] = "6361478457";

		objArray[3][0] = "Kabir";
		objArray[3][1] = "6361469457";

		objArray[4][0] = "Sujatha";
		objArray[4][1] = "6361417457";

		return objArray;

	}

}
