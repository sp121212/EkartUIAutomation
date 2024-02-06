package eKartAutoMation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import eKartAutoMation.constant.AppConstants;

public class LoginPage {

	private WebDriver driver = null;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void doLogin() throws InterruptedException {
		driver.get(AppConstants.APP_URL);
		driver.findElement(By.id("userEmail")).sendKeys(AppConstants.APP_USERNAME);
		driver.findElement(By.id("userPassword")).sendKeys(AppConstants.APP_PASSWORD);
		driver.findElement(By.id("login")).click();
		
		Thread.sleep(5000);
	}

	public boolean isLogoPresent() {
		return driver.findElement(By.xpath("//h3[text()='Automation'] ")).isDisplayed();
	}

	public boolean isFilterOptionPresent() {
		return driver.findElement(By.xpath("(//div/h4[text()='Filters'])[position()=2]")).isDisplayed();
	}

}
