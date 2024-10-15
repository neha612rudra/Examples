package com.mystore.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentListenerClass implements ITestListener{
	
	public ExtentSparkReporter htmlReporter;
	public ExtentReports reports;
	public ExtentTest tests;
	
	public void configureReport()
	{
		ReadConfig rc=new ReadConfig();
		String timestamp=new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());
		String reportName="MyStoreTestReport-"+timestamp+".html";
		htmlReporter =new ExtentSparkReporter(System.getProperty("user.dir")+"//Reports//"+reportName);
		reports=new ExtentReports();
		reports.attachReporter(htmlReporter);
		
		//add system information to reports
		reports.setSystemInfo("Machine","TestPC1");
		reports.setSystemInfo("OS","Window10");
		reports.setSystemInfo("Browser",rc.getBrowser());
		reports.setSystemInfo("User name","Niharika");
		
		//configuration to change look and feel of report
		htmlReporter.config().setDocumentTitle("Extent Listener Report Demo");
		htmlReporter.config().setReportName("This is my First Report");
		htmlReporter.config().setTheme(Theme.DARK);
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Name of the Test method started:"+result.getName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Name of the Test method successfully executed:"+result.getName());
		tests=reports.createTest(result.getName());
		tests.log(Status.PASS,MarkupHelper.createLabel("Name of the Test Case successfully get executed:"+result.getName(), ExtentColor.GREEN));
		
		
	}

	//When test case get failed, this method is called
	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Name of the Test Method failed:"+result.getName());
		tests=reports.createTest(result.getName());
		tests.log(Status.FAIL,MarkupHelper.createLabel("Name of the failed Test Case is:"+result.getName(), ExtentColor.RED));
	//This code attaches the screenshot in screenshot folder
		String screenShotPath=System.getProperty("user.dir")+"\\screenshots\\"+result.getName()+".png";
		File screenShotFile=new File(screenShotPath);
		if(screenShotFile.exists())
		{
			tests.fail("Captured Screenshot is below:"+tests.addScreenCaptureFromPath(screenShotPath));
		}
	//	tests.addScreenCaptureFromPath(null);
	}  

	@Override
	public void onTestSkipped(ITestResult result) {
		tests=reports.createTest(result.getName());
		tests.log(Status.SKIP,MarkupHelper.createLabel("Name of the skipped Test Case is:"+result.getName(), ExtentColor.YELLOW));
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		
		configureReport();
		System.out.println("On Start method invoked....");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("On Finished method invoked....");
		reports.flush();
		
	}
}
