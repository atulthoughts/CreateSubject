package com.qa.trialcomplete.tests;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.trialcomplete.base.TestBase;
import com.qa.trialcomplete.pages.HomePage;
import com.qa.trialcomplete.pages.LoginPage;
import com.trialcomplete.qa.*;

public class LoginTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage; 
	TestUtil testutil;
	
	public LoginTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@BeforeMethod
	public void setUp() throws IOException {
		intialization();
		testutil = new TestUtil();
		loginPage = new LoginPage();
	}
	
	@Test(priority=1)
	public void loginTest() throws IOException {		
		homePage = loginPage.Login(prop.getProperty("userName"), prop.getProperty("password"), prop.getProperty("siteName"));
		assertTrue(homePage.verifyGlobalTimer());
		
	}
	
//	@AfterMethod
//	public void tearDown() {
//		driver.quit();
//	}

}
