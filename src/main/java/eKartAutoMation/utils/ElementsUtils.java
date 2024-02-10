package eKartAutoMation.utils;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import eKartAutoMation.constant.AppConstants;


public class ElementsUtils {
	
	private WebDriver driver=null;
	
	
	public ElementsUtils(WebDriver driver) {
		this.driver=driver;
	}
	
	
	/**
	 * This method will fetch the current page url.
	 * @return
	 */
	public String getCurrentPageURL() {
		return driver.getCurrentUrl();
	}
	
	
	/**
	 * This method will fetch the title
	 * @return
	 */
	public String getCurrentPageTitle() {
		return driver.getTitle();
	}
	
	/**
	 * This method will use globally to click on elements
	 * @param loc
	 */
	public void doClick(By loc) {
		driver.findElement(loc).click();
	}
	
	
	public void doClick(WebElement ele) {
		ele.click();
	}
	
	/**
	 * This method will use globally to sendkeys on textbox elements.
	 * @param loc
	 * @param input
	 */
	public void doSendKeys(By loc,String input) {
		driver.findElement(loc).sendKeys(input);
	}
	 
	
	/**
	 * This method will return a boolean value that the element is really disalyed on HTML DOM or NOT
	 * @param loc
	 * @return
	 */
	public boolean isDisPlayed(By loc) {
		return  driver.findElement(loc).isDisplayed();
	}
	
	/**
	 * This method will return a boolean value that the element is really enabled or disabled.
	 * @param loc
	 * @return
	 */
	public boolean isEnabled(By loc) {
		return  driver.findElement(loc).isEnabled();
	}
	
	/**
	 *  This method will return a boolean value that the element is really selected or unselected.
	 * @param loc
	 * @return
	 */
	public boolean isSelected(By loc) {
		return  driver.findElement(loc).isSelected();
	}

	
	/**
	 * GetText using By loc
	 * @param ele
	 * @return
	 */
	public String getText(By loc) {
		return driver.findElement(loc).getText();
	}
	
	/**
	 * GetText using WebElement
	 * @param ele
	 * @return
	 */
	public String getText(WebElement ele) {
		return ele.getText();
	}
	
	
	// *****************************************  GENERIC FUNCTION WITH WAIT ************************************
	
	public WebElement waitForVisibilityOfElement(By loc, long waitTime) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(waitTime));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(loc));
	}
	
	public WebElement waitForVisibilityOfElement(WebElement ele, long waitTime) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(waitTime));
		return wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	
	
	public List<WebElement> waitForVisibilityOfElements(By loc, long waitTime) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(waitTime));
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(loc));
	}
	
	
	public WebElement waitForPresenceOfElement(By loc,  long waitTime) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(waitTime));
		return wait.until(ExpectedConditions.presenceOfElementLocated(loc));
	}
	
	public List<WebElement> waitForPresenceOfElements(By loc, long waitTime) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(waitTime));
		return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(loc));
	}
	

	
	
	
	public boolean isDisPlayedWithWait(By loc,long waitTime) {
		WebElement ele=waitForVisibilityOfElement(loc, waitTime);
		return ele.isDisplayed();
	}
	
	public void doClickWithWait(By loc,long waitTime) {
		WebElement ele=waitForVisibilityOfElement(loc, waitTime);
		ele.click();
	}
	
	public void doClickWithWait(WebElement ele,long waitTime) {
		waitForVisibilityOfElement(ele, waitTime).click();
	}
	
	
	public void doSendKeysWithWait(By loc,long waitTime,String input) {
		WebElement ele=waitForVisibilityOfElement(loc, waitTime);
		ele.sendKeys(input);
	}
	
	
	public List<WebElement> getListOfElementWithWait(By loc,long waitTime) {
		List<WebElement> eleList= waitForVisibilityOfElements(loc,waitTime);
		return eleList;
	}
	
	
	/**
	 * Action Utils
	 */
	
	/**
	 * /**
	 * doClickWithActions with By locator.
	 * @param ele
	 */
	public void doClickWithActions(By loc) {
		Actions action =new Actions(driver);
		action.click(driver.findElement(loc)).pause(Duration.ofMillis(AppConstants.SHORT_WAIT)).build().perform();
	}
	
	/**
	 * doClickWithActions with WebElement.
	 * @param ele
	 */
	public void doClickWithActions(WebElement ele) {
		Actions action =new Actions(driver);
		action.click(ele).pause(Duration.ofMillis(AppConstants.SHORT_WAIT)).build().perform();
	}
	
	
	public void doSendKeysWithActions(By loc,String input) {
		Actions action =new Actions(driver);
		action.sendKeys(driver.findElement(loc),input).build().perform();
	}
	
}
