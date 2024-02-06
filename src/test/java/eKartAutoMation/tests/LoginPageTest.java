package eKartAutoMation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import eKartAutoMation.base.BaseTest;

public class LoginPageTest extends BaseTest{
	
	
	@Test
	public void loginTitleTest() {
		
	}
	
	
	@Test
	public void loginURLTest() {
		
	}
	
	
	
	
	@Test
	public void isForgotPaswordLinkAvailble() {
		
	}
	
	
	@Test
	public void appLogoTest() {
		boolean flag=loginPage.isLogoPresent();
		Assert.assertTrue(flag);
	}
	
	@Test
	public void filterAvailablilityTest() {
		boolean flag=loginPage.isFilterOptionPresent();
		Assert.assertTrue(flag);
	}

}
