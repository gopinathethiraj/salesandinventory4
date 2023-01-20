package com.sis.scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.GenericUtilities.ExcelUtility;
import com.GenericUtilities.FileUtility;
import com.GenericUtilities.JavaUtility;
import com.GenericUtilities.WebDriverUtility;
import com.sis.ObjRepo.AccountsPage;
import com.sis.ObjRepo.AddUserAccountPage;
import com.sis.ObjRepo.AdminHomePage;
import com.sis.ObjRepo.AdminLoginPage;
import com.sis.ObjRepo.ProductPage;

public class AddUserAccountTest {

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
		
		AdminHomePage ah = new AdminHomePage(driver);
		ah.accountsModule();
		
		AccountsPage ap = new AccountsPage(driver);
		ap.accountsModule();
		AddUserAccountPage tiger = new AddUserAccountPage(driver);
		
		String usernameTF= eLib.readDataFromExcel("Sheet2", 0, 1);
		String passwordTF = eLib.readDataFromExcel("Sheet2", 1, 1);
		tiger.enteruseraccountdetails(usernameTF, passwordTF, wLib);
		

	}

}
