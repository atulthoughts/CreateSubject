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
//	
//	@FindBy(xpath= "//*[@class='imed-icon imed-icon-Tadmin']")
//	WebElement trialAdmin;
//	
//	@FindBy(xpath= "//*[@class='imed-icon imed-icon-Tadmin']")
//	WebElement trialAdmin;
//	
//	@FindBy(xpath= "//*[@class='imed-icon imed-icon-Tadmin']")
//	WebElement trialAdmin;
//	
//	@FindBy(xpath= "//*[@class='imed-icon imed-icon-Tadmin']")
//	WebElement trialAdmin;
//	
//	@FindBy(xpath= "//*[@class='imed-icon imed-icon-Tadmin']")
//	WebElement trialAdmin;

	
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

}

