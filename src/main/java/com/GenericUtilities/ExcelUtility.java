package com.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public String readDataFromExcel(String SheetName, int RowNo, int ColoumnNo) throws Throwable
	{
		FileInputStream fi = new FileInputStream(Ipathconstants.Excelpath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(SheetName);
		Row ro = sh.getRow(RowNo);
		Cell cel = ro.getCell(ColoumnNo);
		String value = cel.getStringCellValue();
		return value;
	}
	public void writeDataIntoExcel(String SheetName, int RowNo,int ColoumnNo, String data) throws Throwable
	{
		FileInputStream fi = new FileInputStream(Ipathconstants.Excelpath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(SheetName);
		Row ro = sh.createRow(RowNo);
		Cell cel = ro.createCell(ColoumnNo);
		cel.setCellValue(data);
		FileOutputStream fos= new FileOutputStream(Ipathconstants.Excelpath);
		wb.write(fos);
		}
	public int getLastRowNo(String SheetName) throws Throwable
	{
		FileInputStream fi = new FileInputStream(Ipathconstants.Excelpath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(SheetName);
		int count = sh.getLastRowNum();
		return count;
		}
	public Object[][] readMultipleSetOfData(String SheetName) throws Throwable
	{
		FileInputStream fi = new FileInputStream(Ipathconstants.Excelpath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(SheetName);
		int lastRow = sh.getLastRowNum()+1;
		int lastCell = sh.getRow(0).getLastCellNum();
		
		Object[][] Obj = new Object[lastRow][lastCell];
		for(int i=0; i<lastRow; i++) // row
		{
			for(int j=0; j<lastCell; j++)
			{
				Obj[i][j] = sh.getRow(i).getCell(j).getStringCellValue();
			}
		
		
		}
		return Obj;
	}	
		
	
	public Map<String, String> getList(String sheetName, int keyCell, int ValueCell) throws Throwable 
	
	{
		FileInputStream fi = new FileInputStream(Ipathconstants.Excelpath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(sheetName);
		int count = sh.getLastRowNum();
		Map<String, String> map=new HashMap<String, String>();
	for(int i=0; i<=count; i++)
	{
		String key = sh.getRow(i).getCell(keyCell).getStringCellValue();
		String value = sh.getRow(i).getCell(ValueCell).getStringCellValue();
		map.put(key, value);
	}
	return map;
	
	}
		
	}


