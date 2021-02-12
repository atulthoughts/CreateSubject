package com.qa.trialcomplete.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.qa.trialcomplete.base.TestBase;

public class LoginPage extends TestBase{

	public LoginPage() throws IOException {
		super();		
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}	
	
	//Page factory OR:
	@FindBy(id="login-user-control")
	WebElement loginField;
	
	@FindBy(xpath="//*[@type='button' and @value='Next']")
	WebElement nextButton;
	
	@FindBy(id="login-password-control")
	WebElement passwordField;
	
	@FindBy(css=".ui-dropdown-trigger-icon")
	WebElement dropdown;
	
	@FindBy(xpath = "//*[@role='listbox']//*[text()='']")
	WebElement site;
	
	@FindBy(xpath = "//button[text()='Log In']")
	WebElement logInButton;
	
	//***Actions********
	
	
	public HomePage Login(String userName, String passWord, String siteName) throws IOException {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		loginField.sendKeys(userName);
		
		js.executeScript("arguments[0].click();",nextButton);
		passwordField.sendKeys(passWord);
		
		  
		js.executeScript("arguments[0].click();",dropdown);
		
		Actions action = new Actions(driver);	
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@role='listbox']//*[text()='"+ siteName +"']")));
		WebElement site = driver.findElement(By.xpath("//*[@role='listbox']//*[text()='"+ siteName +"']"));
		
		js.executeScript("arguments[0].click();",site);
		//action.moveToElement(site).click().build().perform();
		
		js.executeScript("arguments[0].click();",logInButton);
//		action.moveToElement(logInButton).click().build().perform();
		
		return new HomePage();
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
