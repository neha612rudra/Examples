package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.testcases.BaseClass;

public class UserRegistration extends BaseClass{
	WebDriver driver;

	public UserRegistration(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Create an Account")
	WebElement createAccount;
	
	@FindBy(id="firstname")
	WebElement firstName;
	
	@FindBy(id="lastname")
	WebElement lastName;
	
	@FindBy(id="email_address")
	WebElement emailAddress;
	
	@FindBy(id="password")
	WebElement emailPassword;
	
	@FindBy(id="password-confirmation")
	WebElement confirmPassword;
	
	@FindBy(xpath="//button[@title='Create an Account']")
	WebElement clickCreateAccButton;
	
	public void clickOn_CreateAccount()
	{
		createAccount.click();
	}
	
	public void enterFirstName()
	{
		firstName.sendKeys("Tanishq");
	}
	
	public void enterLastName()
	{
		lastName.sendKeys("Singh");
	}
	
	public void enterEmailAddress()
	{
		emailAddress.sendKeys("tanishq876_niharika_xyzsingh@gmail.com");
	}
	
	public void enterPassword()
	{
		emailPassword.sendKeys("tanishq_567t1@money");
	}
	
	public void enterConfirmPassword()
	{
		confirmPassword.sendKeys("tanishq_567t1@money");
	}
	
	public void clickOnCreateAccountButton()
	{
		clickCreateAccButton.click();
	}
}
