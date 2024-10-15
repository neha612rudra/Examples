package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.utilities.UtilityHelper;

public class UserLogin {
	WebDriver driver;

	public UserLogin(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "email")
	WebElement emailId;
	
	@FindBy(id = "pass")
	WebElement password;
	
	@FindBy(id="send2")
	WebElement signInButton;

	public void enterEmailId(String emailAddress)
	{
		emailId.sendKeys(emailAddress);
		
	}
	
	public void enterPassword(String emailPassword)
	{
		password.sendKeys(emailPassword);
		
	}

	public void clickOn_SignInButton()
	{
		UtilityHelper.scrollElementIntoView(signInButton);
		signInButton.click();
	}
}
