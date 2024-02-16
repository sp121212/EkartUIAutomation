package eKartAutoMation.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import eKartAutoMation.base.BaseTest;
import eKartAutoMation.constant.AppConstants;
import eKartAutoMation.utils.ExcelUtil;

public class CartPageTest extends BaseTest {

	@BeforeClass
	public void setUp() {
		dashBoardPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
//		dashBoardPage.clickAddToCart("IPHONE 13 PRO");
		cartPage = dashBoardPage.navigateToCartPage();
	}

	@Test
	public void pageTitleTest() {
		String actTitle = cartPage.getPageTitle();
		Assert.assertEquals(actTitle, AppConstants.CART_PAGE_TITLE);
	}

	@Test
	public void pageURL() {
		String actUrl = cartPage.getCartPageUrl();
		Assert.assertTrue(actUrl.contains(AppConstants.CART_PAGE_URL));
	}

	
	@Test(priority = 1, dataProvider="excelTestData")
//	@Test(priority = 1, dataProvider="testData")
	public void checkProdInfoOnCartPageTest(String itemName,String price,String isInStuck) {
		
		dashBoardPage.navigateToHomePage();
		System.out.println("Navigate to HOME PAGE.");
		
		dashBoardPage.clickAddToCart(itemName); //("IPHONE 13 PRO");
		
		
		
		cartPage = dashBoardPage.navigateToCartPage();
		
		Map<String, String> cartItemsList = cartPage.getAllItemsonCartPage();
		System.out.println(cartItemsList);
		softAssert.assertEquals(cartItemsList.get("itemName"),itemName ); // "IPHONE 13 PRO");
		softAssert.assertEquals(cartItemsList.get("itemPrice").substring(cartItemsList.get("itemPrice").indexOf("$")),	price);	//		"$ 231500");
		softAssert.assertEquals(cartItemsList.get("itemStuckStatus").toLowerCase(),isInStuck.toLowerCase() );  //"In Stock".toLowerCase());
		softAssert.assertAll();
	}

	@Test
	public void isBuyNowButtonAvailable() {

	}

	@Test
	public void isRemoveFromCartOptionisAvailable() {

	}

	@Test
	public void validateSumOfTheProduct() {

	}

	
	
	@DataProvider(name = "testData")
	public Object[][] testData() {
		Object[][] obj = { 
							{ "IPHONE 13 PRO", "$ 231500", "In Stock11" }, 
							{ "ZARA COAT 3", "$ 31500", "In Stock11" },
							{ "ADIDAS ORIGINAL", "$ 31500", "In Stock11" }, 
						  };
		return obj;
	}
	
	@DataProvider(name="excelTestData")
	public Object[][] excelTestData() {
		Object[][] data=ExcelUtil.readTestData(AppConstants.EXCEL_ITEM_DETAILS_SHEET);
		return data;
	}
	
}
