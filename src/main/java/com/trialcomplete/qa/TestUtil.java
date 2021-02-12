package com.trialcomplete.qa;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.qa.trialcomplete.base.TestBase;

public class TestUtil extends TestBase{
	
	public static String TESTDATA_SHEET_NAME = System.getProperty("user.dir")+"\\src\\main\\java\\com\\trialcomplete\\testdata\\SubjectData.xlsx";
	static Workbook book;
	static Sheet sheet;
	
	public static Object[][] getTestData(String sheetName) throws IOException{
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_NAME);			
			
		}catch(FileNotFoundException e) {
			System.out.println(e.getLocalizedMessage());			
		}
		try {
			book = WorkbookFactory.create(file);
		}catch(InvalidFormatException excep) {
			System.out.println(excep.getLocalizedMessage());
		}
		sheet = book.getSheet(sheetName);
		int rows = sheet.getLastRowNum();
		int columns = sheet.getRow(0).getLastCellNum();		
		Object[][] data = new Object[rows][columns];
		
		for(int i = 0; i< rows; i++) {
			for(int j = 0; j < columns; j++) {
				data[i][j]= sheet.getRow(i + 1).getCell(j).toString();
			}
			
		}
		
		return data;		
	}
	
	
	public TestUtil() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//--Switching to Frame----------
	public void switchToFrame() {
		driver.switchTo().frame("Sahar");
	} 
	
	

}
