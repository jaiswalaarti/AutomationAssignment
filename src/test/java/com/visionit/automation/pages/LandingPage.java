package com.visionit.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.visionit.automation.base.BasePage;
import com.visionit.automation.utils.AppConstants;
import com.visionit.automation.utils.ElementActions;
import com.visionit.automation.utils.JavaScriptUtil;
import com.visionit.automation.utils.WaitUtil;

public class LandingPage extends BasePage  {

	private static final Logger logger = LogManager.getLogger(LandingPage.class);

	ElementActions elementActions;
	JavaScriptUtil javaScriptUtil;
	WaitUtil waitUtil;
	
	// By Locators - Landing Page
	private By SigninButtonElement = By.xpath("//div/a[contains(text(),'Sign in')]");
    private By registeredEmailidElement = By.id("email");
	private By alreadyCreatedPasswordElement = By.id("passwd");
	private By clickOnSignInButton1 = By.xpath("//*[@id='SubmitLogin']");
	
	//locator for T-shirt element 
	private By clickOnTshirtElement = By.xpath("//div[@id='block_top_menu']/ul/li[3]/a");
	//locator for faded short sleeves t-shirt
	private By shortSleevesImage = By.xpath("//div[@class='right-block']/h5/a[@class='product-name']");
	private By SendToFriend = By.id("send_friend_button");
	
	//locator for more option in faded short sleeves t-shirt
	private By moreOption = By.xpath("//a[@title='View']//span");
	//locator for friend name and email-id
	
	private By friendNameelement = By.xpath("//input[@id='friend_name']");
	private By friendEmailId = By.xpath("//input[@id='friend_email']");
	
	//locator for send email
	private By send= By.id("sendEmail");
	
	//locator for this->'Your e-mail has been sent successfully' element and element for ok button
	private By sentEmailMessageElement = By.xpath("//p[normalize-space()='Your e-mail has been sent successfully']");
	private By okButtonElement = By.xpath("//input[@type='button' and @value='OK']");
	
	//locator for blue color box element
	private By blueColorBoxElement = By.xpath("//a[@id='color_2']");
   //review locators
   private By reviewElement = By.xpath("//a[@class='open-comment-form']");
   private By reviewTitleElement =By.xpath("//input[@id='comment_title']");
   private By reviewCommentElement = By.xpath("//textarea[@id='content']");
   private By reviesSendElement = By.xpath("//button[@id='submitNewMessage']");
   private By reviewMessageDisplay = By.xpath("//p[contains(text(),'Your comment has been added and will be available ')]");
   //remaining locators for end to end flow feature
   private By tShirtElement = By.xpath("//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']//li[3]//a[@title='T-shirts']");
   private By fadedShortSleevesTshirtElement = By.xpath("//a[normalize-space()='Faded Short Sleeve T-shirts']");
   private By priceElement = By.xpath("//span[@id='our_price_display']");
   private By increaseQuantityElement = By.xpath("//i[@class='icon-plus']");
   private By LsizeElement =By.xpath("//select[@id='group_1']");
   private By QuantityElement = By.xpath("//input[@id='quantity_wanted']");
   private By addToCartElement = By.xpath("//button[@class='exclusive']");
   private By productSuccessfullyAddedElement = By.xpath("//h2[normalize-space()='Product successfully added to your shopping cart']");
   private By quantityOfProductAfteraddedToCartElement = By.xpath("//span[@id='layer_cart_product_quantity']");
   private By colourOfProductAfterAddedToCart = By.xpath("//span[@id='layer_cart_product_attributes']");
   private By TotalPriceOfProductAddedToCart = By.xpath("//span[@class='ajax_block_cart_total']");
   private By ProcedeToCheckOut1 = By.xpath("//a[@title='Proceed to checkout']");
   private By userSeecThisProductNameElement = By.xpath("//td[@class='cart_description']//p[@class='product-name']");
   private By InStockElement = By.xpath("//span[@class='label label-success']");
   private By unitPrice = By.xpath("//td[@class='cart_unit']//span[@class='price']");
   private By Quantity = By.xpath("//span[@class='heading-counter']");
   private By TotalShippingPriceElemnt = By.xpath("//span[@id='total_price']");
   private By ProceedToCheckOut2 = By.xpath("//p[@class='cart_navigation clearfix']//a[@title='Proceed to checkout']");
   private By proceedToCheckOut3 = By.xpath("//button[@class='button btn btn-default button-medium']");
   private By proceedToCheckOut4 = By.xpath("//button[@class='button btn btn-default standard-checkout button-medium']");
   private By CheckBox = By.xpath("//input[@id='cgv']");
   private By PayByBankWire = By.xpath("//a[@title='Pay by bank wire']");
   private By IconfirmedMyOrder = By.xpath("//button[@class='button btn btn-default button-medium']");
   private By ordercompleteMessage = By.xpath("//p[@class='cheque-indent']");
   private By amount = By.xpath("//span[@class='price']");
   
