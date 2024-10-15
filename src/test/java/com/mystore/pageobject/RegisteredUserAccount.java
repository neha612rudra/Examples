package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.utilities.WaitHelper;

public class RegisteredUserAccount {
	WebDriver driver;
//	WebDriverWait wait;

	public RegisteredUserAccount(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[contains(text(), 'Welcome')]")
	private WebElement registeredUserName;
	
	@FindBy(xpath="//span[text()='Change']")
	private WebElement logOutbtnList;
	
	@FindBy(xpath="//li[@class='authorization-link']/a[1]")
	private WebElement logOutBtn;
	
	public void clickOn_logOutbtnList()
	{
		logOutbtnList.click();
	}
	
	public void clickOn_logOutbtn()
	{
		logOutBtn.click();
	}
	
	public String getUserName()
	{
		WaitHelper.waitForElementVisibility(registeredUserName);
		String text=registeredUserName.getText();
		System.out.println("displayedUserName="+text);
		return text;
	}
	
	

}
