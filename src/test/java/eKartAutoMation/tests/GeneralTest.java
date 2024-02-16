package eKartAutoMation.tests;

import org.testng.annotations.Test;

public class GeneralTest {

	@Test(priority = 0)
	public void loginPageTest() {
		System.out.println("Login Page");
	}

	@Test(priority = 1)
	public void AccPageTest() {
		System.out.println("Acc Page");
	}

}