	// Constructor of the page:
	public LandingPage(WebDriver driver) {
		elementActions = new ElementActions(driver);
		javaScriptUtil = new JavaScriptUtil(driver);
		waitUtil = new WaitUtil();
	}
	

	public void clickonSignin() {
		elementActions.doClick(SigninButtonElement);
		
	}
	

	 public void LoginIntoAccount() {
		 elementActions.doSendKeys(registeredEmailidElement, AppConstants.REGISTERED_EMAIL_lId);
		 elementActions.doSendKeys(alreadyCreatedPasswordElement, AppConstants.REGISTERED_PSSWRD);
		 elementActions.doClick(clickOnSignInButton1);
		 elementActions.doClick(clickOnTshirtElement);
		 elementActions.waitForElementVisible(shortSleevesImage);
		 elementActions.doMoveToElement(shortSleevesImage);
		 elementActions.doClick(moreOption);
		 elementActions.doClick(SendToFriend);
		 elementActions.doSendKeys(friendNameelement, AppConstants.FRIEND_NAME);
		 logger.info("enterd name of friend is: "+AppConstants.FRIEND_NAME);
		 elementActions.doSendKeys(friendEmailId, AppConstants.FRIEND_EMAIlId);
		 logger.info("enterd emailid of friend is: "+AppConstants.FRIEND_EMAIlId);
		 elementActions.doClick(send);
		 logger.info("clicked on send button");
		 logger.info("The messadge display after sending to a friend : " +elementActions.doGetText(sentEmailMessageElement));
		 elementActions.doClick(okButtonElement);
		 logger.info("send to friend feature");
	 }
	 
	 
	 public void ProductReview() {
		 elementActions.doSendKeys(registeredEmailidElement, AppConstants.REGISTERED_EMAIL_lId);
		 elementActions.doSendKeys(alreadyCreatedPasswordElement, AppConstants.REGISTERED_PSSWRD);
		 elementActions.doClick(clickOnSignInButton1);
		 elementActions.doClick(clickOnTshirtElement);
		 logger.info("T-shirt category selected");
		 elementActions.waitForElementVisible(shortSleevesImage);
		 elementActions.doMoveToElement(shortSleevesImage);
		 elementActions.doClick(moreOption);
		 logger.info("clicke on more options");
		 javaScriptUtil.scrollPageDown("500");
		 elementActions.waitForElementClickable(reviewElement);
		 elementActions.doClick(reviewElement);
		 logger.info("clicked on review");
		 elementActions.doSendKeys(reviewTitleElement, AppConstants.TITLEOFREVIEW);
		 logger.info("title enter in review is : "+AppConstants.TITLEOFREVIEW);
		 elementActions.doActionsSendKeys(reviewCommentElement,AppConstants.COMMENT );
		 logger.info("comment writen in review box in :"+AppConstants.COMMENT);
		 elementActions.doClick(reviesSendElement);
		 logger.info("clicked on send review");
		 logger.info("message display after sending review is : "+elementActions.doGetText(reviewMessageDisplay));
		 
	 }
	 
