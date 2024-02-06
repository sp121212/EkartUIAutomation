package eKartAutoMation.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import eKartAutoMation.factory.DriverFactory;
import eKartAutoMation.pages.LoginPage;

public class BaseTest {
	Properties prop=null;
	WebDriver driver=null;
	public DriverFactory driverFactory=null;
	public LoginPage loginPage;
	
	@BeforeTest
	@Parameters({"browser"})
	public void setUp(@Optional("chrome") String browser) throws InterruptedException {
		driverFactory=new DriverFactory();
		prop=driverFactory.initProp("browser", browser);
		driver=driverFactory.initDriver();
		loginPage=new LoginPage(driver);
		loginPage.doLogin();
	}
	
	
	@AfterTest
	public void tearDown() {
		driverFactory.quitDriver();
	}
	
	
	

}
