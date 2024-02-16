package eKartAutoMation.constant;

import java.util.Properties;

import eKartAutoMation.factory.DriverFactory;

public class AppConstants {
	DriverFactory df=new DriverFactory();
	Properties prop=df.initProp();
		
			
			
//	public static final String APP_URL="https://rahulshettyacademy.com/client";
//	public static final String APP_USERNAME="santanup1212@gmail.com";
//	public static final String APP_PASSWORD= "Skp@12345";
	
	
	public static final long SHORT_WAIT_IN_SEC=2;
	public static final long SHORT_WAIT=2000;
	public static final long MEDIUM_WAIT=5000;
	public static final long LONG_WAIT=10000;
	
	
	public static final String LOGIN_PAGE_TITLE="";
	public static final String DASHBOARD_PAGE_TITLE="";
	public static final String CART_PAGE_TITLE="Let's Shop";
	
	public static final String LOGIN_PAGE_URL="";
	public static final String DASHBOARD_PAGE_URL="/dashboard/dash";
	public static final String CART_PAGE_URL="/cart";
	
	
	
	// EXCEL INPUT FILES
	public static final String EXCEL_NPUT_FILE_PATH="./src/test/resources/testdata/TestInput.xlsx";
	public static final String EXCEL_ITEM_DETAILS_SHEET="items_info";
	
	
	
}
