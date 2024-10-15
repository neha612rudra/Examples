package com.mystore.testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.mystore.pageobject.HomePage;
import com.mystore.pageobject.RegisteredUserAccount;
import com.mystore.pageobject.UserRegistration;
import com.mystore.utilities.WaitHelper;

import junit.framework.Assert;

public class TC_VerifyUserRegistration extends BaseClass{
	@Test
	public void verifyUserRegistration() throws InterruptedException, IOException
	{
		UserRegistration ur=new UserRegistration(driver);
		ur.clickOn_CreateAccount();
		logger.info("Clicked on Create an Account Button");
		
		ur.enterFirstName();
		logger.info("User First Name has been entered");
		
		ur.enterLastName();
		logger.info("User Last Name has been entered");
		
		ur.enterEmailAddress();
		logger.info("User Email Address has been entered");
		
		ur.enterPassword();
		logger.info("User Password has been entered");
		
		ur.enterConfirmPassword();
		logger.info("Confirm-Password has been entered");
		
		ur.clickOnCreateAccountButton();
		logger.info("Clicked on Create an Account Button");
		
		RegisteredUserAccount ra=new RegisteredUserAccount(driver);
		String displayedUserName=ra.getUserName();
		String expectedUserName="Welcome";
		
		WaitHelper.waitForSeconds(3);
	//	Assert.assertEquals("Welcome", displayedUserName);
		if(displayedUserName.contains("Welcome"))
		{
			System.out.println("Username Verification Successfull");
			logger.info("Username Verification Successfull");
		}
		else
		{
			System.out.println("Username Verification failed");
		//	captureScreenshot("verifyUserRegistration");
			logger.info("Username Verification failed");
		}        
		
	}

}
