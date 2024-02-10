package eKartAutoMation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import eKartAutoMation.base.BaseTest;
import eKartAutoMation.constant.AppConstants;

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
		loginPage.doLogin(AppConstants.APP_USERNAME,AppConstants.APP_PASSWORD);
		boolean flag=loginPage.isLogoPresent();
		Assert.assertTrue(flag);
	}
}
