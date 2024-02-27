package eKartAutoMation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import eKartAutoMation.constant.AppConstants;
import eKartAutoMation.utils.ElementsUtils;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;


@Epic("Login Page")
@Feature("App Login feature")
@Story("US-5998")
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
	

	@Step("verify login page title")
	public String getLoginPageTitle() {
		return eleUtil.getCurrentPageTitle();
	}
	
	@Step("verify login page url")
	public String getURL() {
		return eleUtil.getCurrentPageURL();
	}
	
	@Step("verify app logo")
	public boolean isLogoPresent() throws InterruptedException {
		return eleUtil.isDisPlayedWithWait(logoLoc,AppConstants.MEDIUM_WAIT);
	}
	
	@Step("verify app filter option")
	public boolean isFilterOptionPresent() {
		return eleUtil.isDisPlayed(filterOptionLoc);
	}

	@Step("verify app forgot password link")
	public boolean isForgotPasswordLinkAvailble() {
		return eleUtil.isDisPlayed(forgotPasswordLoc);
	}
	
	@Story("")
	
	@Step("verify the login logic using user_name: {0} and password: {1}")
	public DashBoardPage doLogin(String userName,String password) {
		eleUtil.doSendKeys(userEmailLoc, userName);
		eleUtil.doSendKeys(userPasswordLoc,password);
		eleUtil.doClick(loginButtonLoc);
		System.out.println("application is loggedin successfully, usinmg cred u/n: "+userName +" and p/w: "+password);
		return new DashBoardPage(driver);
	}
	
}


