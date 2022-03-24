package Scripts;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SampleTest {

	public static void main(String[] args) throws Exception 
	{
		
		ChromeOptions option = new ChromeOptions();
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(option);
		driver.get("http://localhost:8888");
		
		Random random= new Random();
		int ranNum = random.nextInt(100);
		String orgName = "ramya" + ranNum;
		
		ExcelLib lib = new ExcelLib();
		
		 String username = lib.getExcelData("credentials", 0, 0);
		 String password = lib.getExcelData("credentials", 0, 1);
		 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		String actHeaderMessage = driver.findElement(By.className("dvHeaderText")).getText();
		
		if(actHeaderMessage.contains(orgName))
		{
			System.out.println(orgName + " is verified = pass");
		}
		else
		{
			System.out.println(orgName + " is not verified =  fail");
		}
		
		WebElement mouseoverSignOutBtn = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act= new Actions(driver);
		act.moveToElement(mouseoverSignOutBtn).perform();
		
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		driver.quit();
		
				
	}

}
