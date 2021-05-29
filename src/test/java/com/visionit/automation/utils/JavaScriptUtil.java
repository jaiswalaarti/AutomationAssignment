package com.visionit.automation.utils;

import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author Sarang Holey
 *	This class having all general java script 
 *	method used to interact with HTML DOM 
 */
public class JavaScriptUtil {

	// WebDriver Instance Variable
	WebDriver driver;

	/**
	 *  Parameterize Constructor to connect driver
	 *  with another class driver instance variable
	 * @param driver
	 */
	public JavaScriptUtil(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * This method will flash the specified WebElement 
	 * @param WebElement variable
	 */
	public void flash(WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String bgcolor = element.getCssValue("backgroundColor");
		for (int i = 0; i < 15; i++) {
			changeColor("rgb(0,200,0)", element);// 1
			changeColor(bgcolor, element);// 2
		}
	}

	/**
	 * This method will change the existing color of WebElement to the specified 
	 * color in the argument String color of this method
	 * @param WebElements color
	 * @param WebElement variable
	 */
	private void changeColor(String color, WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);

		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
		}
	}

	/**
	 * This method will return the current 
	 * title of WebPage as String
	 * @return String
	 */
	public String getTitleByJS() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript("return document.title;").toString();
	}

	/**
	 * This method will refresh the page
	 * where the currently driver instance is focused on
	 */
	public void refreshBrowserByJS() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("history.go(0)");
	}

	/**
	 * This method will generate an alert on current WebPage with 
	 * String value as parameter message
	 * @param message
	 */
	public void generateAlert(String message) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("alert('" + message + "')");
	}

	/**
	 * This method will return the inner page text 
	 * available for the current HTML WebPage
	 * @return String
	 */
	public String getPageInnerText() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript("return document.documentElement.innerText;").toString();
	}
	
	/**
	 * This method will click on the WebElement specified in the argument
	 * @param WebElement element
	 */
	public void clickElementByJS(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	
	/**
	 * This method will send text to the WebElement which is 
	 * having an HTML id attribute is available in DOM
	 * @param String id
	 * @param String value
	 */
	public void sendKeysUsingJSWithId(String id, String value) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("document.getElementById('" + id + "').value='" + value + "'");
	}

	/**
	 * This method will send text to the WebElement which is 
	 * having an HTML name attribute is available
	 * @param String name
	 * @param String value
	 */
	public void sendKeysUsingJSWithName(String name, String value) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("document.getElementByName('" + name + "').value='" + value + "'");
	}
	
	public void sendKeysValueByCSSJavaScript(String elementCSSValue, String valueTobeEntered) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("document.querySelector('"+elementCSSValue+"').value='"+valueTobeEntered+"'");
	}

	/**
	 * This method will scroll down the WebPage to the bottom end
	 */
	public void scrollPageDown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	/**
	 * This method will scroll down the page
	 * till the height value is mentioned
	 * @param String height
	 */
	public void scrollPageDown(String height) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, '" + height + "')");
	}

	/**
	 * This method will scroll up the WebPage to the top of 
	 * the page height
	 */
	public void scrollPageUp() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(document.body.scrollHeight, 0)");
	}

	/**
	 * This method will scroll the WebPage until 
	 * the element is not visible on the page
	 * @param WebElement variable
	 */
	public void scrollIntoView(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	/**
	 * This method will draw a solid red color border to the WebElement 
	 * @param WebElement variable
	 */
	public void drawBorder(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='3px solid red'", element);
	}
	
	/**
	 * This method open a new blank tab in the current
	 * browser instance 
	 */
	public void openNewWindowTab()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.open();");
		ArrayList<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(windowHandles.get(1));
	}
	
	/**
	 * This method will return the browser information 
	 * in the form of String
	 * @return String
	 */
	public String getBrowserInfo() {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String uAgent = js.executeScript("return navigator.userAgent;").toString();
		return uAgent;
	}
	


}
