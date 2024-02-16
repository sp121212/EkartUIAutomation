package eKartAutoMation.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import eKartAutoMation.factory.DriverFactory;
import eKartAutoMation.pages.CartPage;
import eKartAutoMation.pages.DashBoardPage;
import eKartAutoMation.pages.LoginPage;

public class BaseTest {
	protected Properties prop=null;
	protected WebDriver driver=null;
	protected SoftAssert  softAssert=null;
	public DriverFactory driverFactory=null;
	protected LoginPage loginPage;
	protected DashBoardPage dashBoardPage;
	protected CartPage cartPage;
	
	@BeforeTest(alwaysRun = true)
	@Parameters({"browser"})
	public void setUp(@Optional("chrome") String browser) throws InterruptedException {
		driverFactory=new DriverFactory();
		prop=driverFactory.initProp();
		prop.setProperty("browser", browser);
		driver=driverFactory.initDriver();
		loginPage=new LoginPage(driver);
		softAssert=new SoftAssert();
	}
	
	
	@AfterTest(alwaysRun = true)
	public void tearDown() {
		driverFactory.quitDriver();
//		driver.quit();
	}
	
	
	

}
