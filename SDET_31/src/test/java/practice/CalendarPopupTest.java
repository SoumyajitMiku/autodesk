package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import GenericUtilities.ExcelLibUtilities;
import GenericUtilities.FileUtilitites;
import GenericUtilities.WebDriverUtilities;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CalendarPopupTest {

	public static void main(String[] args) throws Throwable {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		ExcelLibUtilities elib = new ExcelLibUtilities();
		WebDriverUtilities wUtil = new WebDriverUtilities();
		FileUtilitites fUtil = new FileUtilitites();

		wUtil.maximizeBrowserWindow(driver);
		wUtil.waitForPageLoad(driver);

		String calendarpopup = fUtil.getPropertyFiledata("calendarpopup");
		driver.get(calendarpopup);

		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();

		Actions act = new Actions(driver);
		act.moveByOffset(0, 0).click().perform();

		driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();

		wUtil.scrollBar(driver, 0, 50);
		wUtil.scrollBar(driver, 250, 0);

		String date = elib.getDataFromExcel("Sheet1", 13, 0);
		String monthAndYear = fUtil.getPropertyFiledata("monthAndYear");
		String datePath = "//div[text()='" + monthAndYear+ "']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='" + date + "']";

		for (;;) {
			try {
				driver.findElement(By.xpath(datePath)).click();
				break;
			} catch (Exception e) {
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();

			}
		}

	}

}
