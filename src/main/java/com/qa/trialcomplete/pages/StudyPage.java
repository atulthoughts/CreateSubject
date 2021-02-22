package com.qa.trialcomplete.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.qa.trialcomplete.base.TestBase;
import com.trialcomplete.qa.OperationsUtil;

public class StudyPage extends TestBase{

	OperationsUtil perfromAction; 
	
	public StudyPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[text()='New Study']/parent::button")
	WebElement NewStudyButton;
	
	@FindBy(css="[formcontrolname='studyNumber']")
	WebElement studyName;
	
	@FindBy(css="[formcontrolname='studyLabel']")
	WebElement studyLbl;
	
	@FindBy(xpath="//*[@formcontrolname = 'sponsor']//input")
	WebElement sponsorDropDown;
	
	@FindBy(xpath="//*[text()='Study Description']/parent::a")
	WebElement decripTab;
	
	@FindBy(xpath="//*[text()='Study Planning Dates']/parent::a")
	WebElement planningTab;
	
	@FindBy(xpath="//*[@formcontrolname = 'randomization']//input")
	WebElement random;
	
	@FindBy(xpath="//*[@formcontrolname = 'preSuspensionCode']//input")
	WebElement preSuspension;
	
	@FindBy(xpath="//*[@formcontrolname = 'allowEnrolment']//input")
	WebElement allowEnroll;
	
	@FindBy(xpath = "//*[text()='Save']/parent::button")
	WebElement saveButton;
	
	@FindBy(xpath = "//*[@class='modal-content']//*[text()=' Yes '][@type='button']")
	WebElement confrmYesButton;
	
	@FindBy(xpath = "//*[text()='Study']/parent::div[contains(@class, 'tc-header-dropdown-parent')]//button")
	WebElement studyDropDown;	
	
	@FindBy(xpath = "//*[text()='More...']/parent::li")
	WebElement moreLink;
	
	@FindBy(xpath = "//*[@placeholder = 'Enter Study Name or Study Sponsor']")
	WebElement searchBox;
	
	@FindBy(xpath = "//*[text()= 'Apply']/parent::button")
	WebElement applyButton;
	
	public boolean createStudy(String studyN, String studyLabel, String sponsor, String randomization, String plannedEnroll, String preSuspString,String allowMultiEnrol) throws InterruptedException, IOException {
		
		perfromAction = new OperationsUtil();
		
		wait.until(ExpectedConditions.visibilityOf(NewStudyButton));
		
		action.moveToElement(NewStudyButton).click().build().perform();
		
//		wait.until(ExpectedConditions.visibilityOf(calenderButton));
		String randomN = perfromAction.getRandomNumber();
		
		studyN = studyN + randomN ;
		studyLabel = studyLabel + randomN;
		
		studyName.sendKeys(studyN);
		studyLbl.sendKeys(studyLabel);
		
		//--------Can be replaced by DropDwon Method-------
//		sponsorDropDown.sendKeys(sponsor);
//		
//		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[text()='"+ sponsor +"']")));
//		action.moveToElement(driver.findElement(By.xpath("//*[text()='"+ sponsor +"']"))).click().build().perform();
		//-------------
		perfromAction.selectDropDownValue(sponsorDropDown, sponsor);
		
		//Select description tab
//		decripTab.click();
		action.moveToElement(decripTab).click().build().perform();
		perfromAction.selectDropDownValue(random, randomization);
		
		//--Select planning tab
//		planningTab.click();
		action.moveToElement(planningTab).click().build().perform();
		perfromAction.selectDropDownValue(preSuspension, preSuspString);
		
		//---Select multiple enrollments---
		perfromAction.selectDropDownValue(allowEnroll, allowMultiEnrol);
		
		perfromAction.jscriptClickButton(saveButton);
		
		perfromAction.jscriptClickButton(confrmYesButton);
		
		return true;
		
	}
	
	public boolean selectStudyTopMenu() {
		
		
		
		
		return true;		
	}

}
