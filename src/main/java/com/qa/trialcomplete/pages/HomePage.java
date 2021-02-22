package com.qa.trialcomplete.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.trialcomplete.base.TestBase;

public class HomePage extends TestBase{

	//Modified to checkin into Git
	
	public HomePage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className = "tc-global-timer")
	List<WebElement> globalTimer;
	
//	@FindBy(how = How.ID_OR_NAME, using = "")
	
	//---NAVIGATION Menus-----
	@FindBy(xpath= "//*[@class='imed-icon imed-icon-Tadmin']")
	@CacheLookup
	WebElement trialAdmin;
	
	@FindBy(xpath= "//*[@class='imed-icon imed-icon-tsubject']")
	WebElement trialSubject;
	
	@FindBy(xpath= "//*[text()='Subject Identity']")
	WebElement subjectIdentity;
	
	@FindBy(xpath= "//*[@class='imed-icon imed-icon-tdesigner']")
	WebElement trialDesign;
	
	@FindBy(xpath= "//*[text()='Study Management']")
	WebElement studyManagement;
	
	@FindBy(xpath= "//*[text()=' Administrative Data ']")
	WebElement studyAdminData;
	
	@FindBy(xpath= "//*[text()='Study Flow']")
	WebElement studyFlow;
	
	@FindBy(xpath= "//*[text()=' Screening/Follow Up(SCR_FUP) ']")
	WebElement scrFup;
	
	@FindBy(xpath= "//*[text()=' Treatment Template ']")
	WebElement trtemplate;
	
	
	//-----We can find the elements of the same characteristic-----
	@FindAll({	    
	    @FindBy(className="username-field")
	  })
	private WebElement user_name;
	
	public boolean verifyGlobalTimer() {
		if(globalTimer.size() > 0) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public SubjectPage navigateToSubjectIdentity() throws IOException {

		wait.until(ExpectedConditions.visibilityOf(trialSubject));
		
		js.executeScript("arguments[0].click();", trialSubject);
		js.executeScript("arguments[0].click();", subjectIdentity);

		
		return new SubjectPage();
		
	}
	
	public StudyPage navigateToStudyAdmin() throws IOException {

		wait.until(ExpectedConditions.visibilityOf(trialDesign));
		
		js.executeScript("arguments[0].click();", trialDesign);
		js.executeScript("arguments[0].click();", studyManagement);
		js.executeScript("arguments[0].click();", studyAdminData);
		
		return new StudyPage();
		
	}
	
	public ScrFupPage navigateToScrFup() throws IOException {

		wait.until(ExpectedConditions.visibilityOf(trialDesign));
		
		js.executeScript("arguments[0].click();", trialDesign);
		js.executeScript("arguments[0].click();", studyFlow);
		js.executeScript("arguments[0].click();", scrFup);
		
		return new ScrFupPage();
		
	}
	
	public TemplatePage navigateToTrtTemplate() throws IOException {

		wait.until(ExpectedConditions.visibilityOf(trialDesign));
		
		js.executeScript("arguments[0].click();", trialDesign);
		js.executeScript("arguments[0].click();", studyFlow);
		js.executeScript("arguments[0].click();", trtemplate);
		
		return new TemplatePage();
		
	}
	
	

}

