package eKartAutoMation.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import eKartAutoMation.constant.AppConstants;
import eKartAutoMation.utils.ElementsUtils;

public class CartPage {

	// Setup

	private WebDriver driver = null;
	ElementsUtils eleUtil = null;

	public CartPage(WebDriver driver) {
		this.driver = driver;
		this.eleUtil = new ElementsUtils(driver);
	}

	// page locators
	By itemNamesLoc = By.xpath("//div[@class='infoWrap']/div/h3");
    By itemPricesLoc=By.xpath("(//div[@class='infoWrap']/div/p) [position() mod 4=2]");
    By itemStucksLoc=By.xpath("(//div[@class='infoWrap']/div/p) [position() mod 4=3]");
    
    
	// Page actions
	Map<String, String> cartItems = new HashMap<>();

	public String getPageTitle() {
		return eleUtil.getCurrentPageTitle();
	}

	public String getCartPageUrl() {

		return eleUtil.getCurrentPageURL();

	}

	private void getItemsNameList() {
		List<WebElement> itemsNameList = eleUtil.getListOfElementWithWait(itemNamesLoc, AppConstants.MEDIUM_WAIT);
		for (WebElement itemName : itemsNameList) {
			cartItems.put("itemName", eleUtil.getText(itemName));
		}
	}
	
	private void getItemsPriceList() {
		List<WebElement> itemsPriceList = eleUtil.getListOfElementWithWait(itemPricesLoc, AppConstants.MEDIUM_WAIT);
		for (WebElement itemPrice : itemsPriceList) {
			cartItems.put("itemPrice", eleUtil.getText(itemPrice));
		}
	}
	
	private void getItemsStuckStatusList() {
		List<WebElement> itemsStuckList = eleUtil.getListOfElementWithWait(itemStucksLoc, AppConstants.MEDIUM_WAIT);
		for (WebElement itemStuck : itemsStuckList) {
			cartItems.put("itemStuckStatus", eleUtil.getText(itemStuck));
		}
	}

	public Map<String, String> getAllItemsonCartPage() {
		getItemsNameList();
		getItemsPriceList();
		getItemsStuckStatusList();
		return cartItems;
	}

}
