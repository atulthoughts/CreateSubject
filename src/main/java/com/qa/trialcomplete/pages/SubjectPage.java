package com.qa.trialcomplete.pages;

import java.io.IOException;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.qa.trialcomplete.base.TestBase;

public class SubjectPage extends TestBase{

	public SubjectPage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="*[class*='imed-icon-plus']")
	WebElement plusIcon;
	
	@FindBy(xpath = "//*[@formcontrolname='birthDate']//input")
	WebElement birthDate;
	
	@FindBy(xpath = "//*[@formcontrolname='firstName']")
	WebElement fName;
	
	@FindBy(xpath = "//*[@formcontrolname='lastName']")
	WebElement lName;
	
	@FindBy(xpath = "//*[@formcontrolname='sex']//input")
	WebElement sexdropdownButton;
	
	@FindBy(xpath = "//*[@formcontrolname='language']//input")
	WebElement language;
	
	@FindBy(xpath = "//*[text()='Save']/parent::button")
	WebElement saveButton; 
	
	@FindBy(xpath = "//*[contains(@class, 'pi-calendar')]")
	WebElement calenderButton;
	
	@FindBy(xpath = "//*[contains(@class, 'ui-datepicker-year')]")
	WebElement datePickerYear;
	
	@FindBy(xpath = "//*[contains(@class, 'ui-datepicker-month')]")
	WebElement datePickerMonth;
	
	public boolean createSubject(String bDate, String ftName, String ltname, String gender, String lan) throws IOException, InterruptedException {
		
		Thread.sleep(6000);
		wait.until(ExpectedConditions.visibilityOf(plusIcon));
		
		action.moveToElement(plusIcon).click().build().perform();
		
		wait.until(ExpectedConditions.visibilityOf(calenderButton));
		
		selectBirthDate(bDate);
		fName.sendKeys(ftName);
		lName.sendKeys(ltname);
		
		sexdropdownButton.sendKeys(gender);
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[text()='"+ gender +"']")));
		action.moveToElement(driver.findElement(By.xpath("//*[text()='"+ gender +"']"))).click().build().perform();
		
		language.sendKeys(lan);
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[text()='"+ lan +"']")));
		action.moveToElement(driver.findElement(By.xpath("//*[text()='"+ lan +"']"))).click().build().perform();

		wait.until(ExpectedConditions.elementToBeClickable(saveButton));
		js.executeScript("arguments[0].click();", saveButton);
		
		return false;
		
	}

	private void selectBirthDate(String bDate) {
		// TODO Auto-generated method stub
		wait.until(ExpectedConditions.visibilityOf(calenderButton));
//		action.moveToElement(calenderButton).click().build().perform();
		js.executeScript("arguments[0].click();", calenderButton);
//		calenderButton.click();
		String Str = new String(bDate);
		String[] oDate = Str.split(Pattern.quote("."));
		
		
		Select objSelect =new Select(datePickerYear);
		
		
		objSelect.selectByVisibleText(oDate[2]);
		
		Select objSelect1 =new Select(datePickerMonth);
		
		switch(oDate[1]) 
        { 
            case "JAN": 
            	oDate[1] = "January"; 
                break; 
            case "FEB": 
            	oDate[1] = "February"; 
                break; 
            case "MAR": 
            	oDate[1] = "March"; 
                break;
            case "APR": 
            	oDate[1] = "April"; 
                break;
            case "MAY": 
            	oDate[1] = "May"; 
                break;
            case "JUN": 
            	oDate[1] = "June"; 
                break;
            case "JUL": 
            	oDate[1] = "July"; 
                break;
            case "AUG": 
            	oDate[1] = "August"; 
                break;
            case "SEP": 
            	oDate[1] = "September"; 
                break;
            case "OCT": 
            	oDate[1] = "October"; 
                break;
            case "NOV": 
            	oDate[1] = "November"; 
                break;
            case "DEC": 
            	oDate[1] = "December"; 
                break;
            default: 
                System.out.println("no match"); 
        } 
		
		objSelect1.selectByVisibleText(oDate[1]);
		
		driver.findElement(By.xpath("//*[@class='calendar-control']//div[text()=' "+ oDate[0] +"']")).click();
		
		driver.findElement(By.xpath("//span[text()='Select']/parent::button")).click();
		
		
	}
	
	
	
}
