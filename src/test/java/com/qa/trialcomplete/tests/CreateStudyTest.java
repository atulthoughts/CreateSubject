package com.qa.trialcomplete.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.trialcomplete.base.TestBase;
import com.qa.trialcomplete.pages.HomePage;
import com.qa.trialcomplete.pages.LoginPage;
import com.qa.trialcomplete.pages.StudyPage;
import com.qa.trialcomplete.pages.SubjectPage;
import com.trialcomplete.qa.TestUtil;

public class CreateStudyTest extends TestBase{
	
	TestUtil testutil;
	LoginPage loginPage;
	HomePage homePage; 
	StudyPage study;
	String sheetName = "Studies";
//	WebDriver driver;
	
	
	
	public CreateStudyTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@BeforeClass
	public void setUp() throws IOException {
//		driver = intialization();
		testutil = new TestUtil();
//		loginPage = new LoginPage();
	}
	
//	@Test(enabled = false)
//	public void login() throws IOException {
//		try {
//		test.log(Status.INFO, "Logging into Application");
//		}catch(Exception e) {
//			System.out.println(e.getLocalizedMessage());
//		}
//		homePage = loginPage.Login(prop.getProperty("userName"), prop.getProperty("password"), prop.getProperty("siteName"));
//		test.log(Status.INFO, "Successfully logged-in");
//		test.log(Status.INFO, "Navigating to Study Page");
//		study = homePage.navigateToStudyAdmin();		
//	}
	
	@DataProvider
	public Object[][] getStudyData() throws IOException {
		Object data [][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	
	@Test(priority=1, dataProvider="getStudyData")
	public void createStudy(String studyN, String studyLabel, String sponsor, String randomization, String plannedEnroll, String preSuspString, String allowMultiEnrol, ITestContext context) throws IOException, InterruptedException {//01.02.2021
		
		try {	
			
			homePage = (HomePage) context.getAttribute("hmpg");
			
			study = homePage.navigateToStudyAdmin();
			//--31.01.2021--
			test.log(Status.INFO, "Creating Subject");
			
			String fname = "A" + String.valueOf(System.currentTimeMillis());
			System.out.println("Creating Study: "+studyN +", " + studyLabel +", " + sponsor +", " + randomization +", " + plannedEnroll +", " + allowMultiEnrol);
			
			study.createStudy(studyN, studyLabel, sponsor, randomization, plannedEnroll, preSuspString, allowMultiEnrol);
			Assert.assertTrue(true);
		}
		catch(Exception e) {
			extentReport.flush();
			System.out.println(e);
		}
	}
	

}
