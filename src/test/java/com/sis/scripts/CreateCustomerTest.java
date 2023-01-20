package com.sis.scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.GenericUtilities.ExcelUtility;
import com.GenericUtilities.FileUtility;
import com.GenericUtilities.JavaUtility;
import com.GenericUtilities.WebDriverUtility;
import com.sis.ObjRepo.AddCustomerPage;
import com.sis.ObjRepo.AdminHomePage;
import com.sis.ObjRepo.AdminLoginPage;
import com.sis.ObjRepo.CustomerPage;

public class CreateCustomerTest {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		JavaUtility jLib = new JavaUtility();
		ExcelUtility eLib = new ExcelUtility();
		FileUtility fLib = new FileUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		
		   
		String url = fLib.readDataFromPropertyFile("url");
		String username = fLib.readDataFromPropertyFile("username");
		String password = fLib.readDataFromPropertyFile("password");
		String browser = fLib.readDataFromPropertyFile("browser");
		
		   
		
		WebDriver driver = new ChromeDriver();
		
		wLib.maximizeWindow(driver);
		driver.get(url);
		wLib.waitForPageLoad(driver);
		
		AdminLoginPage lp = new AdminLoginPage(driver);
		lp.LoginPage(username, password, driver);
		
		//wLib.acceptAlert(driver);
		
		AdminHomePage hp=new AdminHomePage(driver);
		hp.getCustomer().click();
		
		CustomerPage cp=new CustomerPage(driver);
		cp.addcustomerbuttonModule();
		
		AddCustomerPage cus= new AddCustomerPage(driver);
		
		String firstname = eLib.readDataFromExcel("Sheet4",0,1)+jLib.getRandomNo();
		String lastname = eLib.readDataFromExcel("Sheet4",1,1)+jLib.getRandomNo();
		String phonenumber = eLib.readDataFromExcel("Sheet4",2,1)+jLib.getRandomNo();
		cus.firstnametextfield(firstname, lastname, phonenumber);
		Thread.sleep(1000);
		cus.getSavebutton().click();
		
		

	}
	   
}
