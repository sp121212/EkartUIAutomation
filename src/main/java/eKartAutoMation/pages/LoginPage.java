package eKartAutoMation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import eKartAutoMation.constant.AppConstants;
import eKartAutoMation.utils.ElementsUtils;

public class LoginPage {

	private WebDriver driver = null;
	private ElementsUtils eleUtil=null;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		this.eleUtil=new ElementsUtils(driver);
	}
	
	
	//Locators
	By userEmailLoc=By.id("userEmail");
	By userPasswordLoc=By.id("userPassword");
	By loginButtonLoc=By.id("login");
	By logoLoc=By.xpath("//h3[text()='Automation']");
	By filterOptionLoc=By.xpath("(//div/h4[text()='Filters'])[position()=2]");
	By forgotPasswordLoc=By.linkText("Forgot password?");
	

	public String getLoginPageTitle() {
		return eleUtil.getCurrentPageTitle();
	}
	
	public String getURL() {
		return eleUtil.getCurrentPageURL();
	}
	
	public boolean isLogoPresent() throws InterruptedException {
		return eleUtil.isDisPlayedWithWait(logoLoc,AppConstants.MEDIUM_WAIT);
	}
	
	public boolean isFilterOptionPresent() {
		return eleUtil.isDisPlayed(filterOptionLoc);
	}

	public boolean isForgotPasswordLinkAvailble() {
		return eleUtil.isDisPlayed(forgotPasswordLoc);
	}
	
	
	public DashBoardPage doLogin(String userName,String password) throws InterruptedException {
		eleUtil.doSendKeys(userEmailLoc, userName);
		eleUtil.doSendKeys(userPasswordLoc,password);
		eleUtil.doClick(loginButtonLoc);
		System.out.println("application is loggedin successfully, usinmg cred u/n: "+userName +" and p/w: "+password);
		return new DashBoardPage(driver);
	}
	
}


