package com.visionit.automation.variables;

import com.visionit.automation.utils.RandomNumberGeneratorUtil;

public class RegisterPageUserDetails {
	
	public RandomNumberGeneratorUtil randomUtil;
	
	public RegisterPageUserDetails() {
		randomUtil = new RandomNumberGeneratorUtil();
	}

	// Setter for Variable - SignIn Page
	public String getUserNewEmailId()
	{
		String newUserEmailId = "DemoUser111"+randomUtil.randomStringGenerator()+"@gmail.com";
		return newUserEmailId;
	}
	//public static String NewUserEmailID = "DemoUser111"+randomUtil.randomStringGenerator()+"@gmail.com";
	
	// Setter for Variable - Register User Details FirstName
	public String getUserFirstName()
	{
		String userFirstName = randomUtil.randomStringGenerator();
		return userFirstName;
	}
	//public static String userFirstName = randomUtil.randomStringGenerator();
	
	
	// Setter for Variable - Register User Details LastName
	public String getUserLastName()
	{
		String userLastName = randomUtil.randomStringGenerator();
		return userLastName;
	}
	//public static String userLastName = randomUtil.randomStringGenerator();
	
	// Variables - Register User Details
	public static final String userPassword = "123@Abc";
	public static final String DOBDayValue = "3";
	public static final String DOBMonthValue = "3";
	public static final String DOBYearValue = "2008";
	public static final boolean IsSignUpForNewsLetter = true;
	public static final boolean IsspecialOfferEmailRec = true;
	public static final String AddressComanyName = "Unicorn1 Systems";
	public static final String AddressLine1Name = "1773  Backer Street, PO Box 23";
	public static final String AddressLine2Name = "fountain garden";
	public static final String AddressCity = "Los Angeles";
	public static final String AddressState = "New York";
	public static final String AddressZipCode = "10005";
	public static final String AddressAdditionalInfo = "Please Send do the proceedings ASAP";
	public static final String AddressHomePhone = "56457825";
	public static final String AddressMobilePhone = "+16465567479";
	public static final String AdddressAliasAddress = "testDemo@gmail.com";

}
