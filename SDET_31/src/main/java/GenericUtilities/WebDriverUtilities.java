package GenericUtilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Contains all the methods for webDriver
 * 
 * @author Ramya
 *
 */
public class WebDriverUtilities {

	/**
	 * used to select values from dropdown using selectByVisibleText
	 * 
	 * @param ele
	 * @param driver
	 */
	public void select(WebElement ele, String text) {

		Select select = new Select(ele);
		select.selectByVisibleText(text);
	}

	/**
	 * used to select values from dropdown using selectByIndex
	 * 
	 * @param ele
	 * @param driver
	 */
	public void select(WebElement ele, int index) {

		Select select = new Select(ele);
		select.selectByIndex(index);
	}

	/**
	 * used to select values from dropdown using selectByValue
	 * 
	 * @param ele
	 * @param driver
	 */

	public void select(String value, WebElement ele) {

		Select select = new Select(ele);

		select.selectByValue(value);
	}

	/**
	 * action class methods: right clicks on the webElement
	 * 
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick(element).perform();
	}

	/**
	 * action class methods: double clicks on the webElement
	 * 
	 * @param driver
	 * @param element
	 */
	public void doubleClick(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.doubleClick(element).perform();
	}

	/**
	 * action class methods: mouseOver on the webElement
	 * 
	 * @param driver
	 * @param element
	 */
	public void mouseOver(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}

	/**
	 * action class methods: moveByOffset makes teh mouse control to reach the x and
	 * y value
	 * 
	 * @param x
	 * @param y
	 */

	public void moveByOffset(WebDriver driver, int x, int y) {
		Actions action = new Actions(driver);
		action.moveByOffset(0, 0).perform();
	}

	/**
	 * action class methods:drag and drop webElement from source to destination
	 * 
	 * @param driver
	 * @param src
	 * @param target
	 */
	public void dragAndDrop(WebDriver driver, WebElement src, WebElement target) {
		Actions action = new Actions(driver);
		action.dragAndDrop(src, target).perform();
	}

	/**
	 * switch window based on frame index parameter
	 * 
	 * @param driver
	 * @param index
	 */

	public void switchFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	/**
	 * switch window based on string parameter
	 * 
	 * @param driver
	 * @param index
	 */
	public void switchFrame(WebDriver driver, String text) {
		driver.switchTo().frame(text);
	}

	/**
	 * switches back to parent frame
	 * 
	 * @param driver
	 */
	public void switchBackToFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	/**
	 * Switching tabs from parent to child
	 * 
	 * @param driver
	 */
	public void switchTabs(WebDriver driver) {
		Set<String> child = driver.getWindowHandles();
		for (String c : child) {
			driver.switchTo().window(c);
		}
	}

	/**
	 * used to Switch to Any Window based on Window Title
	 * 
	 * @param driver
	 * @param partialWindowTitle
	 */
	public void switchToWindow(WebDriver driver, String partialWindowTitle) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();

		while (it.hasNext()) {
			String windowID = it.next();
			driver.switchTo().window(windowID);
			String currentWindowTitle = driver.getTitle();

			if (currentWindowTitle.contains(partialWindowTitle)) {
				break;
			}
		}
	}

	/**
	 * for handling alert popups by clicking accept()
	 * 
	 * @param driver
	 */
	public void alertPopupAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	/**
	 * used to Switch to Alert Window & click on Cancel button
	 * 
	 * @param driver
	 */
	public void alertPopupAndCancel(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	/**
	 * handle scroll bar functionality
	 * 
	 * @param driver
	 * @param x
	 * @param y
	 */
	public void scrollBar(WebDriver driver, int x, int y) {

		JavascriptExecutor jsExe = (JavascriptExecutor) driver;
		jsExe.executeScript("window.scrollBy( " + x + "," + y + ")");
	}

	/**-
	 * implicitly wait: waits for the page to load and can be used with FindElement
	 * and FindElements method only
	 * 
	 * @param driver
	 */
	public void waitForPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	/**
	 * Explicitly wait is used along with Expected Conditions.
	 * 
	 * @param driver
	 * @param element
	 */

	public void waitForElementPresent(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * used to wait for element to be clickable in GUI , & check for specific
	 * element for every 500 milli seconds
	 * 
	 * @param driver
	 * @param element
	 * @param pollingTime in the form second
	 * @throws Throwable
	 */
	public void waitForElementWithCumtomTimeOut(WebDriver driver, WebElement element, int pollingTime)
			throws Throwable {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.pollingEvery(pollingTime, TimeUnit.SECONDS);
		wait.wait(20);
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}

	/**
	 * Wait for JavaScript Elements to load
	 * 
	 * @param driver
	 * @param element
	 */
	public void waitForPageToLoadForJSElement(WebDriver driver, WebElement element) {
		driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
	}

	/**
	 * Takes screenshot of passed/failed testcases
	 * 
	 * @param driver
	 * @param screeshotName
	 * @return
	 * @throws IOException
	 */
	public String screenShot(WebDriver driver, String testCaseName) throws IOException {
		JavaUtilities jUtil = new JavaUtilities();

		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshot/" + testCaseName + jUtil.getSystemDateAndTime() + ".png");

		FileUtils.copyFile(src, dest);
		return dest.getAbsolutePath();
	}

	/**
	 * pass enter Key appertain in to Browser
	 * 
	 * @param driver
	 */
	public void passEnterKey(WebDriver driver) {
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
	}

	/**
	 * maximizes the broswer window
	 * 
	 * @param driver
	 */
	public void maximizeBrowserWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
}
