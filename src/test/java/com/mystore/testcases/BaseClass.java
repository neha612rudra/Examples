package com.mystore.testcases;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.*;

import com.mystore.utilities.ReadConfig;

public class BaseClass {
	ReadConfig readConfig=new ReadConfig();
	String url=readConfig.getBaseUrl();
	String browser=readConfig.getBrowser();
	
	protected WebDriver driver;
	public static Logger logger;
	
	@BeforeClass
	public void setupDriver()
	{
		String browser="chrome";
		switch(browser.toLowerCase())
		{
			case "chrome":
				driver=new ChromeDriver();
				break;
				
			case "firefox":
				driver=new FirefoxDriver();
				break;
				
			case "msedge":
				driver=new EdgeDriver();
				break;
				
			default:
				driver=null;
				break;
		}
		WebDriverContext.setDriver(driver);
		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		logger=LogManager.getLogger("MyStoreV1");
		
		driver.get(url);
		logger.info("Browser is launched");
	}
	
	@AfterClass
	public void teardown()
	{
		driver.close();
		driver.quit();
	}
	
	public void captureScreenshot(WebDriver driver, String testName) throws IOException
	{
		//step1:Convert webdriver object to TakeScreenshot interface
		TakesScreenshot screenshot=((TakesScreenshot)driver);
		
		//step2:Call getScreenshotAs method to create image file
		File src=screenshot.getScreenshotAs(OutputType.FILE);
		File dest=new File(System.getProperty("user.dir")+ "\\screenshots\\"+testName+".png");
		
		//step3:Copy image file to destination
		FileUtils.copyFile(src, dest);
	}  

}
