package com.visionit.automation.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.visionit.automation.base.BasePage;

/**
 * @author Sarang Holey
 * This class having the wrapper methods
 * on top of Selenium WebDriver methods
 * to interact with elements on WebPage
 * with the ease of use to minimize the efforts
 * for the script writers
 */

public class ElementActions {

	JavaScriptUtil javaScriptUtil;
	WebDriver driver;
	WebDriverWait wait;
	Actions action;
	Properties prop;
	BasePage basePage;
	//Utils utils;

	/**
	 * This constructor initialize 
	 * WebDriver, WebDriverWait, Actions, Properties
	 * (Interface and Class)
	 * @param driver
	 */
	public ElementActions(WebDriver driver) {
		this.driver = driver;
		basePage = new BasePage();
		prop = basePage.init_prop();
		wait = new WebDriverWait(this.driver, AppConstants.WEBDRIVER_WAIT_TIMEOUT);
		action = new Actions(this.driver);
		javaScriptUtil = new JavaScriptUtil(driver);
	}

	/**
	 * Method to initialize WebElement using
	 * By locator
	 * @param locator
	 * @return WebElement
	 */
	public WebElement getElement(By locator) {
		WebElement element = null;
		if (prop.getProperty("highlight").equalsIgnoreCase("true") && prop.getProperty("drawBorderToElement").equalsIgnoreCase("true")) 
		{
			element = driver.findElement(locator);
			javaScriptUtil.drawBorder(element);
			javaScriptUtil.flash(element);
		}
		else if (prop.getProperty("highlight").equalsIgnoreCase("true")) 
		{
			element = driver.findElement(locator);
			javaScriptUtil.flash(element);
		}
		else if (prop.getProperty("drawBorderToElement").equalsIgnoreCase("true")) 
		{
			element = driver.findElement(locator);
			javaScriptUtil.drawBorder(element);
		}
		else
		{
			element = driver.findElement(locator);
		}
		
		return element;
	}

	/**
	 * Method to initialize list of WebElement using
	 * By locator
	 * @param locator
	 * @return List of element
	 */
	public List<WebElement> getElementsList(By locator) 
	{
		List<WebElement> element = null;
		element = driver.findElements(locator);
		return element;
	}
	
	/**
	 * This method perform .click operation
	 * on the WebElement
	 * @param locator
	 */
	public void doClick(By locator) 
	{
		getElement(locator).click();
	}

	/**
	 * This method perform .click operation
	 * using actions class
	 * on the WebElement
	 * @param locator
	 */
	public void doActionsClick(By locator) 
	{
		action.click(getElement(locator)).build().perform();
	}

	/**
	 * This method perform .sendKeys operation
	 * on the WebElement
	 * @param locator & String value for sendKeys operation
	 */
	public void doSendKeys(By locator, String value) 
	{
		getElement(locator).sendKeys(value);
	}

	
	/**
	 * This method perform .sendKeys operation
	 * using actions class
	 * on the WebElement
	 * @param locator & String value for sendKeys operation
	 */
	public void doActionsSendKeys(By locator, String value) 
	{
		action.sendKeys(getElement(locator), value).build().perform();
	}

	/**
	 * This method perform move to operation
	 * using actions class
	 * on the WebElement
	 * @param locator
	 */
	public void doMoveToElement(By locator)
	{
		action.moveToElement(getElement(locator)).build().perform();
	}
	
	/**
	 * This method perform drag and drop operation
	 * using actions class
	 * on the WebElement
	 * @param locator
	 */
	public void doDragAndDropToElement(By sourceLocator, By targetLocator)
	{
		WebElement sourceElement = getElement(sourceLocator);
		WebElement targetElement = getElement(sourceLocator);
		action.dragAndDrop(sourceElement, targetElement).build().perform();
	}
	
	/**
	 * This method perform right click mouse button operation
	 * using actions class
	 * on the WebElement
	 * @param locator
	 */
	public void doRightClickToElement(By locator)
	{
		action.contextClick(getElement(locator)).build().perform();
	}
	
	/**
	 * This method perform double click mouse button operation
	 * using actions class
	 * on the WebElement
	 * @param locator
	 */
	public void doDoubleClickToElement(By locator)
	{
		action.doubleClick(getElement(locator)).build().perform();
	}

	/**
	 * This method check the WebElement is displayed
	 * on the WebPage and return boolean value
	 * @param locator
	 * @return boolean value
	 */
	public boolean doIsDisplayed(By locator) {
		boolean flag = false;
		flag = getElement(locator).isDisplayed();
		return flag;
	}

	/**
	 * This method check the WebElement is selected
	 * on the WebPage and return boolean value
	 * @param locator
	 * @return boolean value
	 */
	public boolean doIsSelected(By locator) {
		boolean flag = false;
		flag = getElement(locator).isSelected();
		return flag;
	}
	
