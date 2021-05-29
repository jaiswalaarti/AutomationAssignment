package com.visionit.automation.utils;

/**
 * @author Sarang Holey
 *	This class holding up methods
 *	to pause the script for certain
 *	amount of time
 *	Note : Avoid using this utility unless its
 *	very much needed 
 */
public class WaitUtil {

	/**
	 * This method will pause the script for 3000 milliseconds
	 */
	public static void shortWait() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method will pause the script for 6000 milliseconds
	 */
	public static void mediumWait() {
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method will pause the script for 10000 milliseconds
	 */
	public static void longWait() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
