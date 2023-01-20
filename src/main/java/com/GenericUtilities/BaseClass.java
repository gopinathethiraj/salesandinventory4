package com.GenericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.sis.ObjRepo.AdminHomePage;
import com.sis.ObjRepo.AdminLoginPage;

public class BaseClass {
	
	public WebDriver driver;
	static WebDriver sdriver;
	public DatabaseUtility dLib = new DatabaseUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public FileUtility fLib = new FileUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	
	@BeforeSuite
	public void configDB()
	{
		//dLib.connectToDB();
		System.out.println("---Connect To DB server");
	}
	//@Parameters("Browser")
	@BeforeClass
	public void configBC() throws Throwable
	{ 
		String Browser = fLib.readDataFromPropertyFile("browser");
		String URL = fLib.readDataFromPropertyFile("url");
		if(Browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		else if (Browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else
		{
			System.out.println("Browser is invalid");
			
		}
	    sdriver = driver;
		wLib.maximizeWindow(driver);
		wLib.waitForPageLoad(driver);  
		driver.get(URL);
		System.out.println("--- Launch the browser");
		}
	@BeforeMethod
	public void configBM() throws Throwable
	{
		String username = fLib.readDataFromPropertyFile("username");
		String password = fLib.readDataFromPropertyFile("password");
		AdminLoginPage lp = new AdminLoginPage(driver);
		lp.LoginPage(username, password, driver);
		System.out.println("--Login to application");
	}
	@AfterMethod
	public void configAM()
	{
		AdminHomePage ah = new AdminHomePage(driver);
		ah.logoutModule();
		System.out.println("Logout from application");
		
	}
	@AfterClass
	public void configAC()
	{
		driver.quit();
		System.out.println("---close the browser---");
	}
	@AfterSuite
	public void disconnectDB()
	{
		//d.Lib.closeDB();
		System.out.println("---DisConnect from DB server");
	}
	

}
