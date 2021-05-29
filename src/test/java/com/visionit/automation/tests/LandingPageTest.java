package com.visionit.automation.tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import com.visionit.automation.base.BaseTest;
import com.visionit.automation.utils.AppConstants;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LandingPageTest extends BaseTest {
	
	private static final Logger logger = LogManager.getLogger(LandingPageTest.class);
	

    @Test
    public void Send_a_Friend_Feature_tc_01() {
    	logger.info("The Test Case started: Send a Friend Feature");
    	landingPage.clickonSignin();
  	    logger.info("clicked on sign in button");
  	    landingPage.LoginIntoAccount();
    	logger.info("The Test Case started: Send a Friend Feature");
    	}
    @Test
    public void Change_in_the_image_using_Color_Feature_02() {
    	logger.info("Test case started: Change in the image using Color Feature");
    	landingPage.changeImageColor();
     	logger.info("Test case ended: Change in the image using Color Feature");
    }
    @Test
    public void  Write_a_Review_Feature_03() {
    	logger.info("Test case started: Write a Review Feature");
    	landingPage.clickonSignin();
    	landingPage.ProductReview();
    	logger.info("Test case ended: Write a Review Feature");
    }
    @Test
    public void End_To_End_User_Journey_Feature_04()  {
    	logger.info("Test case started: End To End User Journey Featur");
    	landingPage.EndToEndUserJourneyFeature();    	
    	logger.info("Test case ended: End To End User Journey Featur");
    	
    }
    
 
    
    
  
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   }
  
  
  
  
  
  
  
  
  
  
  
  
  
  


