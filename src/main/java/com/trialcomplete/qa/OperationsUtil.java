package com.trialcomplete.qa;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.qa.trialcomplete.base.TestBase;

public class OperationsUtil extends TestBase{
	
	public OperationsUtil() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean selectDropDownValue(WebElement dropDown, String value) throws InterruptedException {
		dropDown.sendKeys(value);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[text()='"+ value +"']")));
		action.moveToElement(driver.findElement(By.xpath("//*[text()='"+ value +"']"))).click().build().perform();
		
		return true;
		
	}
	
	public boolean jscriptClickButton(WebElement button) throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(button));
		js.executeScript("arguments[0].click();", button);
		
		return true;
		
	}

	public String getRandomNumber() {
		String randomN = String.valueOf(System.currentTimeMillis());
		randomN = randomN.substring(randomN.length()-2, randomN.length());
		return randomN;
	}

}
