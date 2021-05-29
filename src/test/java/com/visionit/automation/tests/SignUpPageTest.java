package com.visionit.automation.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.visionit.automation.base.BaseTest;
import com.visionit.automation.utils.AppConstants;

public class SignUpPageTest extends BaseTest {
	
	private static final Logger logger = LogManager.getLogger(SignUpPageTest.class);
	@Test
	public void SignUp_And_Check_User_Account_Created_00() {
		logger.info("Test Case Started: SignUp_And_Check_User_Account_Created_001");
		boolean isAccountCreated = signupPage.registerUserInApp(true, true);
		Assert.assertEquals(isAccountCreated, true,"user account not creates");
		logger.info("Test Case Ended: SignUp_And_Check_User_Account_Created_001");
		
	}}