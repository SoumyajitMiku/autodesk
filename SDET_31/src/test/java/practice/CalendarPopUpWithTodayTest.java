package practice;

import java.time.LocalDateTime;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import GenericUtilities.FileUtilitites;
import GenericUtilities.WebDriverUtilities;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * this class handles calendar pop with Today's date
 * 
 * @author Ramya
 *
 */
public class CalendarPopUpWithTodayTest {

	public static void main(String[] args) throws Throwable {
	//	LocalDateTime dateandtime = LocalDateTime.now(); //for today's date
		LocalDateTime dateandtime = LocalDateTime.now().plusDays(1); //for tomorrow's date
		int year = dateandtime.getYear();
		String month = dateandtime.getMonth().toString(); // if 3 is month then coverts to MARCH as string
		int date = dateandtime.getDayOfMonth();
		//to make the output MARCH to March
		String actualMonth = month.substring(0, 1) + month.substring(1).toLowerCase();
		String monthAndYear = actualMonth + " " + year;// to get output as 'March 2022'

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		WebDriverUtilities wUtil = new WebDriverUtilities();
		FileUtilitites fUtil = new FileUtilitites();

		wUtil.maximizeBrowserWindow(driver);
		wUtil.waitForPageLoad(driver);

		String calendarpopup = fUtil.getPropertyFiledata("calendarpopup");
		driver.get(calendarpopup);

		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();

		
		wUtil.moveByOffset(driver, 0, 0);

		driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();

		
		  wUtil.scrollBar(driver, 0, 50); 
		  wUtil.scrollBar(driver, 250, 0);
		 
		String datePath = "//div[text()='" + monthAndYear+ "']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='" + date + "']";

		for (;;) {
			try {
				driver.findElement(By.xpath(datePath)).click();
				break;
			} catch (Exception e) {
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();

			}
		}

		driver.findElement(By.xpath("//label[@for='fromCity']")).click();

		driver.findElement(By.xpath("//p[text()='Bangalore, India']")).click();
		driver.findElement(By.xpath("//label[@for='toCity']")).click();

		driver.findElement(By.xpath("//p[text()='Kolkata, India']")).click();

		driver.findElement(By.xpath("//a[text()='Search']")).click();

		List<WebElement> allFlights = driver.findElements(By.xpath("//span[@class='boldFont blackText airlineName']"));

		for (WebElement ele : allFlights) 
		{
			System.out.println("available flights are " + ele.getText());
		}

	}

}
