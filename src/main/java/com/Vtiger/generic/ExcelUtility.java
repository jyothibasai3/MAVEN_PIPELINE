package com.Vtiger.generic;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ExcelUtility {
	public String readDataFromExcel(String sheetname,int rownum,int cellnum) throws Throwable  
	{
		FileInputStream fis=new FileInputStream("C:\\Users\\Welcome\\OneDrive\\Desktop\\salary.xlsx");
		return WorkbookFactory.create(fis).getSheet(sheetname).getRow(rownum).getCell(cellnum).getStringCellValue();
	}

		public int readNumericDataFromExcel(String sheetname,int rownum,int cellnum) throws Throwable
		{
			FileInputStream fis=new FileInputStream("C:\\Users\\Welcome\\OneDrive\\Desktop\\salary.xlsx");
			int value = (int) WorkbookFactory.create(fis).getSheet(sheetname).getRow(rownum).getCell(cellnum).getNumericCellValue();
			return value;
		}
		public int getLastRow(String sheetname) throws Throwable 
		{
			FileInputStream fis=new FileInputStream("C:\\Users\\Welcome\\OneDrive\\Desktop\\salary.xlsx");
			int lastrow=WorkbookFactory.create(fis).getSheet(sheetname).getLastRowNum();
			return lastrow;
		}
		
		
}
