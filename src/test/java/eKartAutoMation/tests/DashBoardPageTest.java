package eKartAutoMation.tests;

import java.util.Map.Entry;

import org.apache.commons.collections4.MultiValuedMap;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import eKartAutoMation.base.BaseTest;
import eKartAutoMation.constant.AppConstants;

public class DashBoardPageTest extends BaseTest {

	@BeforeClass
	public void setUp() throws InterruptedException {
		dashBoardPage = loginPage.doLogin(AppConstants.APP_USERNAME, AppConstants.APP_PASSWORD);
	}

	@Test
	public void appLogoTest() throws InterruptedException {
		boolean flag = dashBoardPage.isLogoPresent();
		Assert.assertTrue(flag);
	}

	@Test
	public void filterAvailablilityTest() {
		boolean flag = dashBoardPage.isFilterredOptionAvailable();
		Assert.assertTrue(flag);
	}

	@Test
	public void categoryAvailablilityTest() {
		boolean flag = dashBoardPage.isCategoryOptionAvailable();
		Assert.assertTrue(flag);
	}

	@Test
	public void subCategoryAvailablilityTest() {
		boolean flag = dashBoardPage.isSubCategoryOptionAvailable();
		Assert.assertTrue(flag);
	}

	@Test
	public void priceRangeAvailablilityTest() {
		boolean flag = dashBoardPage.isPriceRanageOptionAvailable();
		Assert.assertTrue(flag);
	}

	@Test
	public void searchForAvailablilityTest() {
		boolean flag = dashBoardPage.isSearchForOptionAvailable();
		Assert.assertTrue(flag);
	}

	@Test
	public void cartLinkAvailablilityTest() {
		boolean flag = dashBoardPage.isTheCartLinkAvailable();
		Assert.assertTrue(flag);
	}

	@Test
	public void homeLinkAvailablilityTest() {
		boolean flag = dashBoardPage.isTheHomeLinkAvailable();
		Assert.assertTrue(flag);
	}

	@Test
	public void orderLinkAvailablilityTest() {
		boolean flag = dashBoardPage.isTheOrderLinkAvailable();
		Assert.assertTrue(flag);
	}

	@Test
	public void signoutLinkAvailablilityTest() {
		boolean flag = dashBoardPage.isTheSignoutLinkAvailable();
		Assert.assertTrue(flag);
	}

	@Test(enabled = false)
	public void addItemsInCartTest() {
		MultiValuedMap<String, String> cartItemsDetails = dashBoardPage.getItemDetails();
		System.out.println(cartItemsDetails);
		
		for (Entry<String, String> itemList : cartItemsDetails.entries()) {
			if (itemList.getKey().equals("itemName")) {
				String itemName = itemList.getValue();
				if(itemName.equals("TOMATOS")) {
					dashBoardPage.clickAddToCart(itemName);
					break;
				}
			}
		}

	}

	
	
	
	
	
}
