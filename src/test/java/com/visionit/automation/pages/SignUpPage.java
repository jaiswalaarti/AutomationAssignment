package com.visionit.automation.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.visionit.automation.base.BasePage;
import com.visionit.automation.utils.ElementActions;
import com.visionit.automation.variables.RegisterPageUserDetails;

public class SignUpPage extends BasePage{

	private static final Logger logger = LogManager.getLogger(LandingPage.class);

	ElementActions elementActions;
	RegisterPageUserDetails registerPageUserDetails;

	// By Locators - Landing Page
	private By SigninButtonElement = By.xpath("//div/a[contains(text(),'Sign in')]");
	
	// Locators - SingIn Page
	private By emailIdInputFieldElement = By.xpath("//input[@id='email_create']");
	private By createAnAccountButtonElement = By.xpath("//button[@id='SubmitCreate']");
	
	// By Locators - Register Page
	private By maleGenderRadioButtonElement = By.id("id_gender1");
	private By userFirstNameTextboxElement = By.id("customer_firstname");
	private By userLastNameTextboxElement = By.id("customer_lastname");
	private By userPasswordTextboxElement = By.id("passwd");
	private By userDOBDayDropDownElement = By.id("days");
	private By userDOBMonthDropDownElement = By.id("months");
	private By userDOBYearDropDownElement = By.id("years");
	private By signUpForNewsLetterCheckBoxElement = By.id("newsletter");
	private By specialOfferEmailRecCheckBoxElement = By.id("optin");
	private By AddressComanyNameTextBoxElement = By.id("company");
	private By AddressLine1TextBoxElement = By.id("address1");
	private By AddressLine2TextBoxElement = By.id("address2");
	private By AddressCityTextBoxElement = By.id("city");
	private By AddressStateDropDownElement = By.id("id_state");
	private By AddressZipCodeTextBoxElement = By.id("postcode");
	//private By AddressCountryDropDownElement = By.id("id_country");
	private By AddressAdditionalInfoTextBoxElement = By.id("other");
	private By AddressHomePhoneTextBoxElement = By.id("phone");
	private By AddressMobilePhoneTextBoxElement = By.id("phone_mobile");
	private By AdddressAliasAddressTextBoxElement = By.id("alias");
	private By registerFormButtonElement = By.id("submitAccount");

	// Locators - After Registration Page
	private By registeredUserNameDisplayElement = By.xpath("//a[@title='View my customer account']/span");

	// Constructor of the page:
	public SignUpPage(WebDriver driver) {
		elementActions = new ElementActions(driver);
		registerPageUserDetails = new RegisterPageUserDetails();
	}

