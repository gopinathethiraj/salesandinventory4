package com.sis.scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.GenericUtilities.ExcelUtility;
import com.GenericUtilities.FileUtility;
import com.GenericUtilities.JavaUtility;
import com.GenericUtilities.WebDriverUtility;
import com.sis.ObjRepo.AddCustomerPage;
import com.sis.ObjRepo.AddSupplierPage;
import com.sis.ObjRepo.AdminHomePage;
import com.sis.ObjRepo.AdminLoginPage;
import com.sis.ObjRepo.CustomerPage;
import com.sis.ObjRepo.SupplierPage;

public class CreateSupplierTest {

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
		ah.supplierModule();
		
		//wLib.acceptAlert(driver);
		SupplierPage sp=new SupplierPage(driver);
		sp.addsupplierbuttonModule();
		
		AddSupplierPage cus= new AddSupplierPage(driver);
		
		String Companyname = eLib.readDataFromExcel("Sheet1",0,1)+jLib.getRandomNo();
		String Phonenumber = eLib.readDataFromExcel("Sheet1",3,1)+jLib.getRandomNo();
		
		String albay = "Abra";
		String city ="Bangued"
				;
		System.out.println(Companyname+"  "+albay+"  "+city+"  "+Phonenumber);
		cus.companynametextfield(Companyname, albay, city, Phonenumber, wLib);
		Thread.sleep(1000);
		cus.getSavebutton().click();
		
		
	}

}
