package com.sis.scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.GenericUtilities.ExcelUtility;
import com.GenericUtilities.FileUtility;
import com.GenericUtilities.JavaUtility;
import com.GenericUtilities.WebDriverUtility;
import com.sis.ObjRepo.AdminLoginPage;

public class AdminLoginScriptTest {

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
				
		AdminLoginPage cat = new AdminLoginPage(driver);
		cat.LoginPage(username, password, driver);
		
		//wLib.acceptAlert(driver);
		
		System.out.println("successfully admin login into application");
		//driver.close();

	}

}
