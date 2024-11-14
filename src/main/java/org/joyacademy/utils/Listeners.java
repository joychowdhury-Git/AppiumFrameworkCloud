package org.joyacademy.utils;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.appium.java_client.AppiumDriver;

public class Listeners implements ITestListener {
	
	AppiumDriver driver;
	
//	public Listeners(AppiumDriver driver) {
//		super(driver);	
//		//this.driver= driver;		
//	}

	ExtentTest test;
	ExtentReports extent = ExtentReporterNG.getReport();
	
	
	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		test.log(Status.PASS, "Test is passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		test.fail(result.getThrowable());

		try {
			driver =(AppiumDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
			} 
			catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e1) {
			e1.printStackTrace();
		} 
		
		try {
			test.addScreenCaptureFromPath(AppiumUtils.getScreeshotPath(result.getMethod().getMethodName(), driver), result.getMethod().getMethodName());
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
	}


	@Override
	public void onFinish(ITestContext context) {
	
		extent.flush();
		
	}

	
	
}
