package com.visionit.automation.utils;

import java.util.ArrayList;

/**
 * @author Sarang Holey
 *	This class having all the constant values
 *	which needed for validation throughout the project
 *	Ex. Page Titles
 */
public class AppConstants {
	
	
	public static final int WEBDRIVER_WAIT_TIMEOUT = 15;
	public static final String LANDING_PAGE_REDIRECTED_URL = "http://automationpractice.com/index.php";
	public static final String LANDING_PAGE_TITLE = "My Store";
	public static final String LOGIN_PAGE_TITLE1 = "Login - My Store";
	public static final String SEARCH_KEYWORD = "Dress";
	public static final String REGISTERED_EMAIL_lId = "jaiswalaarti495@gmail.com";
	public static final String REGISTERED_PSSWRD = "123456789";
	public static final String FRIEND_NAME = "Harry";
	public static final String FRIEND_EMAIlId = "harry@gmail.com";
	public static final String TITLEOFREVIEW = "Faded short sleeves T-shirt";
	public static final String COMMENT = "Product quality is good but color slightly vary as shown in picture";
	public static final String ADDEDCARTMESSAGE = "Product successfully added to your shopping cart";
	public static final String PRODUCT_NAME = "Faded Short Sleeve T-shirts";
	public static ArrayList<String> landingPageProdCategoryExpected()
	{
		ArrayList<String> LANDING_PAGE_PROD_CATEGORY_EXPECTED = new ArrayList<>();
		LANDING_PAGE_PROD_CATEGORY_EXPECTED.add("WOMEN");
		LANDING_PAGE_PROD_CATEGORY_EXPECTED.add("DRESSES");
		LANDING_PAGE_PROD_CATEGORY_EXPECTED.add("T-SHIRTS");
		
		return LANDING_PAGE_PROD_CATEGORY_EXPECTED;
	}
	
	

	
	
	public static final  String SIGNIN_PAGE_TITLE = "Login - My Store";
	public static final String LOGIN_PAGE_TITLE = null;

}
















