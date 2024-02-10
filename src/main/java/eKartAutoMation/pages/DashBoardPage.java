package eKartAutoMation.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;

import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;

import eKartAutoMation.constant.AppConstants;
import eKartAutoMation.utils.CommonUtils;
import eKartAutoMation.utils.ElementsUtils;
import eKartAutoMation.utils.JavaScriptUtils;

public class DashBoardPage {

	private WebDriver driver = null;
	private ElementsUtils eleUtil = null;
	private JavaScriptUtils jsUtil = null;
	private CommonUtils commonUtils;

	public DashBoardPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementsUtils(driver);
		commonUtils = new CommonUtils();
		jsUtil = new JavaScriptUtils(driver);
	}

	// Page locators

	By logoLoc = By.xpath("//div[contains(@class,'logo-holder logo')]");
	By filterTextLoc = By.xpath("(//div/h4[text()='Filters'])[position()=2]");
	By pricerangeTextLoc = By.xpath("(//div/h6[text()='Price Range'])[position()=2]");
	By categoriesTextLoc = By.xpath("(//div/h6[text()='Categories'])[position()=2]");
	By subCategoriesTextLoc = By.xpath("(//div/h6[text()='Sub Categories'])[position()=2]");

	By serachForTextLoc = By.xpath("(//div/h6[text()='Search For'])[position()=2]");
	By signOutLoc = By.xpath("//button[normalize-space()='Sign Out']");
	By cartLinkLoc = By.xpath("//button[@routerlink='/dashboard/cart']/i[contains(@class,'fa-shopping-cart')]");
	By homePageLinkLoc = By.xpath("//button[@routerlink='/dashboard/']/i[contains(@class,'fa-home')]");
	By orderLoc = By.xpath("//button[@routerlink='/dashboard/myorders']");
	By homePageLoc = By.xpath("//button[@routerlink='/dashboard/' and normalize-space()='HOME']");

	By itemNameLoc = By.xpath("//div[@class='card-body']/h5/b");
	By itemPriceLoc = By.xpath("//div[@class='card-body']/h5/following-sibling::div/div");
	By itemAddToCartLoc = By.xpath(
			"//div[@class='card-body']/h5/following-sibling::div/div/parent::div/following-sibling::button [position()=2]");

	String itemSpecAddCartLoc_1 = "//div[@class='card-body']/h5/b[text()='";
	String itemSpecAddCartLoc_2 = "']/parent::h5/following-sibling::button[2]";
	By locAddtocart = By.xpath("//div[@class='card-body']/button[normalize-space()='Add To Cart']");
	
	By homeTextLoc=By.xpath("(//p[contains(normalize-space(),'Home')]) [position()=2]");
	
	

	// Page Actions
	public boolean isLogoPresent() throws InterruptedException {
		Thread.sleep(3000);
		return eleUtil.isDisPlayed(logoLoc);
	}

	public boolean isFilterredOptionAvailable() {
		return eleUtil.isDisPlayed(filterTextLoc);
	}

	public boolean isPriceRanageOptionAvailable() {
		return eleUtil.isDisPlayed(pricerangeTextLoc);
	}

	public boolean isCategoryOptionAvailable() {
		return eleUtil.isDisPlayed(categoriesTextLoc);
	}

	public boolean isSubCategoryOptionAvailable() {
		return eleUtil.isDisPlayed(subCategoriesTextLoc);
	}

	public boolean isSearchForOptionAvailable() {
		return eleUtil.isDisPlayed(serachForTextLoc);
	}

	public boolean isTheSignoutLinkAvailable() {
		return eleUtil.isDisPlayed(signOutLoc);
	}

	public boolean isTheCartLinkAvailable() {
		return eleUtil.isDisPlayed(cartLinkLoc);
	}

	public boolean isTheOrderLinkAvailable() {
		return eleUtil.isDisPlayed(orderLoc);
	}

	public boolean isTheHomeLinkAvailable() {
		return eleUtil.isDisPlayed(homePageLoc);
	}

	
	public DashBoardPage navigateToHomePage() {
		eleUtil.waitForVisibilityOfElement(homePageLoc, AppConstants.MEDIUM_WAIT);
		jsUtil.scrollToElementUsingJS(homePageLoc);
//		eleUtil.doClickWithWait(cartLinkLoc, AppConstants.MEDIUM_WAIT);
//		eleUtil.doClickWithActions(cartLinkLoc);
		jsUtil.clickElementByJS(driver.findElement(homePageLoc));
		System.out.println("clicked on Home and navigate to the Home page.");
		return new DashBoardPage(driver);
	}
	
	public CartPage navigateToCartPage() {
		
		eleUtil.waitForVisibilityOfElement(cartLinkLoc, AppConstants.MEDIUM_WAIT);
		jsUtil.scrollToElementUsingJS(cartLinkLoc);
//		eleUtil.doClickWithWait(cartLinkLoc, AppConstants.MEDIUM_WAIT);
//		eleUtil.doClickWithActions(cartLinkLoc);
		jsUtil.clickElementByJS(driver.findElement(cartLinkLoc));
		System.out.println("clicked on cartlink and navigate to the cart page.");
		return new CartPage(driver);
	}