	 public void changeImageColor() {
		 elementActions.doClick(clickOnTshirtElement);
		 elementActions.waitForElementVisible(shortSleevesImage);
		 elementActions.doClick(blueColorBoxElement);
		 //WaitUtil.shortWait();
		// elementActions.waitForElementVisible(blueColorImgElement);
		 logger.info("clicked on blue colour to change colour of t-shirt");
		 new BasePage().getScreenshot();
		 logger.info("ScreenShot of changed colour of image is captured");
		 
	 }
    
       public void EndToEndUserJourneyFeature()  {
    	   elementActions.doClick(SigninButtonElement);
    	   elementActions.doSendKeys(registeredEmailidElement, AppConstants.REGISTERED_EMAIL_lId);
  		   elementActions.doSendKeys(alreadyCreatedPasswordElement, AppConstants.REGISTERED_PSSWRD);
  		   elementActions.doClick(clickOnSignInButton1);
    	   elementActions.doClick(tShirtElement);
    	   logger.info("clicked on T-Shirt");
    	   elementActions.waitForElementClickable(fadedShortSleevesTshirtElement);
    	   elementActions.doClick(fadedShortSleevesTshirtElement);
    	   logger.info("clicked on short sleeves t-shirt selected");
    	   elementActions.waitForElementClickable(priceElement);
    	   logger.info("The price of the faded short sleeves T-shirt is: "+elementActions.doGetText(priceElement));
    	   elementActions.doClick(increaseQuantityElement);
    	   elementActions.waitForElementVisible(QuantityElement);
    	   logger.info("The quantity of T-shirt is incresed to: "+elementActions.doGetText(QuantityElement));
    	   elementActions.selectByVisibleTextFromDropDown(LsizeElement, "L");
    	   elementActions.doClick(addToCartElement);
    	   elementActions.waitForElementVisible(productSuccessfullyAddedElement);
    	   Assert.assertEquals(AppConstants.ADDEDCARTMESSAGE, elementActions.doGetText(productSuccessfullyAddedElement), "message display is incorrect");
    	   logger.info("user will see this pop up message after product added to cart: "+elementActions.doGetText(productSuccessfullyAddedElement));
    	   logger.info("The total quantity of product added to cart is : " +elementActions.doGetText(quantityOfProductAfteraddedToCartElement));
    	   logger.info("The coloure of the product added to cart is : "+elementActions.doGetText(colourOfProductAfterAddedToCart));
           logger.info("The Total price of the product added to cart is : "+elementActions.doGetText(TotalPriceOfProductAddedToCart));
           elementActions.doClick(ProcedeToCheckOut1);  
           logger.info("proceed to check out 1st time");
           logger.info("The product name diplay for user is : "+elementActions.doGetText(userSeecThisProductNameElement));
           logger.info("The product is in : "+elementActions.doGetText(InStockElement));
           logger.info("Unit price is : "+elementActions.doGetText(unitPrice));
           logger.info("current quantity is : "+elementActions.doGetText(Quantity));
           logger.info("Total price with shipping charges is : "+elementActions.doGetText(TotalShippingPriceElemnt));
           elementActions.doClick(ProceedToCheckOut2);
           logger.info("clicked on proceed to check out 2nd time");
           elementActions.doClick(proceedToCheckOut3);
           logger.info("clicked on proceed to check out 3rd time");
           elementActions.doClick(CheckBox);
           elementActions.doClick(proceedToCheckOut4);
           logger.info("clicked on proceed to check out 4th time");
           elementActions.doClick(PayByBankWire);
           logger.info("clicked on pay bank wire option");
           elementActions.doClick(IconfirmedMyOrder);
           logger.info("clicked on i confirm my order");
           logger.info("order comleted message displayed is : "+elementActions.doGetText(ordercompleteMessage));
           logger.info("The Amount Display is :"+elementActions.doGetText(amount));
           
        	   
           }
       
}
       
         






	

