package practice;

import java.time.LocalDateTime;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import GenericUtilities.FileUtilitites;
import GenericUtilities.WebDriverUtilities;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ibibo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		WebDriverUtilities wutil = new WebDriverUtilities();
		FileUtilitites fUtil = new FileUtilitites();
		wutil.maximizeBrowserWindow(driver);
		wutil.waitForPageLoad(driver);
		
		driver.get("https://www.goibibo.com/");
		driver.findElement(By.xpath("//a[text()='Hotels']")).click();
		
		//click india radio button
		
		driver.findElement(By.xpath("//h4[text()='India']")).click();
		//place text
		String Place ="Dubai";
		driver.findElement(By.xpath("//input[@data-testid='home-autosuggest-input']")).sendKeys(Place);
		
		driver.findElement(By.xpath("//div[text()='Check-in']")).click();
		
//calendar
		
	/*	  LocalDateTime dateandtime = LocalDateTime.now();
		   int year = dateandtime.getYear(); 
		  String month = dateandtime.getMonth().toString(); // if 3 is month then coverts to MARCH as string
		  int date = dateandtime.getDayOfMonth(); //to make the output MARCH to March 
		  String actualMonth = month.substring(0, 1) + month.substring(1).toLowerCase(); 
		 String monthAndYear = actualMonth + " " + year;
		 
		  String datePath = "//div[text()='" + monthAndYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='" + date +"']"; 
		  for (;;) {
		   try { 
		   driver.findElement(By.xpath(datePath)).click();
		    break;
		 
		 } catch (Exception e) {
		  driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
		  
		 } }
		 */
		 
		//from date
		driver.findElement(By.xpath("//li[@data-testid='date_li_31_2_2022']")).click();
		driver.findElement(By.xpath("//li[@data-testid='date_li_1_3_2022']")).click();
		//room selection
		driver.findElement(By.xpath("//span[text()='Guests & Rooms']")).click();
		
		//driver.findElement(By.xpath("//span[text()='Rooms']/parent::div/descendant::span[text()='+']")).click();
		//driver.findElement(By.xpath("//span[text()='Adults']/parent::div/descendant::span[text()='+']")).click();
		
		driver.findElement(By.xpath("//span[text()='Children']/parent::div/descendant::span[text()='+']")).click();
		
		WebElement dropdown = driver.findElement(By.xpath("//span[text()='Child ']/following::div/descendant::span[@class='PaxWidgetstyles__ContentActionIconWrapperSpan-sc-gv3w6r-8 dxKRvV']"));
		
		wutil.select(dropdown, 2);
		//driver.findElement(By.xpath("")).click();
		
			
		//search hotels
		driver.findElement(By.xpath("//button[text()='Search Hotels']")).click();
		

	}

}