//	public Map<String, String> itemDetails = new HashMap<>();
//	public MultiMap<String, String> itemDetails=new MultiValueMap<>();

	public MultiValuedMap<String, String> itemDetails = new ArrayListValuedHashMap<>();

	private void getItemName() {
		List<WebElement> eleList = eleUtil.getListOfElementWithWait(itemNameLoc, AppConstants.MEDIUM_WAIT);
		for (WebElement ele : eleList) {
			System.out.println(ele.getText());
			itemDetails.put("itemName", ele.getText());
		}
	}

	private void getItemPrice() {
		List<WebElement> eleList = eleUtil.getListOfElementWithWait(itemPriceLoc, AppConstants.MEDIUM_WAIT);
		for (WebElement ele : eleList) {
			System.out.println(ele.getText());
			itemDetails.put("itemPrice", ele.getText());
		}
	}

	private void addToCart() {
		List<WebElement> eleList = eleUtil.getListOfElementWithWait(itemAddToCartLoc, AppConstants.MEDIUM_WAIT);
		for (WebElement ele : eleList) {
			System.out.println(ele.getText());
			itemDetails.put("itemAddToCart", ele.getText());
		}
	}

	/**
	 * Get itemInfo
	 * 
	 * @return
	 */
	public MultiValuedMap<String, String> getItemDetails() {
		getItemName();
		getItemPrice();
		addToCart();
		return itemDetails;
	}

	/**
	 * Click on AddToCart
	 * 
	 * @param itemName
	 */
	public void clickAddToCart(String itemName) {
		List<WebElement> eleList = eleUtil.getListOfElementWithWait(itemNameLoc, AppConstants.MEDIUM_WAIT);
		int flag = 0;
		for (WebElement ele : eleList) {
			if (itemName.toLowerCase().equalsIgnoreCase(ele.getText().toLowerCase())) {
				System.out.println("Procuct found on cart!!");
				jsUtil.scrollDownUingJS();
				WebElement selectedItemAddtoCart = driver.findElement(RelativeLocator.with(locAddtocart).below(ele)); //
				System.out.println(":::  " + selectedItemAddtoCart.getText());
				
//				eleUtil.doClickWithWait(cartLinkLoc, flag);   //(selectedItemAddtoCart);
//				WebElement eleAddToCart=driver.findElement(selectedItemAddtoCart);
				jsUtil.clickElementByJS(selectedItemAddtoCart);
				System.out.println(eleUtil.getText(ele) + "item is added successfully in cart.");
				flag++;
			}
		}
		if (flag == 0) {
			System.out.println(itemName + " : is not available in the items list.");
		}
	}
}
