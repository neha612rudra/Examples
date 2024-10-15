package com.mystore.testcases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mystore.pageobject.UserLogin;
import com.mystore.utilities.ReadExcelFile;
import com.mystore.utilities.WaitHelper;

import junit.framework.Assert;

import com.mystore.pageobject.HomePage;
import com.mystore.pageobject.RegisteredUserAccount;

public class TC_VerifyUserLoginDataDrivenTesting extends BaseClass {
	
	@Test(dataProvider="LoginDataProvider")
	public void verifyUserLogin(String email,String userPwd,String expectedUsername) throws InterruptedException,IOException
	{
		HomePage hp=new HomePage(driver);
		hp.clickOnSignIn();
		
		UserLogin cl=new UserLogin(driver);
		cl.enterEmailId(email);
		logger.info("Email ID is entered in Customer Login page");
		cl.enterPassword(userPwd);
		logger.info("Password has been entered");
		cl.clickOn_SignInButton();
		logger.info("Clicked on Sign In button");
		
		RegisteredUserAccount ra=new RegisteredUserAccount(driver);
		String displayedUserName=ra.getUserName();
		
		WaitHelper.waitForSeconds(3);
//		Assert.assertEquals("Welcome, Niharika Singh!", displayedUserName);
		
		if(displayedUserName.equals(expectedUsername))
		{
			logger.info("Verify Login-Passed");
			Assert.assertTrue(true);
			ra.clickOn_logOutbtnList();
			ra.clickOn_logOutbtn();
		}
		else
		{
			logger.info("Verify Login-Fail");
			captureScreenshot(driver,"verifyUserLogin");
			Assert.assertTrue(false);
		}      
	}
	
	@DataProvider(name="LoginDataProvider")
	public String[][] LoginDataProvider()
	{
	
		String fileName=System.getProperty("user.dir")+"\\TestData\\MyStoreTestData.xlsx";
		int totalRows=ReadExcelFile.getRowCount(fileName, "LoginTestData");
		int totalColumn=ReadExcelFile.getColCount(fileName, "LoginTestData");
		
		String data[][]=new String[totalRows-1][totalColumn];
		for(int i=1;i<totalRows;i++)   
		{
			for(int j=0;j<totalColumn;j++)
			{
				data[i-1][j]=ReadExcelFile.getCellValue(fileName, "LoginTestData", i, j);
			}
		}
		return data;
		
	}

}
