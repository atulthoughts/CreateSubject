package com.qa.trialcomplete.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.tools.ant.util.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.google.common.io.Files;
import com.trialcomplete.qa.VariablesUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop; 
	public static WebDriverWait wait;  
	public static Actions action;
	public static JavascriptExecutor js;
	public static String OS; 
	public static ExtentReports extentReport; //--03.02.2020---
	
	public static ExtentTest test;
	public static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>(); //----05.02.2021---

	//---Event listener Code-----02.02.2021
	public static EventFiringWebDriver e_Driver;
//	public static WebEventListner eventListner; 
	
	
	public TestBase() throws IOException {
		// TODO Auto-generated constructor stub
		prop = new Properties();
		FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\com\\trialcomplete\\qa\\config\\config.properties");
		//---variable path---C:\\Users\\thoraatu\\JAN2021
		prop.load(ip);
		
		
	}
	
	public static WebDriver intialization() throws IOException {
		String browser = prop.getProperty("browser");
		
		if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\WW300950\\Nilesh\\chromedriver_win32\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();	
			
		}
		
//		//----Code for listener----------02.02.2021
//		e_Driver = new EventFiringWebDriver(driver);
//		eventListner = new WebEventListner();
//		e_Driver.register(eventListner);
//		driver = e_Driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(VariablesUtil.implcitwait, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(VariablesUtil.pageload, TimeUnit.SECONDS);
		
		wait = new WebDriverWait(driver, VariablesUtil.pageload);
		
		driver.get(prop.getProperty("url"));
		
		js = (JavascriptExecutor)driver;
		action = new Actions(driver);
		
		TestBase.configExtentReport();//---03.02.2021---
		return driver;
	}
	
	public static String takeScreenShot(String testName, WebDriver driver) throws IOException {//---02.02.2021---
		
		File scrFile = (File) ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); //****
		String curDir = System.getProperty("user.dir");
		String OS = System.getProperty("os.name").toLowerCase();
		
		File DestFile=new File(curDir + "\\screenshots\\" + testName + ".png");
		
		if(OS.contains("win")) {			
			Files.copy(scrFile, DestFile);
//			FileUtils.copyFile(scrFile, DestFile);
		}else {
			
		}
		return curDir + "\\screenshots\\" + testName + ".png"; 
	}
	public static void configExtentReport() {//---03.02.2021----
		String path = System.getProperty("user.dir") + "\\reports\\index.html";
		
		ExtentSparkReporter reporter = new ExtentSparkReporter(path); 
		reporter.config().setReportName("Web Automation Result");
		reporter.config().setDocumentTitle("Test Automatoin Result");
		
		extentReport = new ExtentReports();
		extentReport.attachReporter(reporter);
		extentReport.setSystemInfo("Tester", "Atul Thorat");		
	}	
	

}