	// Page Actions:
	public boolean registerUserInApp(boolean IsSignUpForNewsLetter, boolean IsspecialOfferEmailRegister)
	{
		String newUserEmailId = registerPageUserDetails.getUserNewEmailId();
		String newUserFirstName = registerPageUserDetails.getUserFirstName();
		String newUserNameName = registerPageUserDetails.getUserLastName();
		// SignIn Page 
		logger.info("waiting for Signin button on landing page");
		elementActions.waitForElementClickable(SigninButtonElement);
		elementActions.doClick(SigninButtonElement);
		logger.info("Clicked on Signin button from landing page");
		elementActions.doSendKeys(emailIdInputFieldElement, newUserEmailId);
		logger.info("Sending new user email id as : " + newUserEmailId);
		elementActions.doClick(createAnAccountButtonElement);
		logger.info("Clicked on create an account button from login page");
		
		// User registration page
		elementActions.doClick(maleGenderRadioButtonElement);
		logger.info("Clicked on male gender radio button");
		elementActions.doActionsSendKeys(userFirstNameTextboxElement, newUserFirstName);
		logger.info("Sent text for user first name as : " + newUserFirstName);
		elementActions.doActionsSendKeys(userLastNameTextboxElement, newUserNameName);
		logger.info("Sent text for user last name as : " + newUserNameName);
		elementActions.doActionsSendKeys(userPasswordTextboxElement, RegisterPageUserDetails.userPassword);
		logger.info("Sent text for user password as : " + RegisterPageUserDetails.userPassword);
		elementActions.selectByValueFromDropDown(userDOBDayDropDownElement, RegisterPageUserDetails.DOBDayValue);
		logger.info("Selected value from drop down Birth Day for user as : " + RegisterPageUserDetails.DOBDayValue);
		elementActions.selectByValueFromDropDown(userDOBMonthDropDownElement, RegisterPageUserDetails.DOBMonthValue);
		logger.info("Selected value from drop down Birth Month for user as : " + RegisterPageUserDetails.DOBMonthValue);
		elementActions.selectByValueFromDropDown(userDOBYearDropDownElement, RegisterPageUserDetails.DOBYearValue);
		logger.info("Selected value from drop down Birth Year for user as : " + RegisterPageUserDetails.DOBYearValue);
		if(IsSignUpForNewsLetter) 
		{
			elementActions.doClick(signUpForNewsLetterCheckBoxElement);
			logger.info("Clicked on sign Up For News Letter Check Box option");
		}
		if (IsspecialOfferEmailRegister) 
		{
			elementActions.doClick(specialOfferEmailRecCheckBoxElement);
			logger.info("Clicked on special Offer Email RecCheck Box option");
		}
		
		elementActions.doActionsSendKeys(AddressComanyNameTextBoxElement, RegisterPageUserDetails.AddressComanyName);
		logger.info("Sending user Company address name as : " + RegisterPageUserDetails.AddressComanyName);
		elementActions.doActionsSendKeys(AddressLine1TextBoxElement, RegisterPageUserDetails.AddressLine1Name);
		logger.info("Sending user Company address line 1 as : " + RegisterPageUserDetails.AddressComanyName);
		elementActions.doActionsSendKeys(AddressLine2TextBoxElement, RegisterPageUserDetails.AddressLine2Name);
		logger.info("Sending user Company address line 2 as : " + RegisterPageUserDetails.AddressLine2Name);
		elementActions.doActionsSendKeys(AddressCityTextBoxElement, RegisterPageUserDetails.AddressCity);
		logger.info("Sending user city name as : " + RegisterPageUserDetails.AddressCity);
		elementActions.selectByVisibleTextFromDropDown(AddressStateDropDownElement, RegisterPageUserDetails.AddressState);
		logger.info("Selecting user state from drop down as : " + RegisterPageUserDetails.AddressState);
		elementActions.doActionsSendKeys(AddressZipCodeTextBoxElement, RegisterPageUserDetails.AddressZipCode);
		logger.info("Sending user postal zip code as : " + RegisterPageUserDetails.AddressZipCode);
		elementActions.doActionsSendKeys(AddressAdditionalInfoTextBoxElement, RegisterPageUserDetails.AddressAdditionalInfo);
		logger.info("Sending user addition info as : " + RegisterPageUserDetails.AddressAdditionalInfo);
		elementActions.doActionsSendKeys(AddressHomePhoneTextBoxElement, RegisterPageUserDetails.AddressHomePhone);
		logger.info("Sending user home phone no as : " + RegisterPageUserDetails.AddressHomePhone);
		elementActions.doActionsSendKeys(AddressMobilePhoneTextBoxElement, RegisterPageUserDetails.AddressMobilePhone);
		logger.info("Sending user mobile phone no as : " + RegisterPageUserDetails.AddressMobilePhone);
		elementActions.doActionsSendKeys(AdddressAliasAddressTextBoxElement, RegisterPageUserDetails.AdddressAliasAddress);
		logger.info("Sending user alias address as : " + RegisterPageUserDetails.AdddressAliasAddress);
		elementActions.doClick(registerFormButtonElement);
		logger.info("Clicking on register button after filling all required data");
		
		// After registration page
		logger.info("After clicking on register button waiting for registered user name in application next page");
		elementActions.waitForElementVisible(registeredUserNameDisplayElement);
		String registeredUserFirstNameLastNameText = elementActions.doGetText(registeredUserNameDisplayElement);
		logger.info("Actual registered user first name and last name is displayed as : " + registeredUserFirstNameLastNameText);
		String expectedUserFirstNameLastNameText = newUserFirstName + " " + newUserNameName;  
		logger.info("Expected registered user first name and last name  as : " + expectedUserFirstNameLastNameText);
		logger.info("Comparing registered user Actual Firstname Lastname with Expected one");
		if (registeredUserFirstNameLastNameText.equals(expectedUserFirstNameLastNameText)) {
			logger.info("user is logged in now");
			return true;
		}
		else
		{
			return false;
		}		
	}
}
