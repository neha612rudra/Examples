package com.mystore.utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mystore.testcases.WebDriverContext;

public class WaitHelper {
	private WebDriver driver;
	private static WebDriverWait wait;
	
	public static void waitForElementVisibility(WebElement element) {
		wait = new WebDriverWait(WebDriverContext.getDriverInstance(), Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void waitForElementClickable(WebElement element) {
		wait = new WebDriverWait(WebDriverContext.getDriverInstance(), Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public static void waitForSeconds(int n) throws InterruptedException {
		Thread.sleep(n*1000);
	}
}
