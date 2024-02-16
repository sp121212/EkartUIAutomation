package eKartAutoMation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import eKartAutoMation.base.BaseTest;


//@Listeners(ExtentReportListener.class)
public class LoginPageTest extends BaseTest{
	
	@Test(priority = 1)
	public void loginTitleTest() {
		String loginPageTitle=loginPage.getLoginPageTitle();
		Assert.assertEquals(loginPageTitle,"Let's Shop");
	}
	
	
	@Test(priority = 2)
	public void loginURLTest() {
		String actURL=loginPage.getURL();
		Assert.assertEquals(actURL, "https://rahulshettyacademy.com/client/auth/login");
	}
	
	
	@Test(priority = 3)
	public void isForgotPaswordLinkAvailble() {
		
		boolean flag=loginPage.isForgotPasswordLinkAvailble();
		Assert.assertTrue(flag);
	}
	
	@Test(priority = 4)
	public void doLoginTest() throws InterruptedException {
		loginPage.doLogin(prop.getProperty("username")  , prop.getProperty("password"));
		boolean flag=loginPage.isLogoPresent();
		Assert.assertTrue(flag);
	}
}
