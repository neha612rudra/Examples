package com.mystore.testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.mystore.pageobject.UserLogin;
import com.mystore.utilities.WaitHelper;

import junit.framework.Assert;

import com.mystore.pageobject.HomePage;
import com.mystore.pageobject.RegisteredUserAccount;

public class TC_VerifyUserLogin extends BaseClass {
	@Test
	public void verifyUserLogin() throws InterruptedException,IOException
	{
		HomePage hp=new HomePage(driver);
		hp.clickOnSignIn();
		
		UserLogin cl=new UserLogin(driver);
		cl.enterEmailId("niharika4263chaudhary@gmail.com");
		logger.info("Email ID is entered in Customer Login page");
		cl.enterPassword("sunil@neha_123");
		logger.info("Password has been entered");
		cl.clickOn_SignInButton();
		logger.info("Clicked on Sign In button");
		
		RegisteredUserAccount ra=new RegisteredUserAccount(driver);
		String displayedUserName=ra.getUserName();
		
		WaitHelper.waitForSeconds(3);
		Assert.assertEquals("Welcome, Niharika Singh!", displayedUserName);
		
		if(displayedUserName.equals("Welcome, Niharika Singh!"))
		{
			logger.info("Verify Login-Passed");
			Assert.assertTrue(true);
		}
		else
		{
			logger.info("Verify Login-Fail");
			captureScreenshot(driver,"verifyUserLogin");
			Assert.assertTrue(false);
		}      
	}

}
