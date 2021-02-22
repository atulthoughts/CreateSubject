package com.qa.trialcomplete.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.trialcomplete.base.TestBase;
import com.trialcomplete.qa.OperationsUtil;

public class ScrFupPage extends TestBase{

	OperationsUtil perfromAction;
	public ScrFupPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="*[class*='imed-icon-plus']")
	WebElement plusIcon;
	
	@FindBy(xpath = "//*[text()='Create New Screening/Follow Up(SCR_FUP)']/parent::div/parent::ng-component//input[@formcontrolname='name']")
	WebElement nameField;
	
	@FindBy(xpath = "//*[@formcontrolname='epoch']//input")
	WebElement epochField;
	
	@FindBy(xpath = "//*[@formcontrolname='epochPart']//input")
	WebElement epochPartField;
	
	@FindBy(xpath = "//*[text()='Create Screening / Follow Up Setup']/parent::button")
	WebElement buttonCreate;
	
	public boolean createScrFup(String name, String epoch, String part) throws IOException, InterruptedException{
		
		perfromAction =  new OperationsUtil();
		perfromAction.jscriptClickButton(plusIcon);
		
		name = name + perfromAction.getRandomNumber();
		
		nameField.sendKeys(name);
		
		perfromAction.selectDropDownValue(epochField, epoch);
		
		perfromAction.selectDropDownValue(epochPartField, part);
		
		perfromAction.jscriptClickButton(buttonCreate);
		
		return true;
	}
	
	
	
	
 
	
	

}
