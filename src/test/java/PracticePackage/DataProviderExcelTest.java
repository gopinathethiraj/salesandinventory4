package PracticePackage;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.GenericUtilities.ExcelUtility;

public class DataProviderExcelTest {
	@Test(dataProvider = "makeMyTrip")
	public void readData(String from, String to)
	{
		System.out.println(from+"--->"+to);
	}
	
	@Test(dataProvider = "getData")
	public void readDataFromExcel(String from, String to)
	{
		System.out.println(from+"--->"+to);
	}
	
	@DataProvider
	public Object[][] getData() throws Throwable
	{
		ExcelUtility eLib = new ExcelUtility();
		Object[][] value = eLib.readMultipleSetOfData("DataProvider");
		return value;
		
	}
	@DataProvider
	public Object[][] makeMyTrip() throws Throwable
	{
		ExcelUtility eLib = new ExcelUtility();
		Object[][] value = eLib.readMultipleSetOfData("MakeMyTRip");
		return value;
		
	}
	
	

}
