package com.mystore.testcases;

import org.openqa.selenium.WebDriver;

public class WebDriverContext {

	private static ThreadLocal<WebDriver> context = new ThreadLocal<WebDriver>();
	
	public static void setDriver(WebDriver driver) {
		context.set(driver);
		
	}
	
	public static WebDriver getDriverInstance() {
		return context.get();
	}
	
//	public static void removeDriverInstance() {
//		context.remove();
//	}
}
