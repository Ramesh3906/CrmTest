package com.crm.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


import com.crm.TestBase.TestBase;

public class TestUtil extends TestBase{

	public static long PageLoadWaitTime=10;
	public static long ImplicityLoadWaitTime=20;
	public static String Test_Sheet_Data="C:\\Users\\ramur\\testing_workplcce\\CRMAutomationTest\\src\\main\\resources\\TestData\\TestData.xlsx";
	
	 static  Workbook Book;
	 static Sheet sheet;
	
	public static void switchFrames(){
		driver.switchTo().frame("mainpanel");
	}
	
	
	
	public static Object[][] GetTestData(String SheetName){
		FileInputStream file=null;
		try {
			file=new FileInputStream(Test_Sheet_Data);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Book=WorkbookFactory.create(file);
			
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sheet=Book.getSheet(SheetName);
		Object [][]data=new Object [sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i=0;i<sheet.getLastRowNum();i++)
		{
			for(int k=0;k<sheet.getRow(0).getLastCellNum();k++){
			data[i][k]=sheet.getRow(i+1).getCell(k).toString();
			
			}
		}
		
		
		return data;
		
			
	}
}
