package com.qa.trialcomplete.tests;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.trialcomplete.base.TestBase;
import com.qa.trialcomplete.pages.HomePage;
import com.qa.trialcomplete.pages.LoginPage;
import com.qa.trialcomplete.pages.SubjectPage;
import com.trialcomplete.qa.*;

public class CreateSubjectTest  extends TestBase{
	
	TestUtil testutil;
	LoginPage loginPage;
	HomePage homePage; 
	SubjectPage subject;
	String sheetName = "Subjects";
	WebDriver driver;

	public CreateSubjectTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@BeforeClass
	public void setUp() throws IOException {
		driver = intialization();
		testutil = new TestUtil();
		loginPage = new LoginPage();
	}	
	
	

	
	@Test(priority=1)
	public void login() throws IOException {
		try {
		test.log(Status.INFO, "Logging into Application");
		}catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
		homePage = loginPage.Login(prop.getProperty("userName"), prop.getProperty("password"), prop.getProperty("siteName"));
		test.log(Status.INFO, "Successfully logged");
		test.log(Status.INFO, "Navigating to Subject Page");
		subject = homePage.navigateToSubjectIdentity();		
	}
	
	
	@DataProvider
	public Object[][] getSubjectData() throws IOException {
		Object data [][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=2, dataProvider="getSubjectData")
	public void createSubject(String bDate, String ftName, String ltName, String gender, String lan) throws IOException, InterruptedException {//01.02.2021
		
		try {			
			//--31.01.2021--
			test.log(Status.INFO, "Creating Subject");
			
			String fname = "A" + String.valueOf(System.currentTimeMillis());
			System.out.println("Creating Subject: "+bDate +", " + fname +", " + ltName +", " + gender +", " + lan);
			
			subject.createSubject(bDate, fname, ltName, gender, lan);
			Assert.assertTrue(true);
		}
		catch(Exception e) {
			extentReport.flush();
			System.out.println(e);
		}
	}
	
	
	
//	@Test
//	public void getData() throws IOException {
//		Object data [][] = TestUtil.getTestData(sheetName);
//	}

}
