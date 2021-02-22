package com.qa.trialcomplete.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.trialcomplete.base.TestBase;
import com.qa.trialcomplete.pages.HomePage;
import com.qa.trialcomplete.pages.LoginPage;
import com.qa.trialcomplete.pages.ScrFupPage;
import com.qa.trialcomplete.pages.StudyPage;
import com.trialcomplete.qa.TestUtil;

public class CreateScrTest extends TestBase{
	
	TestUtil testutil;
	LoginPage loginPage;
	HomePage homePage; 
	ScrFupPage scrFup;
	String sheetName = "ScrFup";
	
	
	
	public CreateScrTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@BeforeClass
	public void setUp() throws IOException {
//		driver = intialization();
		testutil = new TestUtil();
//		loginPage = new LoginPage();
	}
	
	@DataProvider
	public Object[][] getScrData() throws IOException {
		Object data [][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=1, dataProvider="getScrData")
	public void createScreening(String name, String epoch, String part, ITestContext context) throws IOException, InterruptedException {//01.02.2021
		
		try {	
			
			homePage = (HomePage) context.getAttribute("hmpg");
			
			scrFup = homePage.navigateToScrFup();
			//--31.01.2021--
			test.log(Status.INFO, "Creating Screening");
			
			System.out.println("Creating Scr: "+name +", " + epoch +", " + part);
			
			scrFup.createScrFup(name, epoch, part);
			Assert.assertTrue(true);
		}
		catch(Exception e) {
			extentReport.flush();
			System.out.println(e);
		}
	}

}
