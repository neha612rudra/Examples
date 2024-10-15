package com.mystore.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.mystore.testcases.WebDriverContext;

public class UtilityHelper {

	public static void scrollElementIntoView(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)WebDriverContext.getDriverInstance();
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
}