	public boolean doIsEnabled(By locator) {
		boolean flag = true;
		return flag;
	}

	/**
	 * This method used to fetch the text from the WebElement
	 * and return in form of String
	 * @param locator
	 * @return String value of the WebElement
	 */
	public String doGetText(By locator) {
		String text = null;
		text = getElement(locator).getText();
		return text;
	}

	/**
	 * This method fetch the current URL as text
	 * where the current browser instance is focused
	 * on the WebPage and return in form of String
	 * @param locator
	 * @return String value of the current URL
	 */
	public String doGetcurrentURL() {
		String text = null;
		text = driver.getCurrentUrl();
		return text;
	}

	/**
	 * This method waits for the presenceOfElementLocated
	 * condition of the WebElement
	 * @param locator
	 */
	public void waitForElementPresent(By locator) {
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	/**
	 * This method waits for the frameToBeAvailableAndSwitchToIt
	 * condition of the frame on the WebElement
	 * @param locator
	 */
	public void waitForFramePresentAndSwitchToIt(By locator) {
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
	}

	/**
	 * This method waits for the visibilityOf
	 * condition of the WebElement
	 * @param locator
	 */
	public void waitForElementVisible(By locator) {
		WebElement ele = getElement(locator);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	/**
	 * This method waits for the elementToBeClickable
	 * condition of the WebElement
	 * @param locator
	 */
	public void waitForElementClickable(By locator)
	{
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	/**
	 * This method fetch the title of current WebPage 
	 * and return in form of String
	 * @param locator
	 * @return String pageTitle
	 */
	public String doGetPageTitle() 
	{ 
		return driver.getTitle();
	}

	/**
	 * This method wait for the expected title of page
	 * to be loaded & fetches the title of current WebPage 
	 * and return in form of String
	 * @param locator
	 * @return String pageTitle
	 */
	public String waitForPageTitleToBe(String title) { 
		String text = null;
		wait.until(ExpectedConditions.titleIs(title));
		text = driver.getTitle();
		return text;
	}

	/**
	 * This method fetches window handles available
	 * for the current situation on the browser
	 * @param driver
	 * @return listOfString
	 */
	public List<String> getWindowList()
	{
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowHandlesList = new ArrayList<String>(windowHandles);
		return windowHandlesList;
	}

	/**
	 * This method switches to the given window id
	 * in the parameter
	 * @param driver
	 * @param windowNumber
	 */
	public void switchToWindowId(int windowNumber)
	{
		List<String> windowList = getWindowList();
		driver.switchTo().window(windowList.get(windowNumber));
	}

	/**
	 * This method returns the list of WebElement
	 * having a specific tag name given as parameter
	 * @param htmlTagName
	 * @param driver
	 * @return
	 */
	public List<WebElement> getTagCount(String htmlTagName, WebDriver driver)
	{
		List<WebElement> tagList = driver.findElements(By.tagName(htmlTagName));
		return tagList;
	}

	/**
	 * This method returns the list of WebElement attribute value
	 * having a specific tag name given as parameter
	 * @param htmlTagName
	 * @param driver
	 * @return String text value for the WebElement's AttributeName
	 */
	public String getAttributeValue(By locator, String AttributeName)
	{
		WebElement attributeValue = driver.findElement(locator);
		return attributeValue.getAttribute(AttributeName);
	}

	/**
	 * This method waits until the URL having
	 * the string snippet using urlContains method
	 * @param titlesnippet
	 */
	public void waitForUrlWithTextContains(String titlesnippet)
	{
		wait.until(ExpectedConditions.urlContains(titlesnippet));
	}

	/**
	 * This method waits until the title of WebPage having
	 * the string snippet using titleContains method
	 * @param titlesnippet
	 */
	public void waitForTitle(String titlesnippet)
	{
		wait.until(ExpectedConditions.titleContains(titlesnippet));
	}

	/**
	 * This method selects the value from the
	 * drop down by selectByValue method
	 * @param locator
	 * @param Value
	 */
	public void selectByValueFromDropDown(By locator, String Value)
	{
		Select selectElement = new Select(getElement(locator));
		selectElement.selectByValue(Value);
	}
	
	/**
	 * This method selects the value from the
	 * drop down by selectByVisibleText method
	 * @param locator
	 * @param Value
	 */
	public void selectByVisibleTextFromDropDown(By locator, String Value)
	{
		Select selectElement = new Select(getElement(locator));
		selectElement.selectByVisibleText(Value);
	}
	
	/**
	 * This method selects the value from the
	 * drop down by selectByVisibleText method
	 * @param locator
	 * @param Value
	 */
	public void selectByIndexFromDropDown(By locator, int indexNo)
	{
		Select selectElement = new Select(getElement(locator));
		selectElement.selectByIndex(indexNo);
	}
	
	

	
	
}
