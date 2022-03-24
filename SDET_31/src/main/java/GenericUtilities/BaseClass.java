package GenericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.crm.autodesk.POMpages.HomePage;
import com.crm.autodesk.POMpages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public JavaUtilities jUtil = new JavaUtilities();
	public ExcelLibUtilities eUtil = new ExcelLibUtilities();
	public FileUtilitites fUtil = new FileUtilitites();
	public WebDriverUtilities wUtil = new WebDriverUtilities();
	public WebDriver driver = null;
	public static WebDriver sDriver;

	@BeforeSuite(groups = { "smokeTest", "regressionTest" })
	public void beforeSuite() {
		System.out.println("for db connection, logs and reports");
	}

	@BeforeTest(groups = { "smokeTest", "regressionTest" })
	public void beforeTest() {
		System.out.println("for parallel executions");
	}

//	@Parameters("browser")
	@BeforeClass(groups = { "smokeTest", "regressionTest" })
	public void beforeClass() throws Throwable {
		System.out.println("launching the browser");
		String browser_name = fUtil.getPropertyFiledata("browser_name");
		String url = fUtil.getPropertyFiledata("url");

		// example of run time polymorphism
		if (browser_name.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser_name.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser_name.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver();
			driver = new InternetExplorerDriver();
		} else if (browser_name.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver();
			driver = new EdgeDriver();
		}

		wUtil.maximizeBrowserWindow(driver);
		wUtil.waitForPageLoad(driver);
		driver.get(url);
		sDriver=driver;
	}

	@BeforeMethod(groups = { "smokeTest", "regressionTest" })
	public void beforeMethod() throws Throwable {
		String username = fUtil.getPropertyFiledata("username");
		String password = fUtil.getPropertyFiledata("password");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(username, password);
	}

	@AfterMethod(groups = { "smokeTest", "regressionTest" })
	public void afterMethod() {

		HomePage homePage = new HomePage(driver);
		homePage.signoutMouseOver(driver);
	}

	@AfterClass(groups = { "smokeTest", "regressionTest" })
	public void afterClass() {
		driver.quit();
	}

	@AfterTest(groups = { "smokeTest", "regressionTest" })
	public void afterTest() {
		System.out.println("close parallel executions");
	}

	@AfterSuite(groups = { "smokeTest", "regressionTest" })
	public void afterSuite() {
		System.out.println("close db connections ");
	}

}
