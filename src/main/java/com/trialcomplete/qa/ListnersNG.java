package com.trialcomplete.qa;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.IReporter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.trialcomplete.base.TestBase;
import com.qa.trialcomplete.pages.SubjectPage;

public class ListnersNG extends TestBase implements ITestListener {
	
//	ExtentTest test;
//	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>(); //----05.02.2021---
	
	public ListnersNG() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
//		ITestListener.super.onTestStart(result);
		test = extentReport.createTest(result.getMethod().getMethodName());//---04.02.2021--
		extentTest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		// TODO Auto-generated method stub
		extentTest.get().log(Status.PASS, "Test Passed");
		
//		WebDriver driver=null;
//		ITestListener.super.onTestSuccess(result);		
		
//		try {
//			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
////			SubjectPage ty = (SubjectPage)result.getTestClass().getRealClass().getDeclaredField("subject").get(result.getInstance());
//		} catch (Exception e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		} 
		//----Screen Shot----
		String testName1 = result.getMethod().getMethodName();
		try {
			
			String fileName = takeScreenShot(testName1, driver);			
			extentTest.get().addScreenCaptureFromPath(fileName, testName1);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		// TODO Auto-generated method stub
		extentTest.get().log(Status.FAIL, result.getThrowable());
		WebDriver driver = null;
//		ITestListener.super.onTestFailure(result);		
//		try {
//			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
//		} catch (Exception e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		} 
		
		//----Screen Shot----
		String testName = result.getMethod().getMethodName();
		try {
			
			String fileName = takeScreenShot(testName, driver);			
			extentTest.get().addScreenCaptureFromPath(fileName, testName);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
//		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
//		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
//		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
//		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
//		ITestListener.super.onFinish(context);
		extentReport.flush();
	}
	

}
